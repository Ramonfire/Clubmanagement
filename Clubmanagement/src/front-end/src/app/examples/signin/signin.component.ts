import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthentificationService } from './auth.service';
import {LoginCredentials} from "../../../../Classes/LoginCredentials";
import {waitForAsync} from "@angular/core/testing";
@Component({
    selector: 'app-signin',
    templateUrl: './signin.component.html',
    styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {
    test : Date = new Date();
    focus;
    focus1;

    //authentification //

    errorMessage = 'Invalid Credentials';
    successMessage: string;
    invalidEmail = false;
    loginSuccess = false;
    formated =new FormData();
    loginCred = new LoginCredentials("","");


    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthentificationService) {   }

    ngOnInit() {
        this.isnight()
    }




    //handling the login
    handleLogin() {
        this.authenticationService.authenticationService(this.loginCred).subscribe((result)=> {
            this.invalidEmail = false;
            this.loginSuccess = true;
            this.successMessage = 'Login Successful.';
            this.router.navigate(['/landing']);
        }, () => {
            this.invalidEmail = true;
            this.loginSuccess = false;
            location.reload();
        });
    }


    //end of handling the login
    value:boolean;
    date=new Date();
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

}
