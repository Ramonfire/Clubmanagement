package com.example.Clubmanagement.entities.club;

import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.entities.compte.generlAc.Rpedag;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Clubs")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdClub")

    private  Long idc;
    private  String nomclub;
    private boolean etat;
    private  String description;
    private float budget;

    public Club(Long idc, String nomclub, boolean etat, String description) {
        this.idc = idc;
        this.nomclub = nomclub;
        this.etat = etat;
        this.description = description;
    }

    public Club(String nomclub, boolean etat, String description) {
        this.nomclub = nomclub;
        this.etat = etat;
        this.description = description;
    }

    public Club(String nomclub, boolean etat, String description, float budget) {
        this.nomclub = nomclub;
        this.etat = etat;
        this.description = description;
        this.budget = budget;
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
        this.nomclub = nomclub;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
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



    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_events")
    private  List<evenement> Ev = new ArrayList<evenement>();


    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    private  List<reunion> reunions = new ArrayList<reunion>();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Compte ped;


        }
