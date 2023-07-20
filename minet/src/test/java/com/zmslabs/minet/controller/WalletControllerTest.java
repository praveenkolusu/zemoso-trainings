package com.zmslabs.minet.controller;
import com.zmslabs.minet.model.AddFundsWalletDTO;
import com.zmslabs.minet.model.WalletDTO;
import com.zmslabs.minet.service.WalletService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

  class WalletControllerTest {
    @Mock
    private WalletService walletService;

    @InjectMocks
    private WalletController walletController;

    private MockMvc mockMvc;

    @BeforeEach
      void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(walletController).build();
    }

    @Test
      void testCreateWallet() throws Exception {
        // Mock data
        WalletDTO walletDTO = new WalletDTO();
        WalletDTO walletDtoResponse = new WalletDTO();

        // Mock WalletService behavior
        when(walletService.createWallet(walletDTO)).thenReturn(walletDtoResponse);

        // Perform POST request
        mockMvc.perform(post("/api/v1/wallet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"balance\":0}")) // Replace with your JSON representation of walletDTO
                .andExpect(status().isCreated());

        // Verify the interactions
    }

    @Test
      void testAddFundsToWallet() throws Exception {
        // Mock data
        AddFundsWalletDTO addFundsWalletDTO = new AddFundsWalletDTO();
        WalletDTO walletDtoResponse = new WalletDTO();

        // Mock WalletService behavior
        when(walletService.addFundsToWallet(addFundsWalletDTO)).thenReturn(walletDtoResponse);

        // Perform PUT request
        mockMvc.perform(put("/api/v1/wallet/addToWallet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"walletId\":1,\"amount\":100}")) // Replace with your JSON representation of addFundsWalletDTO
                .andExpect(status().isOk());
        // Verify the interactions
    }
}
