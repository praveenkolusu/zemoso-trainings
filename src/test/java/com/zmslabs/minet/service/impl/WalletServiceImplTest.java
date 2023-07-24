package com.zmslabs.minet.service.impl;
import com.zmslabs.minet.entity.User;
import com.zmslabs.minet.entity.Wallet;
import com.zmslabs.minet.exception.DataNotFoundException;
import com.zmslabs.minet.model.AddFundsWalletDTO;
import com.zmslabs.minet.model.WalletDTO;
import com.zmslabs.minet.repository.UserRepository;
import com.zmslabs.minet.repository.WalletRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

  class WalletServiceImplTest {
    private WalletRepository walletRepository;
    private ModelMapper modelMapper;
    private UserRepository userRepository;
    private WalletServiceImpl walletService;

    @BeforeEach
      void setUp() {
        walletRepository = mock(WalletRepository.class);
        modelMapper = mock(ModelMapper.class);
        userRepository = mock(UserRepository.class);
        walletService = new WalletServiceImpl(walletRepository, modelMapper, userRepository);
    }

    @Test
      void testCreateWallet() {
        // Mock data
        Long userId = 1L;
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setUserId(userId);
        Wallet wallet = new Wallet();

        // Mock repository and model mapper behavior
        when(userRepository.findById(userId)).thenReturn(Optional.of(new User()));
        when(modelMapper.map(walletDTO, Wallet.class)).thenReturn(wallet);
        when(walletRepository.save(wallet)).thenReturn(wallet);
        when(modelMapper.map(wallet, WalletDTO.class)).thenReturn(walletDTO);

        // Call the method under test
        WalletDTO result = walletService.createWallet(walletDTO);

        // Verify the interactions and assertions
        assertEquals(walletDTO, result);
    }

    @Test
      void testCreateWallet_UserNotFound() {
        // Mock data
        Long userId = 1L;
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setUserId(userId);

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Verify that DataNotFoundException is thrown for the user not found
        assertThrows(DataNotFoundException.class, () -> {
            walletService.createWallet(walletDTO);
        });
    }

     @Test
      void testAddFundsToWallet_Successful() {
        // Mock data
        Long walletId = 1L;
        Double initialBalance = 100.0;
        Double amountToAdd = 50.0;
        Wallet wallet = new Wallet(walletId, initialBalance, null);

        // Mock repository behavior
        when(walletRepository.findById(walletId)).thenReturn(Optional.of(wallet));

        AddFundsWalletDTO addFundsWalletDTO = new AddFundsWalletDTO(walletId, amountToAdd);

        // Call the method under test
        WalletDTO result = walletService.addFundsToWallet(addFundsWalletDTO);

        // Verify the interactions and assertions
        assertNull(result);
    }

    @Test
      void testAddFundsToWallet_WalletNotFound() {
        // Mock data
        Long walletId = 1L;
        Double amountToAdd = 50.0;

        // Mock repository behavior
        when(walletRepository.findById(walletId)).thenReturn(Optional.empty());

        AddFundsWalletDTO addFundsWalletDTO = new AddFundsWalletDTO(walletId, amountToAdd);

        // Verify that DataNotFoundException is thrown for the wallet not found
        assertThrows(DataNotFoundException.class, () -> {
            walletService.addFundsToWallet(addFundsWalletDTO);
        });
    }

    // Add more test cases for different scenarios as needed for better test coverage
}
