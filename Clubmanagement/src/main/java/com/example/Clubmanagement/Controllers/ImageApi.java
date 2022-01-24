package com.example.Clubmanagement.Controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.example.Clubmanagement.Repositories.ImageRepo;
import com.example.Clubmanagement.entities.Forms.ImageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "Clubpage/image")
public class ImageApi {
    @Autowired
    ImageRepo imageRepository;

    @PostMapping("upload/{name}")
    public String uplaodImage(@RequestParam("imageFile") MultipartFile file,@PathVariable("name") String name) throws IOException {

        System.out.println("Original Image Byte Size - " + file.getBytes().length);

        ImageModel img = new ImageModel(name, file.getContentType(),
                compressBytes(file.getBytes()));

        ImageModel verif = imageRepository.findByName(name);
        if (verif==null){imageRepository.save(img);
            return "successfuly saved";
        }else {
            verif.setType(file.getContentType());
            verif.setPicByte(compressBytes(file.getBytes()));
            return "successfuly updated";
        }
    }

    @GetMapping(path = { "get/{imageName}" })
    public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
         ImageModel retrievedImage = imageRepository.findByName(imageName);
        if (retrievedImage==null){return new ImageModel();}else{
            ImageModel img = new ImageModel(retrievedImage.getName(), retrievedImage.getType(),
                    decompressBytes(retrievedImage.getPicByte()));

            return img;}
    }

        // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
        // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}