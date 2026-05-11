package com.krachel.fahd.examjee.mapper;

import com.krachel.fahd.examjee.dto.ClientDTO;
import com.krachel.fahd.examjee.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDTO toDto(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDTO.builder()
                .id(client.getId())
                .nom(client.getNom())
                .email(client.getEmail())
                .build();
    }

    public Client toEntity(ClientDTO dto) {
        if (dto == null) {
            return null;
        }
        return Client.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .email(dto.getEmail())
                .build();
    }
}
