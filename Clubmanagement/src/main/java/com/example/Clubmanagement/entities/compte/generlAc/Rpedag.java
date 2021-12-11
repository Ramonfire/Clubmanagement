package com.example.Clubmanagement.entities.compte.generlAc;


import com.example.Clubmanagement.entities.club.Club;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rpedag extends Compte{

    
private String departement;

    public Rpedag(String civilite, String fullname, String email, String pass, Long tel, String departement) {
        super(civilite, fullname, email, pass, tel);
        this.departement = departement;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Responsable")
    private List<Club> clubs = new ArrayList<Club>();


}
