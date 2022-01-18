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
this.Adminserv.getDemande(0,parseInt(sessionStorage.getItem("pagenum")),6).subscribe((response:Demande[])=>{
  this.demande=response;
  console.log(this.demande)
},(error:HttpErrorResponse)=>{alert(error.error.code)});
}

  AcceptDemande(idDem: number) {
    let de:Demande;
    let Chosen:Demande;
    for (de of this.demande){
      if (de.idDem==idDem){
        Chosen = de;
        console.log(Chosen)
      }
    }
this.Adminserv.AcceptDemande(Chosen).subscribe((response:string)=>{
  alert(response);
  location.reload();
},(error:HttpErrorResponse)=>{alert(error.error.code)});
  }

  refuserDemande(idDem: number) {
    let de:Demande;
    let Chosen:Demande;
    for (de of this.demande){
      if (de.idDem==idDem){
        Chosen = de;
        console.log(Chosen)
      }
    }
    this.Adminserv.RefusedDemande(Chosen).subscribe((response:string)=>{
      alert(response);
      location.reload();
    },(error:HttpErrorResponse)=>{alert(error.error.code)});
  }


  refreshtonext() {
    let integer:number= parseInt(sessionStorage.getItem("pagenum"))+1;
    sessionStorage.setItem("pagenum",integer.toString());
    location.reload();
  }

  refreshtobefore() {
    let integer:number= parseInt(sessionStorage.getItem("pagenum"))-1;
    if (integer<0){integer=0}
    sessionStorage.setItem("pagenum",integer.toString());
    location.reload();

  }


}
