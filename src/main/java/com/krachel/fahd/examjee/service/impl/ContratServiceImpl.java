package com.krachel.fahd.examjee.service.impl;

import com.krachel.fahd.examjee.dto.ContratDTO;
import com.krachel.fahd.examjee.entity.Client;
import com.krachel.fahd.examjee.entity.ContratAssurance;
import com.krachel.fahd.examjee.mapper.ContratMapper;
import com.krachel.fahd.examjee.repository.ClientRepository;
import com.krachel.fahd.examjee.repository.ContratAssuranceRepository;
import com.krachel.fahd.examjee.service.ContratService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements ContratService {

    private final ContratAssuranceRepository contratAssuranceRepository;
    private final ClientRepository clientRepository;
    private final ContratMapper contratMapper;

    @Override
    public ContratDTO createContrat(Long clientId, ContratDTO contratDTO) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client introuvable"));

        ContratAssurance contrat = contratMapper.toEntity(contratDTO);
        if (contrat == null) {
            throw new IllegalArgumentException("Type de contrat invalide");
        }

        contrat.setClient(client);
        return contratMapper.toDto(contratAssuranceRepository.save(contrat));
    }

    @Override
    public List<ContratDTO> getContratsByClientId(Long clientId) {
        return contratAssuranceRepository.findByClientId(clientId).stream().map(contratMapper::toDto).toList();
    }

    @Override
    public Optional<ContratDTO> getContratById(Long contratId) {
        return contratAssuranceRepository.findById(contratId).map(contratMapper::toDto);
    }
}
