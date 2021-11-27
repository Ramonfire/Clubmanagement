package com.example.Clubmanagement.entities.club;

import javax.persistence.*;

@Entity
@Table(name = "Facture")
public class facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_facture;
    private  Long frais;
    private  String eventname;

    public facture(Long id_facture, Long frais, String e) {
        this.id_facture = id_facture;
        this.frais = frais;
        this.eventname = e;
    }

    public facture(Long frais, String eventname) {

        this.frais = frais;
        this.eventname = eventname;
    }

    public facture() {

    }

    public Long getId_facture() {
        return id_facture;
    }

    public void setId_facture(Long id_facture) {
        this.id_facture = id_facture;
    }

    public Long getFrais() {
        return frais;
    }

    public void setFrais(Long frais) {
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
