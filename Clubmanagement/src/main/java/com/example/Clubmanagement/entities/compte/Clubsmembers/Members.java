package com.example.Clubmanagement.entities.compte.Clubsmembers;


import javax.persistence.*;


@Entity
@Table(name="clubs_students")

public class Members {
    @Id
    @Column(insertable = false,updatable = false)
   private long club_id_club;
    @Column(insertable = false,updatable = false)
   private  long students_id;


}
