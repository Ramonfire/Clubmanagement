package com.example.Clubmanagement.compte.Clubsmembers;


import com.example.Clubmanagement.club.Club;
import com.example.Clubmanagement.compte.generlAc.Compte;
import com.example.Clubmanagement.compte.generlAc.Etudiant;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Members")
public class Members {
    @Id
    @Column(name = "Member_id")
    private Long Id;

    @OneToOne
    @JoinColumn(name = "Member_id")
    private Compte C;

    @Column(name = "idclub")
 private  long idC;

    @ManyToMany( mappedBy = "Clubs" , cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idclub")
    List<Club> Cl;









}
