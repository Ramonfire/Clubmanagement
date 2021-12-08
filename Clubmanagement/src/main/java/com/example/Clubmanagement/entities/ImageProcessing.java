package com.example.Clubmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ImageProcessing {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "imageId" ,nullable = false,updatable = false)
    Long id;


    @Column(name = "imageName" ,nullable = false)
    String name;
    @Column(name = "imagetype" ,nullable = false)
    String type;
    @Column(name = "imageCode", length = 64)
    String imagecode;

}
