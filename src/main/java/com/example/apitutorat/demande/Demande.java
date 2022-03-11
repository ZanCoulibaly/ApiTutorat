package com.example.apitutorat.demande;

import com.example.apitutorat.chat.Chat;
import com.example.apitutorat.users.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;
    private LocalDate date = LocalDate.now();
    private String matiere;
    private Etat etat;
    private boolean initier;
    @ManyToOne
    private Utilisateur envoyeur;

    @ManyToOne
    private Utilisateur receveur;

}
