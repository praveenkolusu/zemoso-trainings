package com.zmslabs.minet.repository;

import com.zmslabs.minet.entity.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchListRepository extends JpaRepository<WatchList,Long> {
}
