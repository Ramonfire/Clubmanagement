package com.example.Clubmanagement.entities.compte.Clubsmembers;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;


@Entity
@Table(name="clubs_students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMember")
    private Long idmembre;// place holder collumn for security reasons


    @Column(nullable = false,updatable = false ,name= "club_id_club")
   private  Long clubid;
    @Column(nullable = false,updatable = false, name ="students_id")
   private  Long Studentid;
    private String role;

    public Members(Long clubid, Long studentid, String role) {
        this.clubid = clubid;
        Studentid = studentid;
        this.role = role;
    }
}
