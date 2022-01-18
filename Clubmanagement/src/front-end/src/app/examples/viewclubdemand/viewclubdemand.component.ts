import { Component, OnInit } from '@angular/core';
import {Demande} from "../../../../Classes/demande";
import {Club} from "../../../../Classes/Club";
import {AdminSerivce} from "../../../../Services/AdminSerivce";
import {AuthentificationService} from "../signin/auth.service";
import {Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-viewclubdemand',
  templateUrl: './viewclubdemand.component.html',
  styleUrls: ['./viewclubdemand.component.css']
})
export class ViewclubdemandComponent implements OnInit {

  constructor(private Adminserv:AdminSerivce,private  authServ:AuthentificationService,private router:Router) { }
  demande:Demande[];

  club:Club;

  ngOnInit(): void {
this.isloggedin();
this.GetWaitingDemands();

  }

  isloggedin(){
    if (!this.authServ.isUserLoggedIn()){
      alert("please login");
      this.router.navigate(["/signin"])
    }
    if (sessionStorage.getItem("role")!="Role_Admin"){
      alert("Not an admin");
      this.router.navigate(["/landing"])
    }
  }


GetWaitingDemands(){
this.Adminserv.getDemande(0).subscribe((response:Demande[])=>{
  this.demande=response;
},(error:HttpErrorResponse)=>{alert(error.error.code)});
}

}