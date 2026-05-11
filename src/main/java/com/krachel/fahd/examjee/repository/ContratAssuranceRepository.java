package com.krachel.fahd.examjee.repository;

import com.krachel.fahd.examjee.entity.ContratAssurance;
import com.krachel.fahd.examjee.enums.StatutContrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratAssuranceRepository extends JpaRepository<ContratAssurance, Long> {
    List<ContratAssurance> findByClientId(Long clientId);

    List<ContratAssurance> findByStatut(StatutContrat statut);
}
