package com.krachel.fahd.examjee.mapper;

import com.krachel.fahd.examjee.dto.PaiementDTO;
import com.krachel.fahd.examjee.entity.Paiement;
import org.springframework.stereotype.Component;

@Component
public class PaiementMapper {

    public PaiementDTO toDto(Paiement paiement) {
        if (paiement == null) {
            return null;
        }
        return PaiementDTO.builder()
                .id(paiement.getId())
                .date(paiement.getDate())
                .montant(paiement.getMontant())
                .type(paiement.getType())
                .contratId(paiement.getContratAssurance() != null ? paiement.getContratAssurance().getId() : null)
                .build();
    }

    public Paiement toEntity(PaiementDTO dto) {
        if (dto == null) {
            return null;
        }
        return Paiement.builder()
                .id(dto.getId())
                .date(dto.getDate())
                .montant(dto.getMontant())
                .type(dto.getType())
                .build();
    }
}
