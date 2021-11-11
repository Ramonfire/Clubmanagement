package com.example.Clubmanagement.compte.generlAc;

import com.example.Clubmanagement.compte.Clubsmembers.Members;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


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
}
