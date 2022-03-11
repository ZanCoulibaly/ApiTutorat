package com.example.apitutorat.users.model;

import com.example.apitutorat.users.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ELEVE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eleve extends Utilisateur {
    private String cour;
    private String ecole;
    private String classe;
    private String parents;
    private String description;
}
