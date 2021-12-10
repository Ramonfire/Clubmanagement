package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.DemandeRepo;
import com.example.Clubmanagement.entities.Forms.CreationDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeService {

    private final DemandeRepo demandeRepo;

    @Autowired
    public DemandeService(DemandeRepo demandeRepo) {
        this.demandeRepo = demandeRepo;
    }

public List<CreationDemand> getAllDemands(){
        return demandeRepo.findAll();
}
public  List<CreationDemand> getdemandeBystate(boolean etat){return demandeRepo.findAllByEtatD(etat);}
    public List<CreationDemand> getEtudiantDemande(Long idE){return demandeRepo.getAllByIdEtudiant(idE);}

    //saveguard de demande
    public CreationDemand saveDemande(CreationDemand demand){
        return demandeRepo.save(demand);
    }


}
