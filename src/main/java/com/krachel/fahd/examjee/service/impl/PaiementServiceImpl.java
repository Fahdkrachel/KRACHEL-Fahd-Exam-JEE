package com.krachel.fahd.examjee.service.impl;

import com.krachel.fahd.examjee.dto.PaiementDTO;
import com.krachel.fahd.examjee.entity.ContratAssurance;
import com.krachel.fahd.examjee.entity.Paiement;
import com.krachel.fahd.examjee.mapper.PaiementMapper;
import com.krachel.fahd.examjee.repository.ContratAssuranceRepository;
import com.krachel.fahd.examjee.repository.PaiementRepository;
import com.krachel.fahd.examjee.service.PaiementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository paiementRepository;
    private final ContratAssuranceRepository contratAssuranceRepository;
    private final PaiementMapper paiementMapper;

    @Override
    public PaiementDTO addPaiementToContrat(Long contratId, PaiementDTO paiementDTO) {
        ContratAssurance contrat = contratAssuranceRepository.findById(contratId)
                .orElseThrow(() -> new IllegalArgumentException("Contrat introuvable"));

        Paiement paiement = paiementMapper.toEntity(paiementDTO);
        paiement.setContratAssurance(contrat);
        return paiementMapper.toDto(paiementRepository.save(paiement));
    }

    @Override
    public List<PaiementDTO> getPaiementsByContratId(Long contratId) {
        return paiementRepository.findByContratAssuranceId(contratId).stream().map(paiementMapper::toDto).toList();
    }

    @Override
    public Optional<PaiementDTO> getPaiementById(Long paiementId) {
        return paiementRepository.findById(paiementId).map(paiementMapper::toDto);
    }
}
