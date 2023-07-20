package com.zmslabs.minet.controller;

import com.zmslabs.minet.entity.Holding;
import com.zmslabs.minet.service.HoldingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/holdings/")
@RequiredArgsConstructor
public class HoldingController {

    private final HoldingService holdingService;
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Holding>> getUserHoldings(@PathVariable Long userId){
        return new ResponseEntity<>(holdingService.getUserHoldings(userId), HttpStatus.OK);
    }
}
