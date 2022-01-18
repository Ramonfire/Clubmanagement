import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../src/environments/environment";
import {Observable} from "rxjs";
import {Evenement} from "../Classes/evenement";
import {Demande} from "../Classes/demande";

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


    public UpdateMot(Mot:string){
        return this.http.post(`${this.apiBaseUrl}/admin/updatemot`,{mot:Mot},{responseType:"text"});
    }

    public getDemande(state:number):Observable<Demande[]>{
    return this.http.get<Demande[]>(`${this.apiBaseUrl}/admin/demandeclub/${state}`)
    }

    public AcceptDemande(demand:Demande):Observable<string>{
    return   this.http.post(`${this.apiBaseUrl}/admin/accepterDemande`,demand,{responseType:"text"});
    }

    public RefusedDemande(demand:Demande):Observable<string>{
        return   this.http.post(`${this.apiBaseUrl}/admin/refuserDemande`,demand,{responseType:"text"});
    }

}