package com.zmslabs.minet.controller;
import com.zmslabs.minet.model.AssetDTO;
import com.zmslabs.minet.service.AssetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

  class AssetControllerTest {
    @Mock
    private AssetService assetService;

    @InjectMocks
    private AssetController assetController;

    @BeforeEach
      void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
      void testPostAssets() {
        // Mock data
        AssetDTO assetDTO = new AssetDTO();
        AssetDTO assetDtoResponse = new AssetDTO();

        // Mock AssetService behavior
        when(assetService.postAsset(assetDTO)).thenReturn(assetDtoResponse);

        // Call the method under test
        ResponseEntity<AssetDTO> responseEntity = assetController.postAssets(assetDTO);

        // Verify the interactions and assertions
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(assetDtoResponse, responseEntity.getBody());
    }
}
