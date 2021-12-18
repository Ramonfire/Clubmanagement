package com.example.Clubmanagement.entities.club;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_events")
    private  Long idevent;
    private String Description;
    private  String nomevent;
    private int type ; // 0 public  /-1 club members only /1 uir students
    private int state = 0; //(IntRange(-1,1);) 0 waiting  1 accepted -1 refused
    private boolean terminer = false; // true if the event is done, false if the event isnt done.



    public Long getId_event() {
        return idevent;
    }

    public void setId_event(Long id_event) {
        this.idevent = id_event;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public evenement(Long id_event, String nomevent, String description,int type) {
        this.nomevent =nomevent;
        this.idevent = id_event;
        Description = description;
        this.type = type;
        this.state=0;


    }
    public evenement(Long id_event, String nomevent, String description, int state,int type) {
        this.nomevent =nomevent;
        this.idevent = id_event;
        Description = description;
        this.state=state;
        this.type=type;

    }

    public evenement(String nomevent,String description,int type) {
        this.nomevent =nomevent;
        this.Description = description;
        this.state=0;
        this.type=type;

    }


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private  Club c;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_fact")
    private  facture Fact = new facture();
}
