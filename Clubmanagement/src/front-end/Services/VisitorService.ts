import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import {Observable} from "rxjs";
@Injectable({
    providedIn: 'root'
})
export  class visitorService {





    constructor(private http: HttpClient) {
    }

//to review
     public getPublicevent(page:number,size :number) :Observable<any> {
        return this.http.get<any>(`http://localhost:8080/Clubpage/Visitor/publicevent/${page}/${size}`);
    }

    public geteventname(name :string) :Observable<any> {
        return this.http.get<any>(`http://localhost:8080/Clubpage/Visitor/events/${name}`);
    }


    public getAllclubs(page:number,size :number) :Observable<Club[]> {
        return this.http.get<Club[]>(`http://localhost:8080/Clubpage/allclubs/${page}/${size}`);
    }

    public getClubId(idc : number) :Observable<Club> {
        return this.http.get<Club>(`http://localhost:8080/Clubpage/Visitor/Club/${idc}`);
    }

    public getmotall() :Observable<string> {
        return this.http.get<string>(`http://localhost:8080/Clubpage/Visitor/mot`);
    }

    public singup(email :string) :Observable<string> {
        return this.http.put<string>(`http://localhost:8080/Clubpage/Visitor/signup/${email}`,null);
    }

}