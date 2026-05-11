package com.krachel.fahd.examjee.mapper;

import com.krachel.fahd.examjee.dto.ContratDTO;
import com.krachel.fahd.examjee.entity.ContratAssurance;
import com.krachel.fahd.examjee.entity.ContratAuto;
import com.krachel.fahd.examjee.entity.ContratHabitation;
import com.krachel.fahd.examjee.entity.ContratSante;
import org.springframework.stereotype.Component;

@Component
public class ContratMapper {

    public ContratDTO toDto(ContratAssurance contrat) {
        if (contrat == null) {
            return null;
        }

        ContratDTO.ContratDTOBuilder builder = ContratDTO.builder()
                .id(contrat.getId())
                .dateSouscription(contrat.getDateSouscription())
                .statut(contrat.getStatut())
                .dateValidation(contrat.getDateValidation())
                .montantCotisation(contrat.getMontantCotisation())
                .dureeContrat(contrat.getDureeContrat())
                .tauxCouverture(contrat.getTauxCouverture())
                .clientId(contrat.getClient() != null ? contrat.getClient().getId() : null);

        if (contrat instanceof ContratAuto contratAuto) {
            builder.typeContrat("AUTO")
                    .numeroImmatriculation(contratAuto.getNumeroImmatriculation())
                    .marque(contratAuto.getMarque())
                    .modele(contratAuto.getModele());
        } else if (contrat instanceof ContratHabitation contratHabitation) {
            builder.typeContrat("HABITATION")
                    .typeLogement(contratHabitation.getTypeLogement())
                    .adresseLogement(contratHabitation.getAdresseLogement())
                    .superficie(contratHabitation.getSuperficie());
        } else if (contrat instanceof ContratSante contratSante) {
            builder.typeContrat("SANTE")
                    .niveauCouverture(contratSante.getNiveauCouverture())
                    .nombrePersonnes(contratSante.getNombrePersonnes());
        }

        return builder.build();
    }

    public ContratAssurance toEntity(ContratDTO dto) {
        if (dto == null || dto.getTypeContrat() == null) {
            return null;
        }

        ContratAssurance contrat;
        String type = dto.getTypeContrat().toUpperCase();

        switch (type) {
            case "AUTO" -> contrat = ContratAuto.builder()
                    .numeroImmatriculation(dto.getNumeroImmatriculation())
                    .marque(dto.getMarque())
                    .modele(dto.getModele())
                    .build();
            case "HABITATION" -> contrat = ContratHabitation.builder()
                    .typeLogement(dto.getTypeLogement())
                    .adresseLogement(dto.getAdresseLogement())
                    .superficie(dto.getSuperficie())
                    .build();
            case "SANTE" -> contrat = ContratSante.builder()
                    .niveauCouverture(dto.getNiveauCouverture())
                    .nombrePersonnes(dto.getNombrePersonnes())
                    .build();
            default -> {
                return null;
            }
        }

        contrat.setId(dto.getId());
        contrat.setDateSouscription(dto.getDateSouscription());
        contrat.setStatut(dto.getStatut());
        contrat.setDateValidation(dto.getDateValidation());
        contrat.setMontantCotisation(dto.getMontantCotisation());
        contrat.setDureeContrat(dto.getDureeContrat());
        contrat.setTauxCouverture(dto.getTauxCouverture());

        return contrat;
    }
}
