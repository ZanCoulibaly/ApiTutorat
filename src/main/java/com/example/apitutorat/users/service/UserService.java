package com.example.apitutorat.users.service;

import com.example.apitutorat.users.Utilisateur;
import com.example.apitutorat.users.model.Ecole;
import com.example.apitutorat.users.model.Eleve;
import com.example.apitutorat.users.model.Parent;
import com.example.apitutorat.users.model.Tuteur;

import java.util.List;

public interface UserService {

    public List<Utilisateur> liste();

    public List<Utilisateur> listerParentEleve();

    //--------------------section Liste---------------------------------
    public Utilisateur finById(Long id);
    public List<Utilisateur> findAllEleve();
    public List<Utilisateur> findAllEcole();
    public List<Utilisateur> findAllParent();
    public List<Utilisateur> findAllTuteur();
    public List<Utilisateur> FindAllDel();
    public List<Tuteur> recherche(String ville, String specialite, String niveau);

    //-------------------------section modier-----------------------------------------------
    public void modify_ecole(Long id, Ecole utulisateur);
    public void modify_tuteur(Long id, Tuteur tuteur);
    public void modify_eleve(Long id, Eleve eleve);
    public void modidy_parent(Long id, Parent  parent);
    public boolean disponibilite(Long id);
    public void modify_pass(Long id, Utilisateur utilisateur);
    public List<Tuteur> TrouverParVille(String adresse);

    //---------fin

    //------------------Section ajout-------------------------------------------------------

    public Utilisateur addEleve(Eleve eleve);
    public Utilisateur addEcole(Ecole ecole);
    public Utilisateur addParent(Parent parent);
    public Utilisateur addTuteur(Tuteur tuteur);

    //----fin

    //--------------------section supprimer et restorer-------------------

    public void restore(Long id);
    public void delete(Long id);

    //----------------------Login---------------------------------------------------------------
    public List<Utilisateur> login(String numero, String password);

    //---------------activer le en ligne lors de la connexion-----------------------------------------
    public void activity(Long id);


    //------------------Obtenir le nombre de demande d'un utilistaeur---------------------------------------
    public int ReinitilaiserNbreDemande(Long id);

    //---------------------------------les nombres totales--------------------------------------------------
    public int NbreTotaleUSer();
    public int NbreTotaleParent();
    public int NbreTotaleTuteur();
    public int NbreTotaleEleve();
    public int NbreTotaleEcole();

}
