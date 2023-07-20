package com.zmslabs.minet.service.impl;

import com.zmslabs.minet.entity.Asset;
import com.zmslabs.minet.exception.AssetNotFoundException;
import com.zmslabs.minet.model.AssetDTO;
import com.zmslabs.minet.repository.AssetRepository;
import com.zmslabs.minet.service.AssetService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {
    private final AssetRepository assetRepository;

    private final  ModelMapper modelMapper;
    public AssetServiceImpl(AssetRepository assetRepository, ModelMapper modelMapper){
        this.assetRepository=assetRepository;
        this.modelMapper= modelMapper;
    }
    @Override
    public AssetDTO postAsset(AssetDTO assetDTO) {
        Asset asset = modelMapper.map(assetDTO, Asset.class);
        asset=assetRepository.save(asset);
        return modelMapper.map(asset,AssetDTO.class);
    }

    public Asset getAssetById(Long id) {
        return assetRepository.findById(id).orElseThrow(()->new AssetNotFoundException("asset not found for this Id "+id));
    }
}
