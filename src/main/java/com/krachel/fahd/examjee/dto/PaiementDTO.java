package com.krachel.fahd.examjee.dto;

import com.krachel.fahd.examjee.enums.TypePaiement;
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
public class PaiementDTO {
    private Long id;
    private Date date;
    private Double montant;
    private TypePaiement type;
    private Long contratId;
}
