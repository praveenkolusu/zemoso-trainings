package com.zmslabs.minet.controller;

import com.zmslabs.minet.model.OrdersDTO;
import com.zmslabs.minet.model.OrdersResponseDTO;
import com.zmslabs.minet.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;
    @PostMapping("/buy")
    public ResponseEntity<OrdersResponseDTO> buyAssets(@RequestBody OrdersDTO ordersDTO){
        return new ResponseEntity<>(ordersService.buyAssets(ordersDTO),HttpStatus.OK);
    }

    @PostMapping("/sell")
    public ResponseEntity<OrdersResponseDTO> sellAssets(@RequestBody OrdersDTO ordersDTO){
        return new ResponseEntity<>(ordersService.sellAssets(ordersDTO),HttpStatus.OK);
    }
}
