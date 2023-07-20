package com.zmslabs.minet.service.impl;

import com.zmslabs.minet.entity.Asset;
import com.zmslabs.minet.entity.User;
import com.zmslabs.minet.entity.WatchList;
import com.zmslabs.minet.exception.DataNotFoundException;
import com.zmslabs.minet.model.WatchListDTO;
import com.zmslabs.minet.repository.AssetRepository;
import com.zmslabs.minet.repository.UserRepository;
import com.zmslabs.minet.repository.WatchListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

  class WatchListServiceImplTest {
    private UserRepository userRepository;
    private AssetRepository assetRepository;
    private WatchListRepository watchListRepository;
    private WatchListServiceImpl watchListService;

    @BeforeEach
      void setUp() {
        userRepository = mock(UserRepository.class);
        assetRepository = mock(AssetRepository.class);
        watchListRepository = mock(WatchListRepository.class);
        watchListService = new WatchListServiceImpl(userRepository, assetRepository, watchListRepository);
    }

    @Test
      void testAddToWatchList_Successful() {
        // Mock data
        Long userId = 1L;
        Long assetId = 1L;
        WatchListDTO watchListDTO = new WatchListDTO(1l,userId, assetId);
        User user = new User();
        Asset asset = new Asset();
        WatchList watchList = new WatchList();

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.of(User.builder().id(userId).build()));
        when(assetRepository.findById(assetId)).thenReturn(Optional.of(Asset.builder().id(assetId).build()));
        when(watchListRepository.save(any())).thenReturn(WatchList.builder().id(1L)
                .user(User.builder().id(userId).build())
                .asset(Asset.builder().id(assetId).build()).build());

        // Call the method under test
        WatchListDTO result = watchListService.addToWatchList(watchListDTO);

        // Verify the interactions and assertions
        assertNotNull(result.getId());
        assertEquals(userId, result.getUserId());
        assertEquals(assetId, result.getAssetId());
    }

    @Test
      void testAddToWatchList_UserNotFound() {
        // Mock data
        Long userId = 1L;
        Long assetId = 1L;
        WatchListDTO watchListDTO = new WatchListDTO(1l,userId, assetId);

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Verify that DataNotFoundException is thrown for the user not found
        assertThrows(DataNotFoundException.class, () -> {
            watchListService.addToWatchList(watchListDTO);
        });
    }

    @Test
      void testAddToWatchList_AssetNotFound() {
        // Mock data
        Long userId = 1L;
        Long assetId = 1L;
        WatchListDTO watchListDTO = new WatchListDTO(1l,userId, assetId);
        User user = new User();

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(assetRepository.findById(assetId)).thenReturn(Optional.empty());

        // Verify that DataNotFoundException is thrown for the asset not found
        assertThrows(DataNotFoundException.class, () -> {
            watchListService.addToWatchList(watchListDTO);
        });
    }

    @Test
      void testDeleteWatchListById() {
        // Mock data
        Long watchListId = 1L;

        // Call the method under test
        watchListService.deleteWatchListById(watchListId);

        // Verify the interactions and assertions
        verify(watchListRepository, times(1)).deleteById(watchListId);
    }
}

