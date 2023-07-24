package com.zmslabs.minet.service;

import com.zmslabs.minet.model.WatchListDTO;

public interface WatchListService {
    WatchListDTO addToWatchList(WatchListDTO watchListDTO);

    void deleteWatchListById(Long id);
}
