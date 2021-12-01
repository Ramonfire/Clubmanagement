package com.example.Clubmanagement.entities.club;

import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.entities.compte.generlAc.R_pedag;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Clubs")


public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdClub")

    private  Long idc;
    private  String nomclub;
    private Boolean etat;
    private  String description;
//contrsuctor
    public Club() {
    }

    public Club(Long idc, String nomclub, Boolean etat, String description) {
        this.idc = idc;
        this.nomclub = nomclub;
        this.etat = etat;
        this.description = description;
    }

    public Club(String nomclub, Boolean etat, String description) {
        this.nomclub = nomclub;
        this.etat = etat;
        this.description = description;
    }

    //end contructor



    public Long getIdc() {
        return idc;
    }

    public void setIdc(Long idc) {
        this.idc = idc;
    }

    public String getnomclub() {
        return nomclub;
    }

    public void setnomclub(String nomclub) {
        nomclub = nomclub;
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
                "nomclub='" + nomclub + '\'' +
                ", etat=" + etat +
                ", description='" + description + '\'' +
                '}';
    }



    @ManyToMany(  fetch = FetchType.LAZY)

    private List<Etudiant> students = new ArrayList<Etudiant>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Budget")
    private  budget b;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_events")
    private  List<evenement> Ev = new ArrayList<evenement>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reunions")
    private  List<reunion> reunions = new ArrayList<reunion>();


    @ManyToOne(fetch = FetchType.LAZY)
    private R_pedag ped;


        }
