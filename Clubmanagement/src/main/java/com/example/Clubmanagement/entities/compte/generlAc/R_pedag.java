package com.example.Clubmanagement.entities.compte.generlAc;


import com.example.Clubmanagement.entities.club.Club;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class R_pedag extends Compte{



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_clubs")
    private List<Club> clubs = new ArrayList<Club>();


}
