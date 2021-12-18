import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthentificationService } from './auth.service';
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
    email: string;
    password : string;
    errorMessage = 'Invalid Credentials';
    successMessage: string;
    invalidEmail = false;
    loginSuccess = false;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthentificationService) {   }

    ngOnInit() {
        this.isnight()
    }

    //handling the login
    handleLogin() {
        this.authenticationService.authenticationService(this.email, this.password).subscribe((result)=> {
            this.invalidEmail = false;
            this.loginSuccess = true;
            this.successMessage = 'Login Successful.';
            this.router.navigate(['/hello-world']);
        }, () => {
            this.invalidEmail = true;
            this.loginSuccess = false;
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
