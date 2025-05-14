package com.oriontek.clientapi.model.mapper;

import com.oriontek.clientapi.model.dto.address.CreateAddressDto;
import com.oriontek.clientapi.model.dto.client.ClientResponseDto;
import com.oriontek.clientapi.model.dto.client.CreateClientDto;
import com.oriontek.clientapi.model.entity.Address;
import com.oriontek.clientapi.model.entity.Client;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {

    Client toEntity(CreateClientDto dto);

    List<Address> mapAddresses(List<CreateAddressDto> dto);

    ClientResponseDto toDto(Client client);

    @AfterMapping
    default void linkAddresses(@MappingTarget Client client){
        for(Address address : client.getAddresses()){
            address.setClient(client);
        }
    }
}