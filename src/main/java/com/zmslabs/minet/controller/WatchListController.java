package com.zmslabs.minet.controller;

import com.zmslabs.minet.model.WatchListDTO;
import com.zmslabs.minet.service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/watchlist")
public class WatchListController {
    @Autowired
    WatchListService watchListService;

    @PostMapping
    public ResponseEntity<WatchListDTO> createWatchlist(@RequestBody WatchListDTO watchListDTO) {
        return new ResponseEntity<>(watchListService.addToWatchList(watchListDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWatchList(@PathVariable Long id) {
        watchListService.deleteWatchListById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
