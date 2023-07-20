package com.zmslabs.minet.controller;

import com.zmslabs.minet.model.AddFundsWalletDTO;
import com.zmslabs.minet.model.WalletDTO;
import com.zmslabs.minet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wallet")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;
    @PostMapping
    public ResponseEntity<WalletDTO> createWallet(@RequestBody WalletDTO walletDTO){
        return new ResponseEntity<>(walletService.createWallet(walletDTO), HttpStatus.CREATED);
    }
    @PutMapping("/addToWallet")
    public  ResponseEntity<WalletDTO> addFundsToWallet(@RequestBody AddFundsWalletDTO addFundsWalletDTO){
        return new ResponseEntity<>(walletService.addFundsToWallet(addFundsWalletDTO),HttpStatus.OK);
    }
}
