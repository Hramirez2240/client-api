package com.oriontek.clientapi.model.dto.client;

import com.oriontek.clientapi.model.dto.address.AddressResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponseDto {

    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private List<AddressResponseDto> addresses;
}
