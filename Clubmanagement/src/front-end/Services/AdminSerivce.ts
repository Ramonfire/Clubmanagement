import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../src/environments/environment";
import {Observable} from "rxjs";
import {Evenement} from "../Classes/evenement";

@Injectable({
    providedIn: 'root'
})
export class AdminSerivce {
    private  apiBaseUrl = environment.apiBaseUrl;
    constructor(private http:HttpClient) {
    }

public  GetCountEventsByState(state:number):Observable<number>{
        return this.http.get<number>(`${this.apiBaseUrl}/admin/Countevents/${state}`);
}

public  GetCountDemandeByState(state:number):Observable<number>{
    return this.http.get<number>(`${this.apiBaseUrl}/admin/demandeCount/${state}`);
}

    public  GetCountClubs():Observable<number>{
        return this.http.get<number>(`${this.apiBaseUrl}/admin/ClubCount`);
    }

}