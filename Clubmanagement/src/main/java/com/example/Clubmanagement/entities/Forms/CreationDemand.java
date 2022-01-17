package com.example.Clubmanagement.entities.Forms;

import lombok.*;

import javax.persistence.*;
import java.util.IdentityHashMap;

@Entity
@Table
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreationDemand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDem;
//@one demande at time
    private Long idEtudiant;
    private String typedeDem;
    private  String nomClubD;
    private  String descrpt;
//0 waiting . -1 denied . 1 accepted
    private  int etatD;


}
