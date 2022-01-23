import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {environment} from "../src/environments/environment";
import {Observable} from "rxjs";
import {ImageModel} from "../Classes/ImageModel";
@Injectable({
    providedIn: 'root'
})


export class ImageService {
    constructor(private httpClient: HttpClient) { }
    retrievedImage: any;
    base64Data: any;
    retrieveResonse: any;
    message: string;
    imageName: any;
    private  apiBaseUrl = environment.apiBaseUrl;
    //Gets called when the user selects an image
  /*  public onFileChanged(event) {
        //Select File
        selectedFile = event.target.files[0];
    }*/
    //Gets called when the user clicks on submit to upload the image
    public onUpload(selectedFile: File,nom:string) :Observable<string> {
        console.log(selectedFile);
        //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
        const uploadImageData = new FormData();
        uploadImageData.append('imageFile', selectedFile, selectedFile.name);

      return   this.httpClient.post(`${this.apiBaseUrl}/image/upload/${nom}`, uploadImageData, { responseType:"text" });
    }
    //Gets called when the user clicks on retieve image button to get the image from back end
   public getImage(name:string) :Observable<ImageModel>{
        //Make a call to Spring Boot to get the Image Bytes.
       return  this.httpClient.get<ImageModel>('http://localhost:8080/Clubpage/image/get/' + name);
    }
}