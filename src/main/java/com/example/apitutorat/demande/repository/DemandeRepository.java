package com.example.apitutorat.demande.repository;

import com.example.apitutorat.demande.Demande;
import com.example.apitutorat.users.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
    public List<Demande> findByEnvoyeurAndReceveurAndEtatIsTrue(Utilisateur envoyeur, Utilisateur receveur);
    public List<Demande> findByReceveur(Utilisateur receveur);
    public List<Demande> findByInitierIsTrue();
    public List<Demande> findByReceveurAndInitierIsTrue(Utilisateur envoyeur);
    public List<Demande> findByEnvoyeurAndInitierIsTrue(Utilisateur receveur );
    public Demande findByEnvoyeurAndReceveurAndMatiere(Utilisateur envoyeur, Utilisateur receveur, String matiere);
}
