package com.krachel.fahd.examjee.service;

import com.krachel.fahd.examjee.dto.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    ClientDTO createClient(ClientDTO clientDTO);

    List<ClientDTO> getAllClients();

    Optional<ClientDTO> getClientById(Long id);

    Optional<ClientDTO> getClientByEmail(String email);
}
