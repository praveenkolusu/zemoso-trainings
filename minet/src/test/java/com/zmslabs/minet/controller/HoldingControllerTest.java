package com.zmslabs.minet.controller;

import com.zmslabs.minet.entity.Holding;
import com.zmslabs.minet.service.HoldingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

  class HoldingControllerTest {
    @Mock
    private HoldingService holdingService;

    @InjectMocks
    private HoldingController holdingController;

    private MockMvc mockMvc;

    @BeforeEach
      void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(holdingController).build();
    }

    @Test
      void testGetUserHoldings() throws Exception {
        // Mock data
        Long userId = 1L;
        List<Holding> holdings = new ArrayList<>();

        // Mock HoldingService behavior
        when(holdingService.getUserHoldings(userId)).thenReturn(holdings);

        // Perform GET request
        mockMvc.perform(get("/api/v1/holdings/users/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(holdings.size()));

        // Verify the interactions
        verify(holdingService, times(1)).getUserHoldings(userId);
    }
}
