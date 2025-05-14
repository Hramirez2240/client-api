package com.oriontek.clientapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oriontek.clientapi.model.dto.address.AddressResponseDto;
import com.oriontek.clientapi.model.dto.address.CreateAddressDto;
import com.oriontek.clientapi.model.dto.client.ClientResponseDto;
import com.oriontek.clientapi.model.dto.client.CreateClientDto;
import com.oriontek.clientapi.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ClientControllerTest {

    @MockitoBean
    private ClientService clientService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final List<CreateAddressDto> addressList = List.of(
            CreateAddressDto
                    .builder()
                    .street("123 Main St")
                    .city("New York")
                    .state("NY")
                    .postalCode("10001")
                    .build(),
            CreateAddressDto
                    .builder()
                    .street("456 Elm St")
                    .city("New York")
                    .state("NY")
                    .postalCode("10002")
                    .build()
    );

    private final List<AddressResponseDto> addressResponseList = List.of(
            AddressResponseDto
                    .builder()
                    .id(1L)
                    .street("123 Main St")
                    .city("New York")
                    .state("NY")
                    .postalCode("10001")
                    .build(),
            AddressResponseDto
                    .builder()
                    .id(2L)
                    .street("456 Elm St")
                    .city("New York")
                    .state("NY")
                    .postalCode("10002")
                    .build()
    );

    @Test
    void createClientSuccess() throws Exception{
        //Arrange
        CreateClientDto dto = CreateClientDto
                .builder()
                .name("Hector")
                .email("Xt8kH@example.com")
                .phoneNumber("8498806543")
                .addresses(addressList)
                .build();

        ClientResponseDto expectedResponse = ClientResponseDto
                .builder()
                .name("Hector")
                .email("Xt8kH@example.com")
                .phoneNumber("8498806543")
                .addresses(addressResponseList)
                .build();

        //Act
        MvcResult result =
                mockMvc.perform(
                        post("/api/v1/clients")
                                .contentType("application/json")
                                .content(dto.toString()))
                        .andExpect(status().isCreated())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        //Assert
        String responseJson = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
        ClientResponseDto response = objectMapper.readValue(responseJson, ClientResponseDto.class);
        assertEquals(response.getName(), expectedResponse.getName());
    }
}
