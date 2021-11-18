package com.example.Clubmanagement.club;

import com.example.Clubmanagement.compte.Clubsmembers.Members;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="Clubs")

public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    @ManyToMany( mappedBy = "Clubs" , cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_Club")
    List<Members> x;




        }
