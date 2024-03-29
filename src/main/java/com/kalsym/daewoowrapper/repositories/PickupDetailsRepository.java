package com.kalsym.daewoowrapper.repositories;

import com.kalsym.daewoowrapper.models.PickupDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickupDetailsRepository extends JpaRepository<PickupDetails, String> {
}
