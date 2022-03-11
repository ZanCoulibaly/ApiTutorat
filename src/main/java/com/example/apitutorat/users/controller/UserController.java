package com.example.apitutorat.users.controller;

import com.example.apitutorat.users.Utilisateur;
import com.example.apitutorat.users.model.Ecole;
import com.example.apitutorat.users.model.Eleve;
import com.example.apitutorat.users.model.Parent;
import com.example.apitutorat.users.model.Tuteur;
import com.example.apitutorat.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FilenameFilter;
import java.net.FileNameMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ServletContext context;

    //--------------------------section d'ajout--------------------------------
    @PostMapping("add/ecole")
    public Utilisateur addEcole(@RequestBody Ecole ecole){
        return userService.addEcole(ecole);
    }

    @PostMapping("add/eleve")
    public Utilisateur addEleve(@RequestBody Eleve eleve){
        return userService.addEleve(eleve);
    }

    @PostMapping("add/parent")
    public Utilisateur addParent(@RequestBody Parent parent){
        return userService.addParent(parent);
    }

    @PostMapping("add/tuteur")
    public Utilisateur addTuteur(@RequestBody Tuteur tuteur){
        return userService.addTuteur(tuteur);
    }


    //--------------fin

    //------------------------section de recherche---------------------------------

    @GetMapping("search/{ville}/{specialite}/{niveau}")
    public List<Tuteur> recherche(@PathVariable String ville, @PathVariable String specialite, @PathVariable String niveau){
        return userService.recherche(ville, specialite, niveau);
    }

    @GetMapping("liste")
    public List<Utilisateur> liste(){
        return userService.liste();
    }

    @GetMapping("liste/eleve")
    public List<Utilisateur> listEleve(){
        return userService.findAllEleve();
    }

    @GetMapping("liste/tuteur")
    public List<Utilisateur> listTuteur(){
        return userService.findAllTuteur();
    }

    @GetMapping("liste/ecole")
    public List<Utilisateur> listEcole(){
        return userService.findAllEcole();
    }

    @GetMapping("liste/parent")
    public List<Utilisateur> listParent(){
        return userService.findAllParent();
    }

    @GetMapping("trouver/{id}")
    public Utilisateur findByID(@PathVariable Long id){
        return userService.finById(id);
    }

    @GetMapping("liste/del")
    public List<Utilisateur> findAllDel(){
        return userService.FindAllDel();
    }

    @GetMapping("liste/users")
    public List<Utilisateur> listerParentEleve(){
        return userService.listerParentEleve();
    }

    //------liste des tuteurs par villes---
    @GetMapping("tuteur/{ville}")
    public List<Tuteur> TrouverParVille(@PathVariable String ville){
        return userService.TrouverParVille(ville);
    }



    //-------------------------section de modification---------------------------------------------

    @PutMapping("modify/ecole/{id}")
    public void modify_ecole(@PathVariable Long id, @RequestBody Ecole ecole){
        userService.modify_ecole(id, ecole);
    }

    @PutMapping("modify/tuteur/{id}")
    public void modify_tuteur(@PathVariable Long id, @RequestBody Tuteur tuteur){
        userService.modify_tuteur(id, tuteur);
    }

    @PutMapping("modify/eleve/{id}")
    public void modify_eleve(@PathVariable Long id, @RequestBody Eleve eleve){
        userService.modify_eleve(id, eleve);
    }

    @PutMapping("modify/parent/{id}")
    public void modify_parent(@PathVariable Long id, @RequestBody Parent parent){
        userService.modidy_parent(id, parent);
    }

    @PutMapping("tuteur/dispo/{id}")
    public boolean disponibiliter(@PathVariable Long id){
       return userService.disponibilite(id);
    }

    @PutMapping("user/modifypass/{id}")
    public void Modify_Password(@PathVariable Long id, @RequestBody Utilisateur user){
        userService.modify_pass(id, user);
    }


    //-------------------------------section supprimer te restorer---------------------------------------
    @PutMapping("del/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("restore/{id}")
    public void restorer(@PathVariable Long id){
        userService.restore(id);
    }

    //------------------------------------Login--------------------------------------------------------

    @GetMapping("login/{numero}/{password}")
    public List<Utilisateur> login(@PathVariable String numero, @PathVariable String password){
        return userService.login(numero, password);
    }

    @PutMapping("activity/{id}")
    public void Activity(@PathVariable Long id){
        userService.activity(id);
    }


    //-------------------Obtenir le nombre totale de notification-------------------------------------------

    @PutMapping("notif/total/{id}")
    public int Nb_notif(@PathVariable Long id){
        return userService.ReinitilaiserNbreDemande(id);
    }


    //-----------------------------------Les nombres totales------------------------------------------------
    @GetMapping("nombre/users")
    public int NbreTotaleUser(){
        return userService.NbreTotaleUSer();
    }
    @GetMapping("nombre/parent")
    public  int NbreTotaleParent(){
        return userService.NbreTotaleParent();
    }

    @GetMapping("nombre/tuteur")
    public int NbreTotaleTuteur(){
        return userService.NbreTotaleTuteur();
    }

    @GetMapping("nombre/eleve")
    public int NbreTotaleEleve(){
        return userService.NbreTotaleEleve();
    }

    @GetMapping("nombre/ecole")
    public  int NbreTotaleEcole(){
        return userService.NbreTotaleEcole();
    }
}
