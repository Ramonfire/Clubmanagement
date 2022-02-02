import { Component, OnInit } from '@angular/core';
import {Demande} from "../../../../Classes/demande";
import {StudentService} from "../../../../Services/StudentService";
import {Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";
import {compte} from "../../../../Classes/compte";
import {Reunion} from "../../../../Classes/reunion";
import {Club} from "../../../../Classes/Club";
import {VisitorService} from "../../../../Services/VisitorService";

@Component({
  selector: 'app-createreunion',
  templateUrl: './createreunioncomponent.html',
    styleUrls: ['./createreunioncomponent.css']
})
export class CreateReunionComponent implements OnInit {
 reun=new Reunion();

  constructor(private router:Router,
              private studentserv:StudentService,
              private visitorService:VisitorService) { }

  ngOnInit(): void {
      this.getClub()
  }


  SendDemande() {
console.log(this.reun);
console.log(this.Club)

      this.studentserv.addreunion(this.reun,this.Club.idc).subscribe((response:string)=>{
          alert(response);
      })

  }

Club:Club;

    getClub(){
        if (sessionStorage.getItem("id")==null||sessionStorage.getItem("id")=="0"){
            this.router.navigate(['/clubs'])
        }else {
            this.visitorService.getClubId(parseInt(sessionStorage.getItem("id"))).subscribe(
                (response: Club) => {
                    this.Club = response;
                }, (error: HttpErrorResponse) => {
                    alert("error while finding the club");
                }
            );}
    }
}
