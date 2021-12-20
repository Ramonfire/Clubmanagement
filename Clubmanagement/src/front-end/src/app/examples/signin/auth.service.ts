import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import {LoginCredentials} from "../../../../Classes/LoginCredentials";
import {Observable} from "rxjs";
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
  authenticationService(login:LoginCredentials) :Observable<any> {
    this.formated.append("email",login.email);
    this.formated.append("password",login.password);

    return this.http.post<any>(`http://localhost:8080/Clubpage/login`, this.formated).pipe(map((res) => {
      this.email = login.email;
      this.password = login.password;
      this.registerSuccessfulLogin(login.email, login.password);
    }));
  }

  createBasicAuthToken(email: String, password: String) {
    return 'Basic ' + window.btoa(email + ":" + password)
  }

  registerSuccessfulLogin(email, password) {
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, email)
  }

  logout() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    this.email = null;
    this.password = null;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }


}