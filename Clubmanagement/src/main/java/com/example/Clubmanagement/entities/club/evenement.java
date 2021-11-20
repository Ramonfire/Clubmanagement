package com.example.Clubmanagement.entities.club;


import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.awt.*;
import java.lang.management.GarbageCollectorMXBean;

@Entity
@Table(name = "Events")
public class evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_events")
    private  long id_event;
    private String Description;
    private  String nomevent;



    public long getId_event() {
        return id_event;
    }

    public void setId_event(long id_event) {
        this.id_event = id_event;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getNomevent() {
        return nomevent;
    }

    public void setNomevent(String nomevent) {
        this.nomevent = nomevent;
    }

    public evenement(long id_event, String nomevent,String description) {
        this.nomevent =nomevent;
        this.id_event = id_event;
        Description = description;

    }

    public evenement() {
    }

    public evenement(String nomevent,String description) {
        this.nomevent =nomevent;
        this.Description = description;

    }


    @ManyToOne(fetch = FetchType.LAZY)
    private  Club c;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_events")
    private  facture Fact = new facture();
}
