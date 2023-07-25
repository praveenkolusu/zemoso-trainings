package com.zmslabs.minet.service;

import com.zmslabs.minet.model.OrdersDTO;
import com.zmslabs.minet.model.OrdersResponseDTO;

public interface OrdersService {
    OrdersResponseDTO buyAssets(OrdersDTO ordersDTO);

    OrdersResponseDTO sellAssets(OrdersDTO ordersDTO);
}
