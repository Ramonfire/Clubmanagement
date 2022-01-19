package com.example.Clubmanagement.entities.club;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Facture")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idfacture;
    private  Long frais;
    private  String eventname;

    public facture(Long id_facture, Long frais, String e) {
        this.idfacture = id_facture;
        this.frais = frais;
        this.eventname = e;
    }

    public facture(Long frais, String eventname) {

        this.frais = frais;
        this.eventname = eventname;
    }

    public Long getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(Long id_facture) {
        this.idfacture = id_facture;
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
