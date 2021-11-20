package com.example.Clubmanagement.entities.club;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class reunion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id_reunion;
    private Date datedebut;
    private long duree;//minute
    private  String object;
    private String lieu;


    public long getId_reunion() {
        return id_reunion;
    }

    public void setId_reunion(long id_reunion) {
        this.id_reunion = id_reunion;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public long getDuree() {
        return duree;
    }

    public void setDuree(long duree) {
        this.duree = duree;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public reunion() {
    }

    public reunion(long id_reunion, Date datedebut, long duree, String object, String lieu) {
        this.id_reunion = id_reunion;
        this.datedebut = datedebut;
        this.duree = duree;
        this.object = object;
        this.lieu = lieu;
    }

    public reunion(Date datedebut, long duree, String object, String lieu) {
        this.datedebut = datedebut;
        this.duree = duree;
        this.object = object;
        this.lieu = lieu;
    }

    @ManyToOne(fetch =  FetchType.LAZY)
    private  Club cc;
}