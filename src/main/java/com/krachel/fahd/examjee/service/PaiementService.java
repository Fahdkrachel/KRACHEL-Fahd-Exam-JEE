package com.krachel.fahd.examjee.service;

import com.krachel.fahd.examjee.dto.PaiementDTO;

import java.util.List;
import java.util.Optional;

public interface PaiementService {
    PaiementDTO addPaiementToContrat(Long contratId, PaiementDTO paiementDTO);

    List<PaiementDTO> getPaiementsByContratId(Long contratId);

    Optional<PaiementDTO> getPaiementById(Long paiementId);
}
