package com.oriontek.clientapi.controller;

import com.oriontek.clientapi.model.dto.address.AddressResponseDto;
import com.oriontek.clientapi.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
@AllArgsConstructor
@Validated
public class AddressController {

    private final AddressService addressService;

    @Operation(summary = "Get address list by client id")
    @GetMapping(path = "/client/{clientId}")
    public ResponseEntity<List<AddressResponseDto>> getAddressByClientId(@PathVariable Long clientId) {
        return ResponseEntity
                .ok(addressService.getAddressByClientId(clientId));
    }
}
