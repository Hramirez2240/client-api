package com.oriontek.clientapi.model.dto.address;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponseDto {

    private Long id;

    private String street;

    private String city;

    private String state;

    private String postalCode;
}
