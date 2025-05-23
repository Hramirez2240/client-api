package com.oriontek.clientapi.repository;

import com.oriontek.clientapi.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByClientId(Long clientId);
}
