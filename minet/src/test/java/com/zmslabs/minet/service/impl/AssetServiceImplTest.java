package com.zmslabs.minet.service.impl;

import com.zmslabs.minet.entity.Asset;
import com.zmslabs.minet.exception.AssetNotFoundException;
import com.zmslabs.minet.model.AssetDTO;
import com.zmslabs.minet.repository.AssetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

  class AssetServiceImplTest {
    private AssetRepository assetRepository;
    private ModelMapper modelMapper;
    private AssetServiceImpl assetService;

    @BeforeEach
      void setUp() {
        assetRepository = mock(AssetRepository.class);
        modelMapper = mock(ModelMapper.class);
        assetService = new AssetServiceImpl(assetRepository, modelMapper);
    }

    @Test
      void testPostAsset() {
        // Mock data
        AssetDTO assetDTO = new AssetDTO();
        Asset asset = new Asset();
        Asset savedAsset = new Asset();
        AssetDTO expectedAssetDTO = new AssetDTO();

        // Mock repository and model mapper behavior
        when(modelMapper.map(assetDTO, Asset.class)).thenReturn(asset);
        when(assetRepository.save(asset)).thenReturn(savedAsset);
        when(modelMapper.map(savedAsset, AssetDTO.class)).thenReturn(expectedAssetDTO);

        // Call the method under test
        AssetDTO result = assetService.postAsset(assetDTO);

        // Verify the interactions and assertions
        Assertions.assertEquals(expectedAssetDTO, result);
    }

    @Test
      void testGetAssetById() {
        // Mock data
        Long assetId = 1L;
        Asset expectedAsset = new Asset();

        // Mock repository behavior
        when(assetRepository.findById(assetId)).thenReturn(Optional.of(expectedAsset));

        // Call the method under test
        Asset result = assetService.getAssetById(assetId);

        // Verify the interactions and assertions
        Assertions.assertEquals(expectedAsset, result);
    }

    @Test
      void testGetAssetById_NotFound() {
        // Mock data
        Long assetId = 1L;

        // Mock repository behavior
        when(assetRepository.findById(assetId)).thenReturn(Optional.empty());

        // Verify that AssetNotFoundException is thrown
        Assertions.assertThrows(AssetNotFoundException.class, () -> {
            assetService.getAssetById(assetId);
        });
    }
}
