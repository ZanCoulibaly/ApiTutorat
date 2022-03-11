package com.example.apitutorat.chat.service;

import com.example.apitutorat.chat.Chat;
import com.example.apitutorat.chat.repository.ChatRepository;
import com.example.apitutorat.demande.Demande;
import com.example.apitutorat.demande.repository.DemandeRepository;
import com.example.apitutorat.users.Utilisateur;
import com.example.apitutorat.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ChatServiceImp implements ChatService{

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    DemandeRepository demandeRepository;

    @Override
    public Chat addChat(Chat chat, Long from, Long to, Long demande_id) {
        Utilisateur envoyeur = usersRepository.findById(from).get();
        Utilisateur receveur = usersRepository.findById(to).get();
        Demande demande= demandeRepository.findById(demande_id).get();
        chat.setEnvoyeur(envoyeur);
        chat.setReceveur(receveur);
        chat.setDemande(demande);
        chat.setDate(LocalDate.now());
        chat.setHeure(LocalTime.now());
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> findByEnvoyeurAndReceveur(Long receveur) {
        Utilisateur utilisateur = usersRepository.findById(receveur).get();
        return chatRepository.findByReceveur(utilisateur);
    }

    @Override
    public List<Chat> ListChat(Long from, Long to) {
        Utilisateur envoyeur= usersRepository.findById(from).get();
        Utilisateur receveur= usersRepository.findById(to).get();
        return chatRepository.findByEnvoyeurAndReceveur(envoyeur, receveur);
    }

    @Override
    public List<Chat> ChatByDemande(Long id) {
        Demande demande = demandeRepository.findById(id).get();
        return chatRepository.findByDemande(demande);
    }
}
