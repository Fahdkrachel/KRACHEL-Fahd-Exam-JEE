package com.krachel.fahd.examjee.config;

import com.krachel.fahd.examjee.entity.Client;
import com.krachel.fahd.examjee.entity.ContratAuto;
import com.krachel.fahd.examjee.entity.ContratHabitation;
import com.krachel.fahd.examjee.entity.ContratSante;
import com.krachel.fahd.examjee.entity.Paiement;
import com.krachel.fahd.examjee.enums.NiveauCouverture;
import com.krachel.fahd.examjee.enums.StatutContrat;
import com.krachel.fahd.examjee.enums.TypeLogement;
import com.krachel.fahd.examjee.enums.TypePaiement;
import com.krachel.fahd.examjee.repository.ClientRepository;
import com.krachel.fahd.examjee.repository.ContratAssuranceRepository;
import com.krachel.fahd.examjee.repository.PaiementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final ClientRepository clientRepository;
    private final ContratAssuranceRepository contratAssuranceRepository;
    private final PaiementRepository paiementRepository;

    @Bean
    CommandLineRunner loadDaoData() {
        return args -> {
            if (clientRepository.count() > 0) {
                return;
            }

            Date now = new Date();

            Client client1 = clientRepository.save(Client.builder()
                    .nom("Fahd Krachel")
                    .email("fahd.krachel@assurapp.ma")
                    .build());

            Client client2 = clientRepository.save(Client.builder()
                    .nom("Sara El Idrissi")
                    .email("sara.elidrissi@assurapp.ma")
                    .build());

            ContratAuto contratAuto = contratAssuranceRepository.save(ContratAuto.builder()
                    .dateSouscription(now)
                    .dateValidation(now)
                    .statut(StatutContrat.VALIDE)
                    .montantCotisation(320.0)
                    .dureeContrat(12)
                    .tauxCouverture(0.8)
                    .client(client1)
                    .numeroImmatriculation("12345-A-6")
                    .marque("Dacia")
                    .modele("Sandero")
                    .build());

            ContratHabitation contratHabitation = contratAssuranceRepository.save(ContratHabitation.builder()
                    .dateSouscription(now)
                    .dateValidation(now)
                    .statut(StatutContrat.EN_COURS)
                    .montantCotisation(450.0)
                    .dureeContrat(12)
                    .tauxCouverture(0.9)
                    .client(client2)
                    .typeLogement(TypeLogement.APPARTEMENT)
                    .adresseLogement("25 Avenue Hassan II, Casablanca")
                    .superficie(95.0)
                    .build());

            ContratSante contratSante = contratAssuranceRepository.save(ContratSante.builder()
                    .dateSouscription(now)
                    .dateValidation(now)
                    .statut(StatutContrat.VALIDE)
                    .montantCotisation(600.0)
                    .dureeContrat(12)
                    .tauxCouverture(0.95)
                    .client(client1)
                    .niveauCouverture(NiveauCouverture.PREMIUM)
                    .nombrePersonnes(4)
                    .build());

            paiementRepository.save(Paiement.builder()
                    .date(now)
                    .montant(320.0)
                    .type(TypePaiement.MENSUALITE)
                    .contratAssurance(contratAuto)
                    .build());

            paiementRepository.save(Paiement.builder()
                    .date(now)
                    .montant(450.0)
                    .type(TypePaiement.PAIEMENT_ANNUEL)
                    .contratAssurance(contratHabitation)
                    .build());

            paiementRepository.save(Paiement.builder()
                    .date(now)
                    .montant(600.0)
                    .type(TypePaiement.PAIEMENT_EXCEPTIONNEL)
                    .contratAssurance(contratSante)
                    .build());
        };
    }
}
