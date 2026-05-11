package com.krachel.fahd.examjee.dto;

import com.krachel.fahd.examjee.enums.NiveauCouverture;
import com.krachel.fahd.examjee.enums.StatutContrat;
import com.krachel.fahd.examjee.enums.TypeLogement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContratDTO {
    private Long id;
    private Date dateSouscription;
    private StatutContrat statut;
    private Date dateValidation;
    private Double montantCotisation;
    private Integer dureeContrat;
    private Double tauxCouverture;
    private Long clientId;
    private String typeContrat;
    private String numeroImmatriculation;
    private String marque;
    private String modele;
    private TypeLogement typeLogement;
    private String adresseLogement;
    private Double superficie;
    private NiveauCouverture niveauCouverture;
    private Integer nombrePersonnes;
}
