import { Component, OnInit } from '@angular/core';
import {StudentService} from "../../../../Services/StudentService";
import {Club} from "../../../../Classes/Club";
import {Evenement} from "../../../../Classes/evenement";
import {HttpErrorResponse} from "@angular/common/http";
import {VisitorService} from "../../../../Services/VisitorService";
import {Router} from "@angular/router";
import {stringify} from "@angular/compiler/src/util";
import {waitForAsync} from "@angular/core/testing";

@Component({
  selector: 'app-clubs',
  templateUrl: './eventsclub.component.html',
  styleUrls: ['./eventsclub.component.scss']
})
export class EventsClubComponent implements OnInit {
//pp
  clubs:Club[];
  clublenght: number;


  constructor(private visservice:VisitorService,private router :Router) { }

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



}
