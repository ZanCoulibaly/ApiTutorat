package com.example.apitutorat.demande.controller;

import com.example.apitutorat.demande.Demande;
import com.example.apitutorat.demande.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/demande/")
public class DemandeController {
    @Autowired
    DemandeService demandeService;

    @PostMapping("send/{from}/{to}/{matiere}")
    public Demande sendDemande(@PathVariable Long from, @PathVariable Long to, @PathVariable String matiere){
        return demandeService.sendDemande(from, to, matiere);
    }

    @GetMapping("notif/{id}")
    public List<Demande> GetMyDemande(@PathVariable Long id){
        return demandeService.GetByReceveur(id);
    }

    @PutMapping("accepter/{id}")
    public void InititierDemande(@PathVariable Long id){
        demandeService.InitierDemande(id);
    }

    @PutMapping("decliner/{id}")
    public Demande DeclinerDemande(@PathVariable Long id){
       return demandeService.declinerDemande(id);
    }

    @PutMapping("aprouve/{id}")
    public Demande AccepterDemande(@PathVariable Long id){
       return demandeService.accepterDemande(id);
    }

    @GetMapping("initier")
    public List<Demande> init(){
        return demandeService.ListeAllInitier();
    }

    @GetMapping("initier/{from}")
    public List<Demande> GetListeInitierByEnvoyeurAndReceveur(@PathVariable Long from){
        return demandeService.InitierByEnvoyeurAndReceveur(from);
    }

    @GetMapping("initier/to/{from}")
    public List<Demande> GetListeInitierByReceveurAndEnvoyeur(@PathVariable Long from){
        return demandeService.InitierByReceveurAndEnvoyeur(from);
    }


    @GetMapping("/{id}")
    public Demande demandeById(@PathVariable Long id){
        return demandeService.DEMANDEById(id);
    }

    @GetMapping("ifexist/{from}/{to}/{matiere}")
    public Demande ifExist(@PathVariable Long from, @PathVariable Long to, @PathVariable String matiere){
        return demandeService.demandeByMatiere(from, to, matiere);
    }
}
