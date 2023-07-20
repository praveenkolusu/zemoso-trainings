package com.zmslabs.minet.service.impl;

import com.zmslabs.minet.entity.User;
import com.zmslabs.minet.entity.Wallet;
import com.zmslabs.minet.exception.DataNotFoundException;
import com.zmslabs.minet.model.AddFundsWalletDTO;
import com.zmslabs.minet.model.WalletDTO;
import com.zmslabs.minet.repository.UserRepository;
import com.zmslabs.minet.repository.WalletRepository;
import com.zmslabs.minet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
   private final WalletRepository walletRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    @Override
    public WalletDTO createWallet(WalletDTO walletDTO) {
        User user= userRepository.findById(walletDTO.getUserId()).orElseThrow(()->new DataNotFoundException("user details not found"));
        Wallet wallet=modelMapper.map(walletDTO,Wallet.class);
        wallet.setUser(user);
        wallet=walletRepository.save(wallet);
        return modelMapper.map(wallet,WalletDTO.class);
    }

    @Override
    public WalletDTO addFundsToWallet(AddFundsWalletDTO addFundsWalletDTO) {
         Wallet wallet = walletRepository.findById(addFundsWalletDTO.getWalletId())
                .orElseThrow(()-> new DataNotFoundException("Wallet details not found"));
         wallet.setBalance(wallet.getBalance()+ addFundsWalletDTO.getAmount());
        wallet=walletRepository.save(wallet);
        return modelMapper.map(wallet,WalletDTO.class);
    }
}
