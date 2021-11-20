package com.example.Clubmanagement.entities.compte.generlAc;

import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;

import javax.persistence.*;
import java.util.List;
@Entity

public class Etudiant extends Compte {



    private  long anetud;
    private  String programme;

    //contructor


    public Etudiant() {
    }

    public Etudiant(long anetud, String programme) {
        this.anetud = anetud;
        this.programme = programme;
    }

    public Etudiant(String civilite, String netP, String email, String pass, long tel, long anetud, String programme) {
        super(civilite, netP, email, pass, tel);
        this.anetud = anetud;
        this.programme = programme;
    }

    public Etudiant(long id, String civilite, String netP, String email, String pass, long tel, long anetud, String programme) {
        super(id, civilite, netP, email, pass, tel);
        this.anetud = anetud;
        this.programme = programme;
    }
    //end constructors
//getters adn stters
    public long getAnetud() {
        return anetud;
    }

    public void setAnetud(long anetud) {
        this.anetud = anetud;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

//to string

    @Override
    public String toString() {
        return "Etudiant{" +
                "anetud=" + anetud +
                ", programme='" + programme + '\'' +
                '}';
    }


    public Members Jclub(){

        return null;
    }
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable( name = "Members" , joinColumns = {@JoinColumn ( name ="Student_id",  referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "club_id",referencedColumnName="id_Club",nullable = false, updatable = false)})
    private List<Club> C ;



}
