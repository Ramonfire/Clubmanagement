import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import {LoginCredentials} from "../Classes/LoginCredentials";
@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {

  // BASE_PATH: 'http://localhost:8080'
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

  public email: String;
  public password: String;
  public formated = new FormData();

  constructor(private http: HttpClient) {

  }
//to review
authenticationService(login:LoginCredentials) {
    this.formated.append("email",login.email);
    this.formated.append("password",login.password);

    return this.http.post(`http://localhost:8080/Clubpage/login`, this.formated).pipe(map((res :"response"  ) => {
      this.email = login.email;
      this.password = login.password;
      this.registerSuccessfulLogin(JSON.stringify(res));
    }));
  }

  createBasicAuthToken(email: String, password: String) {
    return 'Basic ' + window.btoa(email + ":" + password)
  }

  registerSuccessfulLogin(email) {
    alert("Login Succesfull");
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, email);
  }

  logout() {
    alert("Logging out!");
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    this.email = null;
    this.password = null;
    this.formated.delete("email");
    this.formated.delete("password");
    window.location.reload();
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    else return true
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }


}
