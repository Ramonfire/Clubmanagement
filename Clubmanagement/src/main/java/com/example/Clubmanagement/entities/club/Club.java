package com.example.Clubmanagement.entities.club;

import com.example.Clubmanagement.entities.compte.generlAc.Compte;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Clubs")

public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Club")

    private  long idc;
    private  String Nomclub;
    private Boolean etat;
    private  String description;
//contrsuctor
    public Club() {
    }

    public Club(long idc, String nomclub, Boolean etat, String description) {
        this.idc = idc;
        Nomclub = nomclub;
        this.etat = etat;
        this.description = description;
    }

    public Club(String nomclub, Boolean etat, String description) {
        Nomclub = nomclub;
        this.etat = etat;
        this.description = description;
    }

    //end contructor



    public long getIdc() {
        return idc;
    }

    public void setIdc(long idc) {
        this.idc = idc;
    }

    public String getNomclub() {
        return Nomclub;
    }

    public void setNomclub(String nomclub) {
        Nomclub = nomclub;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Club{" +
                "Nomclub='" + Nomclub + '\'' +
                ", etat=" + etat +
                ", description='" + description + '\'' +
                '}';
    }



    @ManyToMany(  fetch = FetchType.LAZY)

    private List<Compte> students = new ArrayList<Compte>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Club")
    private  budget b = new budget();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Club")
    private  List<evenement> Ev = new ArrayList<evenement>();


        }
