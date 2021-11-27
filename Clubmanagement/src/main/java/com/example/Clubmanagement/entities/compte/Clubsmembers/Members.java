package com.example.Clubmanagement.entities.compte.Clubsmembers;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="clubs_students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Members {
    @Id
    @Column(insertable = false,updatable = false)
   private  Long club_id_club;
    @Column(insertable = false,updatable = false)
   private  Long students_id;
    private String role;


}
