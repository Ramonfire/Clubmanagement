import { Component, OnInit } from '@angular/core';
import {compte} from "../../../../Classes/compte";
import {AccountService} from "../../../../Services/AccountService";
import {HttpErrorResponse} from "@angular/common/http";
import {StudentService} from "../../../../Services/StudentService";

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.scss']
})

export class ProfileComponent implements OnInit {
    logUser :compte;
    UserClubCount: number;

    constructor(private AccountServ: AccountService,private studentServ: StudentService) { }

    ngOnInit() {
        this.getAccount()
        this.ClubCount()
    }


    getAccount():void{
        this.AccountServ.GetAccountInto().subscribe((response : compte)=>{
            this.logUser=response;
            this.logUser.pass="";
            console.log(this.logUser);
        },(error:HttpErrorResponse)=>{
            alert(error.error.code + "\n" + error.message)
        })
    }

    ClubCount() : void{
this.studentServ.Clubcount().subscribe((response:number)=>{
    this.UserClubCount = response;
},(error:HttpErrorResponse)=>{alert(error.error.code)})

    }
}
