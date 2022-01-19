import { Component, OnInit } from '@angular/core';
import {VisitorService} from "../../../../Services/VisitorService";
import {Evenement} from "../../../../Classes/evenement";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-clubs',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.scss']
})
export class EventComponent implements OnInit {

  constructor(private visitorService:VisitorService) { }

  ngOnInit(): void {
    this.getEvent()
    this.getemail()
  }

  event:Evenement;
  email:string;

  getEvent(){
    this.visitorService.getEventId(parseInt(sessionStorage.getItem("id"))).subscribe((response:Evenement)=>{
      this.event=response;
      console.log(response);
    },(error:HttpErrorResponse)=>{
      alert(error.error.code);
    })
  }

  getemail(){
    this.visitorService.getSecr(parseInt(sessionStorage.getItem("id"))).subscribe((resp:string)=>{
      this.email=resp;
      console.log(resp);
    },(error:HttpErrorResponse)=>{

      alert(error.error.code);
    })
  }

}
