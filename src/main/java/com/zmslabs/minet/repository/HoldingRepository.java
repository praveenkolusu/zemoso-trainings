package com.zmslabs.minet.repository;

import com.zmslabs.minet.entity.Asset;
import com.zmslabs.minet.entity.Holding;
import com.zmslabs.minet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HoldingRepository extends JpaRepository<Holding,Long> {
    Optional<Holding> findByUserAndAsset(User user, Asset asset);
    List<Holding> findByUser(User user);
}
