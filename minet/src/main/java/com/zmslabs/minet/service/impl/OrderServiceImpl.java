package com.zmslabs.minet.service.impl;

import com.zmslabs.minet.entity.*;
import com.zmslabs.minet.exception.DataNotFoundException;
import com.zmslabs.minet.exception.MinetAppException;
import com.zmslabs.minet.model.OrdersDTO;
import com.zmslabs.minet.model.OrdersResponseDTO;
import com.zmslabs.minet.repository.*;
import com.zmslabs.minet.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrdersService {
   private final UserRepository userRepository;
    private final AssetRepository assetRepository;
    private final WalletRepository walletRepository;

    private final TransactionRepository transactionRepository;
    private final HoldingRepository holdingRepository;

    @Override
    public OrdersResponseDTO buyAssets(OrdersDTO ordersDTO) {
        User user= userRepository.findById(ordersDTO.getUserId()).orElseThrow(()->new DataNotFoundException("user details not found"));
        Asset asset = assetRepository.findById(ordersDTO.getAssetId()).orElseThrow(()->new DataNotFoundException("asset details not found"));

        Wallet wallet = user.getWallet();
        Double transactionAmount= ordersDTO.getPrice() * ordersDTO.getQuantity();
        if(wallet.getBalance()<transactionAmount)
            throw new MinetAppException("Insufficient funds","9020");
        Transaction transaction =Transaction.builder()
                .type("BUY")
                .amount(transactionAmount)
                .user(user)
                .asset(asset).timestamp(LocalDateTime.now()).build();

        transactionRepository.save(transaction);

        wallet.setBalance(wallet.getBalance()-transactionAmount);
        walletRepository.save(wallet);
        Holding holding;
        Optional<Holding> optionalHolding= holdingRepository.findByUserAndAsset(user,asset);
        if(optionalHolding.isPresent()){
            holding= optionalHolding.get();
            holding.setAmount(holding.getAmount()+ transactionAmount);
            holding.setQuantity(holding.getQuantity()+ordersDTO.getQuantity());
            holding.setLastAcquisitionDate(LocalDateTime.now());
            holding.setLastAcquisitionAmount(ordersDTO.getPrice());
        }else{
            holding= Holding.builder().user(user).asset(asset)
                    .amount(transactionAmount).quantity(ordersDTO.getQuantity())
                    .lastAcquisitionDate(LocalDateTime.now())
                    .lastAcquisitionAmount(ordersDTO.getPrice())
                    .build();
        }
        holdingRepository.save(holding);

        return OrdersResponseDTO.builder().code("1000")
                .message("Buy Order Successful").build();
    }

    @Override
    public OrdersResponseDTO sellAssets(OrdersDTO ordersDTO) {
        User user= userRepository.findById(ordersDTO.getUserId()).orElseThrow(()->new DataNotFoundException("user details not found"));
        Asset asset = assetRepository.findById(ordersDTO.getAssetId()).orElseThrow(()->new DataNotFoundException("asset details not found"));

        Double transactionAmount= ordersDTO.getPrice()* ordersDTO.getQuantity();
        Transaction transaction =Transaction.builder()
                .type("BUY")
                .amount(transactionAmount)
                .user(user)
                .asset(asset).timestamp(LocalDateTime.now()).build();

        transactionRepository.save(transaction);

        Wallet wallet= user.getWallet();
        wallet.setBalance(wallet.getBalance()+transactionAmount);
        walletRepository.save(wallet);

        Optional<Holding> optionalHolding= holdingRepository.findByUserAndAsset(user,asset);
        if(optionalHolding.isPresent() && optionalHolding.get().getQuantity()>ordersDTO.getQuantity()){
            Holding  holding= optionalHolding.get();
            holding.setAmount(holding.getAmount()- transactionAmount);
            holding.setQuantity(holding.getQuantity()-ordersDTO.getQuantity());
            holding.setLastAcquisitionDate(LocalDateTime.now());
            holding.setLastAcquisitionAmount(ordersDTO.getPrice());
            holdingRepository.save(holding);
        }else if(optionalHolding.isPresent() && optionalHolding.get().getQuantity().equals(ordersDTO.getQuantity())){
            holdingRepository.delete(optionalHolding.get());
        }
        return OrdersResponseDTO.builder().code("1000")
                .message("Sell Order Successful").build();
    }
}
