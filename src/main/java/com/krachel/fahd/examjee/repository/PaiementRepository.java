package com.krachel.fahd.examjee.repository;

import com.krachel.fahd.examjee.entity.Paiement;
import com.krachel.fahd.examjee.enums.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement> findByContratAssuranceId(Long contratId);

    List<Paiement> findByType(TypePaiement type);
}
