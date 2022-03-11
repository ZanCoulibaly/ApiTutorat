package com.example.apitutorat.demande.service;

import com.example.apitutorat.demande.Demande;
import com.example.apitutorat.demande.Etat;
import com.example.apitutorat.demande.repository.DemandeRepository;
import com.example.apitutorat.users.Utilisateur;
import com.example.apitutorat.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeServiceImp implements DemandeService{

    @Autowired
    DemandeRepository demandeRepository;

    @Autowired
    UsersRepository usersRepository;


    @Override
    public Demande sendDemande(Long from, Long to, String matiere) {
        Utilisateur sender= usersRepository.findById(from).get();
        Utilisateur receveur= usersRepository.findById(to).get();

        Demande demande= new Demande();
        demande.setEnvoyeur(sender);
        demande.setReceveur(receveur);
        demande.setMatiere(matiere);
        demande.setContenu("Vous solicite en "+matiere);

        //receveur.setOldTotale(receveur.getTotaleNotif());
        receveur.setTotaleNotif(receveur.getTotaleNotif()+1);

         usersRepository.save(receveur);
        return demandeRepository.save(demande);
    }

    @Override
    public void InitierDemande(Long id) {
        Demande demande = demandeRepository.findById(id).get();
        if (demande.isInitier()){
            demande.setInitier(false);
        }else {
            demande.setInitier(true);
        }
        demandeRepository.save(demande);
    }

    @Override
    public Demande declinerDemande(Long id) {
        Demande demande = demandeRepository.findById(id).get();
        demande.setEtat(Etat.DECLINER);
       return demandeRepository.save(demande);
    }

    @Override
    public Demande accepterDemande(Long id) {
        Demande demande= demandeRepository.findById(id).get();
        demande.setEtat(Etat.ACCEPTER);
        return demandeRepository.save(demande);
    }

    @Override
    public List<Demande> listesAllDemande(Long from_id, Long to_id) {
        Utilisateur from= usersRepository.findById(from_id).get();
        Utilisateur to= usersRepository.findById(to_id).get();
        return demandeRepository.findByEnvoyeurAndReceveurAndEtatIsTrue(from,to);
    }

    @Override
    public List<Demande> GetByReceveur(Long id) {
        Utilisateur user= usersRepository.findById(id).get();
        return demandeRepository.findByReceveur(user);
    }

    @Override
    public List<Demande> ListeAllInitier() {
        return demandeRepository.findByInitierIsTrue();
    }

    @Override
    public List<Demande> InitierByEnvoyeurAndReceveur(Long from_id) {
        Utilisateur envoyeur= usersRepository.findById(from_id).get();

        return demandeRepository.findByReceveurAndInitierIsTrue(envoyeur);
    }

    @Override
    public List<Demande> InitierByReceveurAndEnvoyeur(Long to_id) {
        Utilisateur receveur = usersRepository.findById(to_id).get();
        return  demandeRepository.findByEnvoyeurAndInitierIsTrue(receveur);
    }

    @Override
    public Demande DEMANDEById(Long id) {
        Demande demande = demandeRepository.findById(id).get();
        return demande;
    }

    @Override
    public Demande demandeByMatiere(Long from, Long to, String matiere) {
        Utilisateur sender= usersRepository.findById(from).get();
        Utilisateur receveur= usersRepository.findById(to).get();
        return demandeRepository.findByEnvoyeurAndReceveurAndMatiere(sender, receveur, matiere);
    }
}
