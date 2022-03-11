package com.example.apitutorat.users.repository;

import com.example.apitutorat.users.Etat;
import com.example.apitutorat.users.Utilisateur;
import com.example.apitutorat.users.model.Ecole;
import com.example.apitutorat.users.model.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Utilisateur, Long> {
    public List<Tuteur> findByAddresseAndSpecialiteAndNiveau(String ville, String specialite, String niveau);


    //------------------section pour lister les utilisateurs-------------------------------------

    @Query("SELECT searc FROM Eleve searc WHERE searc.etat='ACTIVER'")
    public List<Utilisateur> listerEleve();

    @Query("select tuteur FROM Tuteur  tuteur where tuteur.etat='ACTIVER'")
    public List<Utilisateur> listerTuteur();

    @Query("select parent FROM Parent  parent where parent.etat='ACTIVER'")
    public List<Utilisateur> listerParent();

    @Query("select ecole FROM Ecole  ecole where ecole.etat='ACTIVER' ")
    public List<Utilisateur> listerEcole();

    @Query("select parent FROM Utilisateur parent where  parent.etat='ACTIVER' AND parent.profile='ELEVE' or parent.etat='ACTIVER' AND  parent.profile='PARENT'")
    public List<Utilisateur> listerParentEleve();

    //-----------------------------section pour lister les etats desactiver-------------------------------

    @Query("select users FROM Utilisateur  users where users.etat='DESACTIVER'")
    public List<Utilisateur> listDel();


    //------------------------Login-------------------------------

    public List<Utilisateur>     findByNumeroAndPassword(String numero, String password);
    public List<Ecole> findByNumero(String numero);

    //------fin

    //--------------------liste des tuteurs selon leur ville et leur etats---------------------------------

    public List<Tuteur> findByAddresseAndEtat(String addresse, Etat etat);


}
