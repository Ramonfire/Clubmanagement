package com.example.Clubmanagement.entities.compte.generlAc;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity



public class Compte {
    @Id
    @Column(name = "id")

    private Long idE;
    private Long idUser;
    private String civilite ;
    private String fullname;//Nom et prenom
    private  String email;
    private String pass;
    private Long tel;



//constructeur
    public Compte() {
    }

    public Compte(String civilite, String fullname, String email, String pass, Long tel) {
        this.civilite = civilite;
        fullname = fullname;
        this.email = email;
        this.pass = pass;
        this.tel = tel;
    }

    public Compte(Long id, String civilite, String fullname, String email, String pass, Long tel) {
        this.idE = id;
        this.civilite = civilite;
        fullname = fullname;
        this.email = email;
        this.pass = pass;
        this.tel = tel;
    }
    //end constructor


    public Long getId() {
        return idE;
    }

    public void setId(Long id) {
        this.idE = id;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getfullname() {
        return fullname;
    }

    public void setfullname(String fullname) {
        fullname = fullname;
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

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }


    @Override
    public String toString() {
        return "Compte{"+
                " civilite='" + civilite + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", tel=" + tel +
                '}';
    }








}
