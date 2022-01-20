import { Component, OnInit } from '@angular/core';
import {VisitorService} from "../../../../Services/VisitorService";
import {Evenement} from "../../../../Classes/evenement";
import {HttpErrorResponse} from "@angular/common/http";
import {AdminSerivce} from "../../../../Services/AdminSerivce";

@Component({
  selector: 'app-clubs',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.scss']
})
export class EventComponent implements OnInit {

  constructor(private visitorService:VisitorService,private adminServ:AdminSerivce) { }

  ngOnInit(): void {
    this.getEvent()
    this.getemail()
  }

  event:Evenement;
  email:string;

  getEvent(){
    this.visitorService.getEventId(parseInt(sessionStorage.getItem("id"))).subscribe((response:Evenement)=>{
      this.event=response;
    },(error:HttpErrorResponse)=>{
      alert(error.error.code);
    })
  }

  getemail(){
    this.visitorService.getSecr(parseInt(sessionStorage.getItem("id"))).subscribe((resp:string)=>{
      this.email=resp;
    },(error:HttpErrorResponse)=>{

      alert(error.error.code);
    })
  }


  verifyEventtype(){
    if (this.event.state==0){
      return true;
    }else return false;
  }

  RefuseEvent(idevent: number) {
    this.adminServ.RefuserEvent(this.event.idevent).subscribe((response:string)=>{
      alert(response);
    },()=>{})
    
  }

  AcceptEvent(idevent: number) {
    this.adminServ.Acceptevent(this.event.idevent).subscribe((response:string)=>{
      alert(response);
    },()=>{})
  }
}
