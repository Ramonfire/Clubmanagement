import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import {Observable} from "rxjs";
import {environment} from "../src/environments/environment";
import {Evenement} from "../Classes/evenement";
import {Club} from "../Classes/Club";
@Injectable({
    providedIn: 'root'
})
export  class VisitorService {

private  apiBaseUrl = environment.apiBaseUrl;



    constructor(private http: HttpClient) {
    }

//to review
     public getPublicevent(page:number,size :number) :Observable<Evenement[]> {
        return this.http.get<Evenement[]>(`${this.apiBaseUrl}/Visitor/publicevent/${page}/${size}`);
    }

    public geteventname(name :string) :Observable<Evenement> {
        return this.http.get<Evenement>(`${this.apiBaseUrl}/Visitor/events/${name}`);
    }


    public getAllclubs(page:number,size :number) :Observable<Club[]> {
        return this.http.get<Club[]>(`${this.apiBaseUrl}/Visitor/allclubs/${page}/${size}`);
    }

    public getClubId(idc : number) :Observable<Club> {
        return this.http.get<Club>(`${this.apiBaseUrl}/Visitor/Club/${idc}`);
    }

    public getmotall() :Observable<string> {
        return this.http.get<string>(`${this.apiBaseUrl}/Visitor/mot`);
    }

    public singup(email :string) :Observable<string> {
        return this.http.put<string>(`${this.apiBaseUrl}/Visitor/signup/${email}`,null);
    }

}