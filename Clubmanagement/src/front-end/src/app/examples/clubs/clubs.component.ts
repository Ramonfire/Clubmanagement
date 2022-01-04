import { Component, OnInit } from '@angular/core';
import {StudentService} from "../../../../Services/StudentService";
import {Club} from "../../../../Classes/Club";
import {Evenement} from "../../../../Classes/evenement";
import {HttpErrorResponse} from "@angular/common/http";
import {VisitorService} from "../../../../Services/VisitorService";
import {Router} from "@angular/router";
import {stringify} from "@angular/compiler/src/util";

@Component({
  selector: 'app-clubs',
  templateUrl: './clubs.component.html',
  styleUrls: ['./clubs.component.scss']
})
export class ClubsComponent implements OnInit {
//pp
  clubs:Club[];


  constructor(private visservice:VisitorService,private router :Router) { }

  ngOnInit(): void {
      this.getClubs();
  }

getClubs(){

    this.visservice.getAllclubs(parseInt(sessionStorage.getItem("pagenum")),10).subscribe(
        (response: Club[]) => {
          this.clubs = response;
        },
        (error: HttpErrorResponse) => {
            sessionStorage.setItem("pagenum","0");
            location.reload();
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
        let integer:number=id;
      sessionStorage.setItem("id",""+id);
      console.log(sessionStorage.getItem("id"));
      this.router.navigate(["/club" ] );


    }



}
