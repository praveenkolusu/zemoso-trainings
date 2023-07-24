package com.zmslabs.minet.service.impl;

import com.zmslabs.minet.entity.Holding;
import com.zmslabs.minet.entity.User;
import com.zmslabs.minet.exception.DataNotFoundException;
import com.zmslabs.minet.repository.HoldingRepository;
import com.zmslabs.minet.repository.UserRepository;
import com.zmslabs.minet.service.HoldingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HoldingServiceImpl implements HoldingService {
   private final HoldingRepository holdingRepository;
   private final UserRepository userRepository;

    @Override
    public List<Holding> getUserHoldings(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new DataNotFoundException("user details not found"));
        return holdingRepository.findByUser(user);
    }
}
