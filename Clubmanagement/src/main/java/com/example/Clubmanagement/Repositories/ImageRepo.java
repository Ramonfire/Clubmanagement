package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.Forms.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<ImageModel,Long> {
    ImageModel findByName(String name);
}
