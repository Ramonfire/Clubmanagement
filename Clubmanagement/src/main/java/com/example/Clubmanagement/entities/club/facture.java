package com.example.Clubmanagement.entities.club;

import javax.persistence.*;

@Entity
@Table(name = "Facture")
public class facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id_facture;
    private  long frais;
    private  String eventname;

    public facture(long id_facture, long frais, String e) {
        this.id_facture = id_facture;
        this.frais = frais;
        this.eventname = e;
    }

    public facture(long frais, String eventname) {

        this.frais = frais;
        this.eventname = eventname;
    }

    public facture() {

    }

    public long getId_facture() {
        return id_facture;
    }

    public void setId_facture(long id_facture) {
        this.id_facture = id_facture;
    }

    public long getFrais() {
        return frais;
    }

    public void setFrais(long frais) {
        this.frais = frais;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }


    @OneToOne(mappedBy = "Fact")
    private  evenement evt;
}
