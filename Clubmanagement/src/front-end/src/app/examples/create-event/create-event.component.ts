import { Component, OnInit } from '@angular/core';
import {MemberService} from "../../../../Services/MemberService";
import {Router} from "@angular/router";
import {ImageService} from "../../../../Services/ImageService";
import {DomSanitizer} from "@angular/platform-browser";
import {Evenement} from "../../../../Classes/evenement";
import {Club} from "../../../../Classes/Club";
import {VisitorService} from "../../../../Services/VisitorService";
import {HttpErrorResponse} from "@angular/common/http";
import {Members} from "../../../../Classes/Members";
import {AuthentificationService} from "../../../../Services/auth.service";
import {Facture} from "../../../../Classes/facture";

@Component({
  selector: 'app-create-event',
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.css']
})
export class CreateEventComponent implements OnInit {

  constructor(private visitorService:VisitorService,private memberservice:MemberService,private router:Router,
              private imgServ:ImageService,
              private sanitizer: DomSanitizer,
              private authentifserv:AuthentificationService) { }

  ngOnInit(): void {
    this.getClub()
  }


  event=new Evenement();
  Club:Club;

  Createevent(){
    this.event.fact.eventname=this.event.nomevent;
    this.event.state=0;
    this.event.terminer=false;
    console.log(this.event)
    this.memberservice.CreateEvent(this.event,this.Club.idc).subscribe((response:string)=>{
      alert(response);
    },(error:HttpErrorResponse)=>{alert("Error : "+error.status)});
  }

  getClub(){
    if (sessionStorage.getItem("id")==null){
      this.router.navigate(['/clubs'])
    }else {
    this.visitorService.getClubId(parseInt(sessionStorage.getItem("id"))).subscribe(
        (response: Club) => {
          this.Club = response;
          this.getMember();
          if (this.member.role=="member" || this.member.role==null){
            alert('not a club admin');
            this.router.navigate(['/club'])
          }
        }, (error: HttpErrorResponse) => {
          alert("error while finding the club");
        }
    );}
  }


  member:Members;
  getMember(){
    if (this.authentifserv.isUserLoggedIn()){
      this.memberservice.getMemberByClub(this.Club.idc).subscribe((response:Members)=>{
        this.member=response;
      },(error:HttpErrorResponse)=>{alert(error.status)})}
  }


  Loggingevenement(){
    this.event.fact.eventname=this.event.nomevent;
    this.event.state=0;
    this.event.terminer=false;
    console.log(this.event)}


}
