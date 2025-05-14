package com.oriontek.clientapi.service;

import com.oriontek.clientapi.model.dto.address.AddressResponseDto;
import com.oriontek.clientapi.model.entity.Address;
import com.oriontek.clientapi.model.mapper.AddressMapper;
import com.oriontek.clientapi.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper mapper;

    public List<AddressResponseDto> getAddressByClientId(Long clientId) {
        List<Address> addressList = addressRepository.findByClientId(clientId);
        return mapper.toDtoList(addressList);
    }
}
