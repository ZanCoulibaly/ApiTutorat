package com.example.apitutorat.users.service;
import com.example.apitutorat.demande.service.DemandeService;
import com.example.apitutorat.users.Etat;
import com.example.apitutorat.users.Utilisateur;
import com.example.apitutorat.users.model.Ecole;
import com.example.apitutorat.users.model.Eleve;
import com.example.apitutorat.users.model.Parent;
import com.example.apitutorat.users.model.Tuteur;
import com.example.apitutorat.users.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    EcoleRepository ecoleRepository;
    @Autowired
    TuteurRepository tuteurRepository;
    @Autowired
    EleveRepository eleveRepository;
    @Autowired
    ParentRepository parentRepository;

    @Autowired
    DemandeService demandeService;


    //----------------------------section de liste---------------------------


    @Override
    public List<Utilisateur> findAllEleve() {
        return usersRepository.listerEleve();
    }

    @Override
    public List<Utilisateur> findAllEcole() {
        return usersRepository.listerEcole();
    }

    @Override
    public List<Utilisateur> findAllParent() {
        return usersRepository.listerParent();
    }

    @Override
    public List<Utilisateur> findAllTuteur() {
        return usersRepository.listerTuteur();
    }

    @Override
    public Utilisateur finById(Long id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public List<Utilisateur> liste() {

        return usersRepository.findAll();
    }

    @Override
    public List<Utilisateur> listerParentEleve() {
        return usersRepository.listerParentEleve();
    }


    @Override
    public List<Tuteur> recherche(String ville, String specialite, String niveau) {
        return usersRepository.findByAddresseAndSpecialiteAndNiveau(ville, specialite, niveau);
    }

    @Override
    public List<Utilisateur> FindAllDel() {
        return usersRepository.listDel();
    }

    //-------liste des tuteurs par ville-------

    @Override
    public List<Tuteur> TrouverParVille(String adresse) {
        return usersRepository.findByAddresseAndEtat(adresse, Etat.ACTIVER);
    }


    //----------------fin


    //--------------------------------------section pour ajouter les utilisateurs----------------------------------------------

    @Override
    public Utilisateur addEleve(Eleve eleve) {
        return usersRepository.save(eleve);
    }

    @Override
    public Utilisateur addEcole(Ecole ecole) {
        return usersRepository.save(ecole);
    }

    @Override
    public Utilisateur addParent(Parent parent) {
        return usersRepository.save(parent);
    }

    @Override
    public Utilisateur addTuteur(Tuteur tuteur) {
        tuteur.setDisponibilite(true);
        return usersRepository.save(tuteur);
    }

    //------fin


    //----------------------------------Section pour la  modification complète des utisateurs -------------------------------------------------

    @Override
    public void modify_ecole(Long id, Ecole utulisateur) {
        Ecole ecole= ecoleRepository.findById(id).get();
        ecole.setAddresse(utulisateur.getAddresse());
        ecole.setNom(utulisateur.getNom());
        ecole.setNumero(utulisateur.getNumero());
        ecole.setPassword(utulisateur.getPassword());
        ecole.setEmail(utulisateur.getEmail());
        ecole.setSite(utulisateur.getSite());
        ecoleRepository.save(ecole);
    }

    @Override
    public void modify_tuteur(Long id, Tuteur tuteur) {
        Tuteur user= tuteurRepository.findById(id).get();
        user.setAddresse(tuteur.getAddresse());
        user.setNumero(tuteur.getNumero());
        user.setNom(tuteur.getNom());
        user.setPassword(tuteur.getPassword());
        user.setAnciennete(tuteur.getAnciennete());
        user.setEtablissement(tuteur.getEtablissement());
        user.setSpecialite(tuteur.getSpecialite());
        user.setPrenom(tuteur.getPrenom());
        user.setNiveau(tuteur.getNiveau());
        tuteurRepository.save(user);
    }

    @Override
    public void modify_eleve(Long id, Eleve eleve) {
        Eleve user= eleveRepository.findById(id).get();
        user.setAddresse(eleve.getAddresse());
        user.setNom(eleve.getNom());
        user.setNumero(eleve.getNumero());
        user.setPassword(eleve.getPassword());
        user.setPrenom(eleve.getPrenom());
        user.setClasse(eleve.getClasse());
        user.setCour(eleve.getCour());
        user.setDescription(eleve.getDescription());
        user.setEcole(eleve.getEcole());
        user.setParents(eleve.getParents());
        eleveRepository.save(user);

    }

    @Override
    public void modidy_parent(Long id, Parent parent) {
        Parent user= parentRepository.findById(id).get();
        user.setNumero(parent.getNumero());
        user.setAddresse(parent.getAddresse());
        user.setNom(parent.getNom());
        user.setPrenom(parent.getPrenom());
        user.setTravail(parent.getTravail());
        user.setPassword(parent.getPassword());
        parentRepository.save(user);
    }

    //--------------fin


    //------------------------Section pour modifier un seule valeur -----------------------------------------


    @Override
    public boolean disponibilite(Long id) {
        Tuteur user= tuteurRepository.findById(id).get();
        if (user.isDisponibilite()){
            user.setDisponibilite(false);
        }else {
            user.setDisponibilite(true);
        }
        tuteurRepository.save(user);
        return true;
    }

    @Override
    public void modify_pass(Long id, Utilisateur utilisateur) {
        Utilisateur user= usersRepository.findById(id).get();
        user.setPassword(utilisateur.getPassword());
        usersRepository.save(user);
    }

    //---------------------section delete et restorer--------------------------------------------------------------


    @Override
    public void delete(Long id) {
        Utilisateur utilisateur = usersRepository.findById(id).get();
        utilisateur.setEtat(Etat.DESACTIVER);
        utilisateur.setSupprime(true);
        usersRepository.save(utilisateur);
    }

    @Override
    public void restore(Long id) {
        Utilisateur user= usersRepository.findById(id).get();
        user.setEtat(Etat.ACTIVER);
        user.setSupprime(false);
        usersRepository.save(user);
    }

    //---------------------Login---------------


    @Override
    public List<Utilisateur> login(String numero, String password) {

        return usersRepository.findByNumeroAndPassword(numero, password);
    }

    //-----------------------------------Actiivier la connexion-----------------

    @Override
    public void activity(Long id) {
        Utilisateur user= usersRepository.findById(id).get();

        if (user.isActiviter()){
            user.setActiviter(false);
        }else {
            user.setActiviter(true);
        }
        usersRepository.save(user);
    }


    //--------------------------Obtenir le nombre de demande -----------------------------
    @Override
    public int ReinitilaiserNbreDemande(Long id) {
        Utilisateur user= usersRepository.findById(id).get();
        user.setOldTotale(user.getTotaleNotif());
        usersRepository.save(user);
        return  user.getOldTotale();
    }

    //---------------------------------------les nombres totales-------------------------------------------

    @Override
    public int NbreTotaleUSer() {
        List<Utilisateur> liste= usersRepository.findAll();
        return liste.size();
    }

    @Override
    public int NbreTotaleParent() {
        List<Utilisateur> liste= usersRepository.listerParent();
        return liste.size();
    }

    @Override
    public int NbreTotaleTuteur() {
        List<Utilisateur> list= usersRepository.listerTuteur();
        return list.size();
    }

    @Override
    public int NbreTotaleEleve() {
        List<Utilisateur> list= usersRepository.listerEleve();
        return list.size();
    }

    @Override
    public int NbreTotaleEcole() {
        List<Utilisateur> list= usersRepository.listerEcole();
        return list.size();
    }
}
