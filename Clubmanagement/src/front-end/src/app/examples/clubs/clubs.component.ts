import { Component, OnInit } from '@angular/core';
import {StudentService} from "../../../../Services/StudentService";
import {Club} from "../../../../Classes/Club";
import {Evenement} from "../../../../Classes/evenement";
import {HttpErrorResponse} from "@angular/common/http";
import {VisitorService} from "../../../../Services/VisitorService";
import {Router} from "@angular/router";
import {stringify} from "@angular/compiler/src/util";
import {waitForAsync} from "@angular/core/testing";
import {AuthentificationService} from "../signin/auth.service";
import {ImageService} from "../../../../Services/ImageService";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";
import {ImageModel} from "../../../../Classes/ImageModel";

@Component({
  selector: 'app-clubs',
  templateUrl: './clubs.component.html',
  styleUrls: ['./clubs.component.scss']
})
export class ClubsComponent implements OnInit {
//pp
  clubs:Club[];
  clublenght: number;


  constructor(private visservice:VisitorService,private router :Router,
              private authenServ:AuthentificationService,
              private imgServ:ImageService,
              private sanitizer: DomSanitizer) { }

  ngOnInit(): void {

      this.getClubs();

  }

getClubs(){

    this.visservice.getAllclubs(parseInt(sessionStorage.getItem("pagenum")),6).subscribe(
        (response: Club[]) => {
          this.clubs = response;
          this.clublenght=response.length;
        },
        (error: HttpErrorResponse) => {
            if (sessionStorage.getItem("pagenum")){
            sessionStorage.setItem("pagenum","0");
            location.reload();}
            else {
                alert("Session expired");
                this.router.navigate(["/signin"])
            }
        }
    );
}


    refreshtonext() {
        let integer:number= parseInt(sessionStorage.getItem("pagenum"))+1;
        sessionStorage.setItem("pagenum",integer.toString());
        location.reload();
    }

    refreshtobefore() {
        let integer:number= parseInt(sessionStorage.getItem("pagenum"))-1;
        if (integer<0){integer+1}
        sessionStorage.setItem("pagenum",integer.toString());
        location.reload();

    }

    sendToclubinfo(id:number) {
      //doesnt work to review in html adn ts
      sessionStorage.setItem("id",""+id);
      console.log(sessionStorage.getItem("id"));
      this.router.navigate(["/club" ] );


    }

sendToCreate(){
      this.router.navigate(["/createclub"]);
}

verifyUser(){
      if (this.authenServ.isUserLoggedIn()){
          if (sessionStorage.getItem("role")=="Role_Admin"){return false;}
          else return true
      }else return false
}




    test:boolean=false;
    imageSrc:string;
    srcData:SafeResourceUrl;
    getimage(club:Club){
        this.imgServ.getImage(""+club.nomclub).subscribe((response:ImageModel)=>{
            if (response.picByte==null) this.test=false; else this.test=true;
            this.imageSrc = 'data:image/'+response.type+';base64,' + response.picByte;
            this.srcData = this.sanitizer.bypassSecurityTrustResourceUrl(this.imageSrc);
        })
    }

}
