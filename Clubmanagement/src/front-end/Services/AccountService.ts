import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {compte} from "../Classes/compte";
import {Observable} from "rxjs";
import {environment} from "../src/environments/environment";
import {Evenement} from "../Classes/evenement";

@Injectable({
    providedIn: 'root'
})

export  class AccountService {
    private  apiBaseUrl = environment.apiBaseUrl;
    constructor(private http:HttpClient) {}

    public GetAccountInto():Observable<compte>{

        return this.http.get<compte>(`${this.apiBaseUrl}/info`);
    }


    Changepassword(password1: string) :Observable<string>{
        return this.http.get(`${this.apiBaseUrl}/changepassword/${password1}`,{responseType:"text"});
    }
}