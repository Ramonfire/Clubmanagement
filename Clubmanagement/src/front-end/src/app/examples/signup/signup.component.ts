import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

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
    ngOnInit() {}
value:boolean;
    isnight() : boolean{
        var date=new Date();
        var currentHour:number=date.getHours();
        if (currentHour>=19 && currentHour<24){
            this.value=false;

        }
        if (currentHour>=0 && currentHour<6){
            this.value=false;

        }

        if (currentHour<12 && currentHour>6) {
            this.value = true;

        }

        if (currentHour<19 && currentHour>12) {
            this.value = true;

        }
        return this.value;
    }





}
