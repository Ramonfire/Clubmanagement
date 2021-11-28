package com.example.Clubmanagement.entities.compte.generlAc;


import com.example.Clubmanagement.entities.club.Club;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R_pedag extends Compte{
private String departement;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Responsable")
    private List<Club> clubs = new ArrayList<Club>();


}
