package com.krachel.fahd.examjee.service;

import com.krachel.fahd.examjee.dto.ContratDTO;

import java.util.List;
import java.util.Optional;

public interface ContratService {
    ContratDTO createContrat(Long clientId, ContratDTO contratDTO);

    List<ContratDTO> getContratsByClientId(Long clientId);

    Optional<ContratDTO> getContratById(Long contratId);
}
