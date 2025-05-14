package com.oriontek.clientapi.service;

import com.oriontek.clientapi.model.dto.client.ClientResponseDto;
import com.oriontek.clientapi.model.dto.client.CreateClientDto;
import com.oriontek.clientapi.model.entity.Client;
import com.oriontek.clientapi.model.mapper.ClientMapper;
import com.oriontek.clientapi.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper mapper;

    public ClientResponseDto save(CreateClientDto dto) {
        try{
            Client client = mapper.toEntity(dto);
            client = clientRepository.save(client);

            return mapper.toDto(client);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
