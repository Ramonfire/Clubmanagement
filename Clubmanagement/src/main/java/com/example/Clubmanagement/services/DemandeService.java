package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.DemandeRepo;
import com.example.Clubmanagement.entities.Forms.CreationDemand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DemandeService {

    private final DemandeRepo demandeRepo;

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
