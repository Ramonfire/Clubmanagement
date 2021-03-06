import { Component, OnInit } from '@angular/core';
import {compte} from "../../../../Classes/compte";
import {AccountService} from "../../../../Services/AccountService";
import {HttpErrorResponse} from "@angular/common/http";
import {StudentService} from "../../../../Services/StudentService";
import {ImageModel} from "../../../../Classes/ImageModel";
import {ImageService} from "../../../../Services/ImageService";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.scss']
})

export class ProfileComponent implements OnInit {
    logUser :compte;
    UserClubCount: number;

    constructor(private AccountServ: AccountService,private studentServ: StudentService,private imgServ:ImageService,
                private sanitizer:DomSanitizer) { }

    ngOnInit() {
        this.getAccount()
        this.ClubCount()
    }


    getAccount():void{
        this.AccountServ.GetAccountInto().subscribe((response : compte)=>{
            this.logUser=response;
            this.logUser.pass="";
            this.getimage();
        },(error:HttpErrorResponse)=>{
            alert(error.status + "\n" + error.error.code)
        })
    }

    ClubCount() : void{
this.studentServ.Clubcount().subscribe((response:number)=>{
    this.UserClubCount = response;
},(error:HttpErrorResponse)=>{alert(error.error.code)})

    }
    imageSrc:string;
    srcData:SafeResourceUrl;
    password1: string;
    password2: string;

    getimage(){
        this.imgServ.getImage(""+this.logUser.fullname).subscribe((response:ImageModel)=>{
            this.imageSrc = 'data:image/'+response.type+';base64,' + response.picByte;
            this.srcData = this.sanitizer.bypassSecurityTrustResourceUrl(this.imageSrc);
        })
    }

    verifypasswordandsend(){
        if (this.password1===this.password2) {
this.AccountServ.Changepassword(this.password1).subscribe((response:string)=>{alert(response)})
        } else alert('password dont match')
    }
}
