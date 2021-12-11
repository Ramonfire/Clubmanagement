import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {formatDate, getLocaleTimeFormat} from "@angular/common";

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
    test : Date = new Date();
    focus;
    focus1;
    //Declare an email to look for
    //httpCLient HttpClient
    constructor() { }
//.subscribe
    ngOnInit() {
        this.isnight()
       console.log("test");
    }
value:boolean;
    isnight() : boolean{
        var date=new Date();
        formatDate(date,"HH","fr");
        var currentHour:number=date.getHours();
        if (currentHour>=19 && currentHour<=23){
            this.value=true;

        }
        if (currentHour>=0 && currentHour<6){
            this.value=true;

        }

        if (currentHour<=12 && currentHour>=6) {
            this.value = false;

        }

        if (currentHour<19 && currentHour>=12) {
            this.value = false;

        }

        return this.value;
    }





}
