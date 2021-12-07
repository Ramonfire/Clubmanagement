package com.example.Clubmanagement.entities.compte.generlAc;


import javax.persistence.*;


@Entity
@Table


public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,nullable = false)

    private Long idE;
    @Column(nullable = false)
    private String civilite ;
    @Column(nullable = false)
    private String fullname;//Nom et prenom
    @Column(nullable = false)
    private  String email;
    @Column(nullable = false)
    private String pass;
    @Column(nullable = false)
    private Long tel;



//constructeur
    public Compte() {
    }

    public Compte(String civilite, String fullname, String email, String pass, Long tel) {
        this.civilite = civilite;
        this.fullname = fullname;
        this.email = email;
        this.pass = pass;
        this.tel = tel;
    }

    public Compte(Long id, String civilite, String fullname, String email, String pass, Long tel) {
        this.idE = id;
        this.civilite = civilite;
        this.fullname = fullname;
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
        this.fullname = fullname;
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
