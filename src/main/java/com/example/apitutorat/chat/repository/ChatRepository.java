package com.example.apitutorat.chat.repository;

import com.example.apitutorat.chat.Chat;
import com.example.apitutorat.demande.Demande;
import com.example.apitutorat.users.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository  extends JpaRepository<Chat, Long> {
    public List<Chat> findByEnvoyeurAndReceveur(Utilisateur envoyeur, Utilisateur receveur);
    public List<Chat> findByReceveurAndEnvoyeur(Utilisateur receveur, Utilisateur envoyeur);
    public List<Chat> findByReceveur(Utilisateur receveur);
    public List<Chat> findByDemande(Demande demande);

}
