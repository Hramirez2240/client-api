package com.oriontek.clientapi.controller;

import com.oriontek.clientapi.model.dto.client.ClientResponseDto;
import com.oriontek.clientapi.model.dto.client.CreateClientDto;
import com.oriontek.clientapi.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clients")
@AllArgsConstructor
@Validated
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Creates a new client")
    @PostMapping
    public ResponseEntity<ClientResponseDto> createClient(@Valid @RequestBody CreateClientDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clientService.save(dto));
    }
}
