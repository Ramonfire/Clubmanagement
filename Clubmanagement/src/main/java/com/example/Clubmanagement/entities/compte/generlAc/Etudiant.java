package com.example.Clubmanagement.entities.compte.generlAc;

import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Etudiant extends Compte {



    private  Long anetud ;
    private  String programme;
// to declare a table with ids an roles to make getting roles easy.

    //contructor


    public Etudiant(Long anetud, String programme) {
        this.anetud = anetud;
        this.programme = programme;
    }

    public Etudiant(String civilite, String fullname, String email, String pass, Long tel, Long anetud, String programme) {
        super(civilite, fullname, email, pass, tel);
        this.anetud = anetud;
        this.programme = programme;
    }

    public Etudiant(Long id, String civilite, String fullname, String email, String pass, Long tel, Long anetud, String programme) {
        super(id, civilite, fullname, email, pass, tel);
        this.anetud = anetud;
        this.programme = programme;
    }
    //end constructors
//getters adn stters
    public Long getAnetud() {
        return anetud;
    }

    public void setAnetud(Long anetud) {
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
        return super.toString() +
                "anetud=" + anetud +
                ", programme='" + programme + '\'' +
                '}';
    }


    public Members Jclub(){

        return null;
    }
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable( name = "Members" , joinColumns = {@JoinColumn ( name ="Student_id",  referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "club_id",referencedColumnName="IdClub",nullable = false, updatable = false)})
    private List<Club> C ;



}
