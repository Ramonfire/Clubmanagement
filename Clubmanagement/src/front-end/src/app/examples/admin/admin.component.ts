import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AdminSerivce} from "../../../../Services/AdminSerivce";
import {Observable} from "rxjs";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
    selector: 'app-profile',
    templateUrl: './admin.component.html',
    styleUrls: ['./admin.component.scss']
})

export class AdminComponent implements OnInit {

    constructor(private router:Router,private AdminServ:AdminSerivce) { }

    ngOnInit() {
        this.verifyadmin()
        this.getEventByState();
        this.NewDemandeNumber();
        this.totalActifEventnumber();
        this.totalClubNumber();
    }

    waitingevents:number;
    allevents:number;
    allclubs:number;
    newDemands: number;

    getEventByState(){
        this.AdminServ.GetCountEventsByState(0).subscribe((response:number)=>{
            this.waitingevents=response;
        },(error:HttpErrorResponse)=>{
            alert(error.error.code)
        });
    }
    NewDemandeNumber(){
        this.AdminServ.GetCountDemandeByState(0).subscribe((response:number)=>{
            this.newDemands=response;
        },(error:HttpErrorResponse)=>{
            alert(error.error.code)
        });

    }

    totalActifEventnumber(){
        this.AdminServ.GetCountEventsByState(1).subscribe((response:number)=>{
            this.allevents=response;
        },(error:HttpErrorResponse)=>{
            alert(error.error.code)
        });

    }

totalClubNumber(){
    this.AdminServ.GetCountClubs().subscribe((response:number)=>{
        this.allclubs=response;
    },(error:HttpErrorResponse)=>{
        alert(error.error.code)
    });
}

word:string;

UpdateAdminWord(){
this.AdminServ.UpdateMot(this.word).subscribe((response:string)=>{
    alert(response)
},(error:HttpErrorResponse)=>{
    alert(error.error.code)
});
}









    verifyadmin(){
        if (sessionStorage.getItem("role")!="Role_Admin"){
            alert("You do not have access to this content")
            this.router.navigate(["/landing"])
        }
    }

}
