package com.example.apitutorat.users;

import com.example.apitutorat.demande.Demande;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public abstract class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte[] photo;
    private String nom;
    private String prenom;
    private String numero;
    private String addresse;
    private String quartier;
    @Enumerated(EnumType.STRING)
    private Profile profile;
    private String password;
    private boolean activiter = false;
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.ACTIVER;
    private boolean supprime = false;
    private int totaleNotif = 0;
    private int oldTotale =0;

    @OneToMany(mappedBy = "envoyeur")
    @JsonIgnore
    private List<Demande> demandes;
}
