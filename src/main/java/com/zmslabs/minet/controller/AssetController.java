package com.zmslabs.minet.controller;

import com.zmslabs.minet.model.AssetDTO;
import com.zmslabs.minet.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assets")
@RequiredArgsConstructor
public class AssetController {

   private final AssetService assetService;
    @PostMapping
    public ResponseEntity<AssetDTO> postAssets(@RequestBody AssetDTO assetDTO){
        return new ResponseEntity<>(assetService.postAsset(assetDTO), HttpStatus.CREATED);
    }
}
