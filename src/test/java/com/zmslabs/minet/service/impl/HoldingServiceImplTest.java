package com.zmslabs.minet.service.impl;

import com.zmslabs.minet.entity.Holding;
import com.zmslabs.minet.entity.User;
import com.zmslabs.minet.exception.DataNotFoundException;
import com.zmslabs.minet.repository.HoldingRepository;
import com.zmslabs.minet.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

  class HoldingServiceImplTest {
    private HoldingRepository holdingRepository;
    private UserRepository userRepository;
    private HoldingServiceImpl holdingService;

    @BeforeEach
      void setUp() {
        holdingRepository = mock(HoldingRepository.class);
        userRepository = mock(UserRepository.class);
        holdingService = new HoldingServiceImpl(holdingRepository, userRepository);
    }

    @Test
      void testGetUserHoldings_UserFound() {
        // Mock data
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        List<Holding> holdings = new ArrayList<>();
        Holding holding1 = new Holding();
        Holding holding2 = new Holding();
        holdings.add(holding1);
        holdings.add(holding2);

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(holdingRepository.findByUser(user)).thenReturn(holdings);

        // Call the method under test
        List<Holding> result = holdingService.getUserHoldings(userId);

        // Verify the interactions and assertions
        assertEquals(holdings, result);
    }

    @Test
      void testGetUserHoldings_UserNotFound() {
        // Mock data
        Long userId = 1L;

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Verify that DataNotFoundException is thrown for the user not found
        assertThrows(DataNotFoundException.class, () -> {
            holdingService.getUserHoldings(userId);
        });
    }
}

