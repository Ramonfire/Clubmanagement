package com.example.Clubmanagement.entities.Forms;

import lombok.*;

import javax.persistence.*;
import java.awt.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ImageModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    //image bytes can have large lengths so we specify a value
        //which is more than the default length for picByte column
    @Column(name = "picByte", length = 10000)
    private byte[] picByte;

    public ImageModel(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }
}
