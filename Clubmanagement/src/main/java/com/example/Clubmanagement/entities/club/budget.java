package com.example.Clubmanagement.entities.club;

import javax.persistence.*;
import javax.persistence.OneToOne;

@Entity
@Table(name = "Budget")


public class budget {
    private float Somme;
    private float Budget;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id_budget;

    public float getSomme() {
        return Somme;
    }

    public void setSomme(float somme) {
        Somme = somme;
    }

    public float getBudget() {
        return Budget;
    }

    public void setBudget(float budget) {
        Budget = budget;
    }

    public long getId_budget() {
        return id_budget;
    }

    public void setId_budget(long id_budget) {
        this.id_budget = id_budget;
    }


    public budget(float somme, float budget, long id_budget) {
        Somme = somme;
        Budget = budget;
        this.id_budget = id_budget;
    }

    public budget() {
    }

    public budget(float somme, float budget) {
        Somme = somme;
        Budget = budget;
    }


    @OneToOne(mappedBy = "b")
    private  Club C ;
}