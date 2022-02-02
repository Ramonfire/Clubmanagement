package com.example.Clubmanagement.entities.club;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class reunion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idreunion;
    private LocalDateTime datedebut;
    private Long duree;//minute
    private  String object;
    private String lieu;


    public Long getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(Long idreunion) {
        this.idreunion = idreunion;
    }

    public LocalDateTime getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(LocalDateTime datedebut) {
        this.datedebut = datedebut;
    }

    public Long getDuree() {
        return duree;
    }

    public void setDuree(Long duree) {
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

    public reunion(Long idreunion, LocalDateTime datedebut, Long duree, String object, String lieu) {
        this.idreunion = idreunion;
        this.datedebut = datedebut;
        this.duree = duree;
        this.object = object;
        this.lieu = lieu;
    }

    public reunion(LocalDateTime datedebut, Long duree, String object, String lieu) {
        this.datedebut = datedebut;
        this.duree = duree;
        this.object = object;
        this.lieu = lieu;
    }

    @JsonBackReference
    @ManyToOne(fetch =  FetchType.LAZY)
    private  Club cc;
}
