import { Component, OnInit } from '@angular/core';
import {Demande} from "../../../../Classes/demande";
import {StudentService} from "../../../../Services/StudentService";
import {Router} from "@angular/router";

@Component({
  selector: 'app-createclub',
  templateUrl: './createclub.component.html',
  styleUrls: ['./createclub.component.css']
})
export class CreateclubComponent implements OnInit {
  demande=new Demande("Club","","",0);

  constructor(private StudentServ:StudentService,private router:Router) { }

  ngOnInit(): void {
  }

  SendDemande(){
    this.StudentServ.makeDemande(this.demande).subscribe((response:string)=>{
      alert(response);
      this.router.navigate(["/clubs"]);
      alert("request being treated \n it might take a few days");

    })
  }



}
