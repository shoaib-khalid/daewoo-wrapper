package com.kalsym.daewoowrapper.repositories;

import com.kalsym.daewoowrapper.models.DropoffDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DropoffDetailsRepository extends JpaRepository<DropoffDetails, String> {
}
