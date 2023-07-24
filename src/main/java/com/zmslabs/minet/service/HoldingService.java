package com.zmslabs.minet.service;

import com.zmslabs.minet.entity.Holding;

import java.util.List;

public interface HoldingService {
    public List<Holding> getUserHoldings(Long userId);
}
