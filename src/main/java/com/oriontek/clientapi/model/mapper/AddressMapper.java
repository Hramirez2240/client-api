package com.oriontek.clientapi.model.mapper;

import com.oriontek.clientapi.model.dto.address.AddressResponseDto;
import com.oriontek.clientapi.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {

    List<AddressResponseDto> toDtoList(List<Address> addresses);
}
