package com.zmslabs.minet.controller;

import com.zmslabs.minet.model.WatchListDTO;
import com.zmslabs.minet.service.WatchListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

  class WatchListControllerTest {
    @Mock
    private WatchListService watchListService;

    @InjectMocks
    private WatchListController watchListController;

    @BeforeEach
      void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
      void testCreateWatchlist() {
        // Mock data
        WatchListDTO watchListDTO = new WatchListDTO();

        // Mock WatchListService behavior
        when(watchListService.addToWatchList(watchListDTO)).thenReturn(watchListDTO);

        // Call the method under test
        ResponseEntity<WatchListDTO> responseEntity = watchListController.createWatchlist(watchListDTO);

        // Verify the interactions and assertions
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(watchListDTO, responseEntity.getBody());
    }

    @Test
      void testDeleteWatchList() {
        // Mock data
        Long watchListId = 1L;

        // Call the method under test
        ResponseEntity<?> responseEntity = watchListController.deleteWatchList(watchListId);

        // Verify the interactions and assertions
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(watchListService, times(1)).deleteWatchListById(watchListId);
    }
}
