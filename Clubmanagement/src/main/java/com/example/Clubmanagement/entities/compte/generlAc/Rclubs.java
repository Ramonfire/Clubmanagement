package com.example.Clubmanagement.entities.compte.generlAc;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rclubs extends Compte {

private  String mot;

    public Rclubs(String civilite, String fullname, String email, String pass, Long tel, String mot) {
        super(civilite, fullname, email, pass, tel);
        this.mot = mot;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }
}
