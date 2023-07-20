package com.zmslabs.minet.service.impl;

import com.zmslabs.minet.entity.Asset;
import com.zmslabs.minet.entity.User;
import com.zmslabs.minet.entity.WatchList;
import com.zmslabs.minet.exception.DataNotFoundException;
import com.zmslabs.minet.model.WatchListDTO;
import com.zmslabs.minet.repository.AssetRepository;
import com.zmslabs.minet.repository.UserRepository;
import com.zmslabs.minet.repository.WatchListRepository;
import com.zmslabs.minet.service.WatchListService;
import org.springframework.stereotype.Service;
@Service
public class WatchListServiceImpl implements WatchListService {
    private final UserRepository userRepository;
    private final AssetRepository assetRepository;
    private final WatchListRepository watchListRepository;

    public WatchListServiceImpl(UserRepository userRepository, AssetRepository assetRepository, WatchListRepository watchListRepository) {
        this.userRepository = userRepository;
        this.assetRepository = assetRepository;
        this.watchListRepository = watchListRepository;
    }

    @Override
    public WatchListDTO addToWatchList(WatchListDTO watchListDTO) {
        User user= userRepository.findById(watchListDTO.getUserId()).orElseThrow(()->new DataNotFoundException("user details not present"));
        Asset asset = assetRepository.findById(watchListDTO.getAssetId()).orElseThrow(()->new DataNotFoundException("asset details not found"));
        WatchList watchList= WatchList.builder()
                .asset(asset).user(user).build();
        watchList=watchListRepository.save(watchList);
        watchListDTO.setId(watchList.getId());
        return watchListDTO;
    }

    @Override
    public void deleteWatchListById(Long id) {
        watchListRepository.deleteById(id);
    }
}
