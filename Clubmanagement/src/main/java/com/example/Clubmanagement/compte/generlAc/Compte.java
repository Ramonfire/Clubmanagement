package com.example.Clubmanagement.compte.generlAc;

import com.example.Clubmanagement.club.Club;
import com.example.Clubmanagement.compte.Clubsmembers.Members;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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



    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable( name = "Members" , joinColumns = {@JoinColumn ( name ="Student_id",  referencedColumnName = "id", nullable = false, updatable = false)},
                            inverseJoinColumns = {@JoinColumn(name = "club_id",referencedColumnName="id_Club",nullable = false, updatable = false)})
    private List<Club> C ;




}
