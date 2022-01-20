import { Component, OnInit } from '@angular/core';
import {Evenement} from "../../../../Classes/evenement";
import {AdminSerivce} from "../../../../Services/AdminSerivce";
import {Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-vieweventdemand',
  templateUrl: './vieweventdemand.component.html',
  styleUrls: ['./vieweventdemand.component.css']
})
export class VieweventdemandComponent implements OnInit {

  constructor(private AdminServ:AdminSerivce,private router:Router) { }
events:Evenement[];

  ngOnInit(): void {
    this.GetEvents();
  }

  GetEvents(){
    this.AdminServ.GetWaitingEvents(parseInt(sessionStorage.getItem("pagenum")),6).subscribe((response:Evenement[])=>{
  this.events=response;

        },(error:HttpErrorResponse)=>{
alert(error.error);
    })
  }


  sendtoEvent(idevent: number) {
    sessionStorage.setItem("id",""+idevent);
    this.router.navigate(['/event']);
  }
}
