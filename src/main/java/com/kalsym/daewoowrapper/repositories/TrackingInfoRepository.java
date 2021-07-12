package com.kalsym.daewoowrapper.repositories;

import com.kalsym.daewoowrapper.models.TrackingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingInfoRepository extends JpaRepository<TrackingInfo, String> {
}
