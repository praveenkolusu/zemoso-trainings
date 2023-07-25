package com.zmslabs.minet.service;

import com.zmslabs.minet.model.AddFundsWalletDTO;
import com.zmslabs.minet.model.WalletDTO;

public interface WalletService {
    WalletDTO createWallet(WalletDTO walletDTO);

    WalletDTO addFundsToWallet(AddFundsWalletDTO addFundsWalletDTO);
}
