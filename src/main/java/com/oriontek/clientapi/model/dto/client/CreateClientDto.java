package com.oriontek.clientapi.model.dto.client;

import com.oriontek.clientapi.model.dto.address.CreateAddressDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateClientDto {

    @NotBlank(message = "This field cannot be empty")
    private String name;

    @NotBlank(message = "This field cannot be empty")
    @Email
    private String email;

    @NotBlank(message = "This field cannot be empty")
    @NumberFormat(pattern = "###-###-####")
    private String phoneNumber;

    @NotBlank(message = "This field cannot be empty")
    private List<CreateAddressDto> addresses;
}
