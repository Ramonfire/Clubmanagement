package com.example.Clubmanagement.compte.Clubsmembers;


import com.example.Clubmanagement.club.Club;
import com.example.Clubmanagement.compte.generlAc.Compte;
import com.example.Clubmanagement.compte.generlAc.Etudiant;

import javax.persistence.*;

@Entity
@Table(name="Members")
public class Members {
    @Id
    @Column(name = "Member_id")
    private Long Id;


    @OneToOne
    @JoinColumn(name = "Member_id")
    private Compte C;


    @ManyToMany()









}
