package com.oriontek.clientapi.model.dto.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAddressDto {

    private String street;

    private String city;

    private String state;

    private String postalCode;
}
