import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../src/environments/environment";
import {Observable} from "rxjs";
import {Evenement} from "../Classes/evenement";
import {Demande} from "../Classes/demande";
import {Club} from "../Classes/Club";

@Injectable({
    providedIn: 'root'
})
export class AdminSerivce {
    private  apiBaseUrl = environment.apiBaseUrl;
    constructor(private http:HttpClient) {
    }

    public getAllclubs(page:number,size :number) :Observable<Club[]> {
        return this.http.get<Club[]>(`${this.apiBaseUrl}/admin/allclubs/${page}/${size}`);
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

    public getDemande(state:number,page:number,size:number):Observable<Demande[]>{
    return this.http.get<Demande[]>(`${this.apiBaseUrl}/admin/demandeclub/${state}/${page}/${size}`)
    }

    public AcceptDemande(demand:Demande):Observable<string>{
    return   this.http.post(`${this.apiBaseUrl}/admin/accepterDemande`,demand,{responseType:"text"});
    }

    public RefusedDemande(demand:Demande):Observable<string>{
        return   this.http.post(`${this.apiBaseUrl}/admin/refuserDemande`,demand,{responseType:"text"});
    }


    public  GetWaitingEvents(page:number,size:number):Observable<Evenement[]>{
        return this.http.get<Evenement[]>(`${this.apiBaseUrl}/admin/Waitingevents/${page}/${size}`);
    }
    public Acceptevent(id:number):Observable<string>{
        return   this.http.get(`${this.apiBaseUrl}/admin/Acecpterevent/${id}`,{responseType:"text"});
    }
    public RefuserEvent(id:number):Observable<string>{
        return   this.http.get(`${this.apiBaseUrl}/admin/Refuserevent/${id}`,{responseType:"text"});
    }

    public AddComiteMember(id:number,role:string,email:string):Observable<string>{
        return this.http.post(`${this.apiBaseUrl}/admin/saveComite/${id}`,{email:email,role:role},{responseType:"text"})
    }




    public  ChangeClubState(state:boolean,id:number):Observable<string>{
        return this.http.get(`${this.apiBaseUrl}/admin/ChangeClubstate/${state}/${id}`,{responseType:"text"});
    }
//not done yet
    public addnewBudget(id:number,budget:number):Observable<string>{
        return this.http.get(`${this.apiBaseUrl}/admin/newBudget/${id}/${budget}`,{responseType:"text"});
    }

    Changeeventterminer(ide:number) :Observable<string>{
        return this.http.get(`${this.apiBaseUrl}/admin/changeterminer/${ide}`,{responseType:"text"});
    }
}