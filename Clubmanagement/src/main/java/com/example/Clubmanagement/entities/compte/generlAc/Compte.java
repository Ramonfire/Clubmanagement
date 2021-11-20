package com.example.Clubmanagement.entities.compte.generlAc;

import com.example.Clubmanagement.entities.club.Club;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Comptes")

public class Compte {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private long idE;
    private String civilite ;
    private String NetP;
    private  String email;
    private String pass;
    private long tel;


//constructeur
    public Compte() {
    }

    public Compte(String civilite, String netP, String email, String pass, long tel) {
        this.civilite = civilite;
        NetP = netP;
        this.email = email;
        this.pass = pass;
        this.tel = tel;
    }

    public Compte(long id, String civilite, String netP, String email, String pass, long tel) {
        this.idE = id;
        this.civilite = civilite;
        NetP = netP;
        this.email = email;
        this.pass = pass;
        this.tel = tel;
    }
    //end constructor


    public long getId() {
        return idE;
    }

    public void setId(long id) {
        this.idE = id;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNetP() {
        return NetP;
    }

    public void setNetP(String netP) {
        NetP = netP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }


    @Override
    public String toString() {
        return "Compte{"+
                " civilite='" + civilite + '\'' +
                ", NetP='" + NetP + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", tel=" + tel +
                '}';
    }








}
