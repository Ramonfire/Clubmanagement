package com.example.Clubmanagement.entities.Forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.IdentityHashMap;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreationDemand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDem;
//@one demande at time
    private Long idEtudiant;
    private String TypedeDem;
    private  String NomClubD;
    private  String Descrpt;
//0 waiting . -1 denied . 1 accepted
    private  Long etatD;


}
