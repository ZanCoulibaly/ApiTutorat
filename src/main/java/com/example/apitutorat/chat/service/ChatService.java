package com.example.apitutorat.chat.service;

import com.example.apitutorat.chat.Chat;

import java.util.List;

public interface ChatService {
    public Chat addChat(Chat chat, Long from, Long to, Long demande_id);
    public List<Chat> ListChat(Long from, Long to);
    public List<Chat>findByEnvoyeurAndReceveur(Long receveur);
    public List<Chat> ChatByDemande(Long id);
}
