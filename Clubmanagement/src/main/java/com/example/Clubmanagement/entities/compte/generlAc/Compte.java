package com.example.Clubmanagement.entities.compte.generlAc;



import javax.persistence.*;


@Entity



public class Compte {
    @Id
    @Column(name = "id")

    private Long idE;
    private Long idUser;
    private String civilite ;
    private String NetP;
    private  String email;
    private String pass;
    private Long tel;



//constructeur
    public Compte() {
    }

    public Compte(String civilite, String netP, String email, String pass, Long tel) {
        this.civilite = civilite;
        NetP = netP;
        this.email = email;
        this.pass = pass;
        this.tel = tel;
    }

    public Compte(Long id, String civilite, String netP, String email, String pass, Long tel) {
        this.idE = id;
        this.civilite = civilite;
        NetP = netP;
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
                ", NetP='" + NetP + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", tel=" + tel +
                '}';
    }








}
