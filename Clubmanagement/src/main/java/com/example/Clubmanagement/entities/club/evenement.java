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
    private  long id_event;
    private String Description;



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




    public evenement(long id_event, String description) {

        this.id_event = id_event;
        Description = description;

    }

    public evenement() {
    }

    public evenement(String description) {
        Description = description;

    }


    @OneToOne(mappedBy = "Ev")
    private  Club c;
}
