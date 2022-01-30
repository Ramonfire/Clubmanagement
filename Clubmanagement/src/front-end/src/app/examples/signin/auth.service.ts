import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import {LoginCredentials} from "../../../../Classes/LoginCredentials";
import {Observable} from "rxjs";
import {Session} from "../../../../Classes/Session";
import {Router} from "@angular/router";
@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {

  // BASE_PATH: 'http://localhost:8080'
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

  public email: String;
  public password: String;
  public formated = new FormData();

  constructor(private http: HttpClient,private router:Router) {

  }
//to review
authenticationService(login:LoginCredentials) {
    this.formated.append("email",login.email);
    this.formated.append("password",login.password);

    return this.http.post(`http://localhost:8080/Clubpage/login`, this.formated).pipe(map((res :Session  ) => {
      this.registerSuccessfulLogin(res);
    }));
  }


  registerSuccessfulLogin(email:Session) {
    alert("Login Succesfull");
    sessionStorage.setItem("acces_token", "Bearer "+email.acces_token.toString());
    sessionStorage.setItem("refresh_token", "Bearer "+email.refresh_token.toString());
    this.formated.delete("email");
    this.formated.delete("password");
  }

  logout() {
    alert("Logging out!");
    sessionStorage.removeItem("acces_token");
    sessionStorage.removeItem("refresh_token");

    this.email = null;
    this.password = null;
    this.router.navigate(['/signin']);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem("acces_token")
    if (user === null) return false
    else return true
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem("acces_token")
    if (user === null) return ''
    return user
  }


}
