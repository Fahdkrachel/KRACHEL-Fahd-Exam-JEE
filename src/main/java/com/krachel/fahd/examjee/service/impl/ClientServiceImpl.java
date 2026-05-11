package com.krachel.fahd.examjee.service.impl;

import com.krachel.fahd.examjee.dto.ClientDTO;
import com.krachel.fahd.examjee.mapper.ClientMapper;
import com.krachel.fahd.examjee.repository.ClientRepository;
import com.krachel.fahd.examjee.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(clientDTO)));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(clientMapper::toDto).toList();
    }

    @Override
    public Optional<ClientDTO> getClientById(Long id) {
        return clientRepository.findById(id).map(clientMapper::toDto);
    }

    @Override
    public Optional<ClientDTO> getClientByEmail(String email) {
        return clientRepository.findByEmail(email).map(clientMapper::toDto);
    }
}
