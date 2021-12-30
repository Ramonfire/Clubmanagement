import { Component, OnInit } from '@angular/core';
//import {HttpClient} from "@angular/common/http";
import {formatDate, getLocaleTimeFormat} from "@angular/common";
import {VisitorService} from "../../../../Services/VisitorService";
import {Observable} from "rxjs";
import {Evenement} from "../../../../Classes/evenement";
import {HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
    test : Date = new Date();
    focus;
    focus1;
    private router :Router;
    //Declare an email to look for
    //httpCLient HttpClient
    constructor(private visitorService:VisitorService) { }
//.subscribe
    ngOnInit() {

        this.isnight()
     
    }
value:boolean;

    isnight() : boolean{
        var date=new Date();
        var currentHour:number=date.getHours();
        if (currentHour>=19 && currentHour<24){
            this.value=true;

        }
        if (currentHour>=0 && currentHour<6){
            this.value=true;

        }

        if (currentHour<12 && currentHour>6) {
            this.value = false;

        }

        if (currentHour<19 && currentHour>12) {
            this.value = false;

        }
        return this.value;
    }
    emailsignup: string;
    successMessage:string;
    fail:string;
    singup(){
       this.visitorService.singup(this.emailsignup).subscribe(
            (response: string) => {
                alert(response.toString());
                this.router.navigate(['/landing']);
            },
            (error: HttpErrorResponse) => {
                alert(error.error.code);
            }
        );
    }



}
