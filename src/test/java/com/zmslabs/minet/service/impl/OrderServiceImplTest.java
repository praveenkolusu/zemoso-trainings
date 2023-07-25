package com.zmslabs.minet.service.impl;

import com.zmslabs.minet.entity.Asset;
import com.zmslabs.minet.entity.Holding;
import com.zmslabs.minet.entity.User;
import com.zmslabs.minet.entity.Wallet;
import com.zmslabs.minet.exception.DataNotFoundException;
import com.zmslabs.minet.exception.MinetAppException;
import com.zmslabs.minet.model.OrdersDTO;
import com.zmslabs.minet.model.OrdersResponseDTO;
import com.zmslabs.minet.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {
    private UserRepository userRepository;
    private AssetRepository assetRepository;
    private WalletRepository walletRepository;
    private TransactionRepository transactionRepository;
    private HoldingRepository holdingRepository;
    private OrderServiceImpl orderService;

    @BeforeEach
      void setUp() {
        userRepository = mock(UserRepository.class);
        assetRepository = mock(AssetRepository.class);
        walletRepository = mock(WalletRepository.class);
        transactionRepository = mock(TransactionRepository.class);
        holdingRepository = mock(HoldingRepository.class);
        orderService = new OrderServiceImpl(userRepository, assetRepository, walletRepository,
                transactionRepository, holdingRepository);
    }

    @Test
      void testBuyAssets_Successful() {
        // Mock data
        Long userId = 1L;
        Long assetId = 1L;
        Double price = 100.0;
        Double quantity = 5.0;
        Wallet wallet = new Wallet(1l, 500.0,null);
        User user = User.builder().id(1l).wallet(wallet).build();

        Asset asset =  new Asset(1l, "Asset A","$");
        Holding holding = new Holding(1l, asset,user,500.0, 10, LocalDateTime.now(), price);

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(assetRepository.findById(assetId)).thenReturn(Optional.of(asset));
        when(holdingRepository.findByUserAndAsset(user, asset)).thenReturn(Optional.of(holding));

        OrdersDTO ordersDTO = new OrdersDTO(userId, assetId, 4, quantity);
        OrdersResponseDTO responseDTO = orderService.buyAssets(ordersDTO);

        // Verify the interactions and assertions
        assertEquals("1000", responseDTO.getCode());
        assertEquals("Buy Order Successful", responseDTO.getMessage());
        // Add more assertions as needed
    }

    @Test
      void testBuyAssets_NewHolding_Successful() {
        // Mock data
        Long userId = 1L;
        Long assetId = 1L;
        Double price = 100.0;
        Double quantity = 5.0;
        Wallet wallet = new Wallet(1l, 500.0,null);
        User user = User.builder().id(1l).wallet(wallet).build();

        Asset asset =  new Asset(1l, "Asset A","$");
        Holding holding = new Holding(1l, asset,user,500.0, 10, LocalDateTime.now(), price);

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(assetRepository.findById(assetId)).thenReturn(Optional.of(asset));
        when(holdingRepository.findByUserAndAsset(user, asset)).thenReturn(Optional.ofNullable(null));

        OrdersDTO ordersDTO = new OrdersDTO(userId, assetId, 4, quantity);
        OrdersResponseDTO responseDTO = orderService.buyAssets(ordersDTO);

        // Verify the interactions and assertions
        assertEquals("1000", responseDTO.getCode());
        assertEquals("Buy Order Successful", responseDTO.getMessage());
        // Add more assertions as needed
    }
    @Test
      void testBuyAssets_InsufficientFunds() {
        // Mock data
        Long userId = 1L;
        Long assetId = 1L;
        Double price = 100.0;
        Double quantity = 5.0;
        Wallet wallet = new Wallet(1l, 500.0,null);
        User user = User.builder().id(1l).wallet(wallet).build();

        Asset asset =  new Asset(1l, "Asset A","$");
        Holding holding = new Holding(1l, asset,user,500.0, 10, LocalDateTime.now(), price);


        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(assetRepository.findById(assetId)).thenReturn(Optional.of(asset));

        OrdersDTO ordersDTO = new OrdersDTO(userId, assetId, 6, price);

        // Verify that MinetAppException is thrown due to insufficient funds
        assertThrows(MinetAppException.class, () -> {
            orderService.buyAssets(ordersDTO);
        });
    }

    @Test
      void testSellAssets_Successful2() {
        // Mock data
        Long userId = 1L;
        Long assetId = 1L;
        Double price = 100.0;
        Double quantity = 3.0;
        Wallet wallet = new Wallet(1l, 500.0,null);
        User user = User.builder().id(1l).wallet(wallet).build();

        Asset asset =  new Asset(1l, "Asset A","$");
        Holding holding = new Holding(1l, asset,user,500.0, 10, LocalDateTime.now(), price);


        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(assetRepository.findById(assetId)).thenReturn(Optional.of(asset));
        when(holdingRepository.findByUserAndAsset(user, asset)).thenReturn(Optional.of(holding));

        OrdersDTO ordersDTO = new OrdersDTO(userId, assetId, 3, quantity);
        OrdersResponseDTO responseDTO = orderService.sellAssets(ordersDTO);

        // Verify the interactions and assertions
        assertEquals("1000", responseDTO.getCode());
        assertEquals("Sell Order Successful", responseDTO.getMessage());
        // Add more assertions as needed
    }

    @Test
    void testSellAssets_Successful() {
      // Mock data
      Long userId = 1L;
      Long assetId = 1L;
      Double price = 100.0;
      Double quantity = 3.0;
      Wallet wallet = new Wallet(1l, 500.0,null);
      User user = User.builder().id(1l).wallet(wallet).build();

      Asset asset =  new Asset(1l, "Asset A","$");
      Holding holding = new Holding(1l, asset,user,500.0, 10, LocalDateTime.now(), price);


      // Mock repository behavior
      when(userRepository.findById(userId)).thenReturn(Optional.of(user));
      when(assetRepository.findById(assetId)).thenReturn(Optional.of(asset));
      when(holdingRepository.findByUserAndAsset(user, asset)).thenReturn(Optional.ofNullable(null));

      OrdersDTO ordersDTO = new OrdersDTO(userId, assetId, 3, quantity);
      assertThrows(DataNotFoundException.class,()->orderService.sellAssets(ordersDTO));
      // Add more assertions as needed
    }

    @Test
      void testSellAssets_SellAllAssets() {
        // Mock data
        Long userId = 1L;
        Long assetId = 1L;
        Double price = 100.0;
        Double quantity = 5.0; // Requesting to sell all assets the user has
        Wallet wallet = new Wallet(1l, 500.0,null);
        User user = User.builder().id(1l).wallet(wallet).build();

        Asset asset =  new Asset(1l, "Asset A","$");
        Holding holding = new Holding(1l, asset,user,500.0, 10, LocalDateTime.now(), price);


        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(assetRepository.findById(assetId)).thenReturn(Optional.of(asset));
        when(holdingRepository.findByUserAndAsset(user, asset)).thenReturn(Optional.of(holding));
        doNothing(). when(holdingRepository).delete(holding);
        OrdersDTO ordersDTO = new OrdersDTO(userId, assetId, 10, price);
        OrdersResponseDTO responseDTO = orderService.sellAssets(ordersDTO);

        // Verify the interactions and assertions
        assertEquals("1000", responseDTO.getCode());
        assertEquals("Sell Order Successful", responseDTO.getMessage());
        // Verify that the holding entry is deleted from the database
    }
  @Test
  void testSellAssets_SellMoreAssetsThanExisting() {
    // Mock data
    Long userId = 1L;
    Long assetId = 1L;
    Double price = 100.0;
    Double quantity = 5.0; // Requesting to sell all assets the user has
    Wallet wallet = new Wallet(1l, 500.0,null);
    User user = User.builder().id(1l).wallet(wallet).build();

    Asset asset =  new Asset(1l, "Asset A","$");
    Holding holding = new Holding(1l, asset,user,500.0, 10, LocalDateTime.now(), price);


    // Mock repository behavior
    when(userRepository.findById(userId)).thenReturn(Optional.of(user));
    when(assetRepository.findById(assetId)).thenReturn(Optional.of(asset));
    when(holdingRepository.findByUserAndAsset(user, asset)).thenReturn(Optional.of(holding));

    OrdersDTO ordersDTO = new OrdersDTO(userId, assetId, 12, price);
    assertThrows(MinetAppException.class,()->orderService.sellAssets(ordersDTO)) ;


  }
  @Test
  void testSellAssets_UserNotFound() {
    // Mock data
    Long userId = 1L;
    Long assetId = 1L;
    Double quantity = 5.0;

    // Mock repository behavior
    when(userRepository.findById(userId)).thenReturn(Optional.empty());

    OrdersDTO ordersDTO = new OrdersDTO(userId, assetId, 4, quantity);

    // Verify that DataNotFoundException is thrown for the asset not found
    assertThrows(DataNotFoundException.class, () -> {
      orderService.sellAssets(ordersDTO);
    });
  }

  @Test
  void testSellAssets_AssetNotFound() {
    // Mock data
    Long userId = 1L;
    Long assetId = 1L;
    Double price = 100.0;
    Double quantity = 5.0;
    Wallet wallet = new Wallet(userId, 500.0,null);
    User user =User.builder().id(userId).name("praveen").wallet(wallet).build();

    // Mock repository behavior
    when(userRepository.findById(userId)).thenReturn(Optional.of(user));
    when(assetRepository.findById(assetId)).thenReturn(Optional.empty());

    OrdersDTO ordersDTO = new OrdersDTO(userId, assetId, 4, quantity);

    // Verify that DataNotFoundException is thrown for the asset not found
    assertThrows(DataNotFoundException.class, () -> {
      orderService.sellAssets(ordersDTO);
    });
  }

    @Test
      void testBuyAssets_AssetNotFound() {
        // Mock data
        Long userId = 1L;
        Long assetId = 1L;
        Double price = 100.0;
        Double quantity = 5.0;
        Wallet wallet = new Wallet(userId, 500.0,null);
        User user =User.builder().id(userId).name("praveen").wallet(wallet).build();

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(assetRepository.findById(assetId)).thenReturn(Optional.empty());

        OrdersDTO ordersDTO = new OrdersDTO(userId, assetId, 4, quantity);

        // Verify that DataNotFoundException is thrown for the asset not found
        assertThrows(DataNotFoundException.class, () -> {
            orderService.buyAssets(ordersDTO);
        });
    }

    @Test
      void testBuyAssets_UserNotFound() {
        // Mock data
        Long userId = 1L;
        Long assetId = 1L;
        Double price = 100.0;
        Double quantity = 5.0;
        Asset asset = new Asset(assetId, "Asset A","");

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        when(assetRepository.findById(assetId)).thenReturn(Optional.of(asset));

        OrdersDTO ordersDTO = new OrdersDTO(userId, assetId, 4, quantity);

        // Verify that DataNotFoundException is thrown for the user not found
        assertThrows(DataNotFoundException.class, () -> {
            orderService.buyAssets(ordersDTO);
        });
    }
}
