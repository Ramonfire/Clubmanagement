import {environment} from "../src/environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Evenement} from "../Classes/evenement";
import {Club} from "../Classes/Club";
import {Injectable} from "@angular/core";
import {Session} from "../Classes/Session";
import * as stream from "stream";

@Injectable({
    providedIn: 'root'
})
export class StudentService {
    private  apiBaseUrl = environment.apiBaseUrl;
    constructor(private http: HttpClient) {
    }



    session = new Session();




//to review
    public getevent(page:number,size :number) :Observable<Evenement[]> {
        this.session.acces_token=sessionStorage.getItem("acces_token");
        let header =new HttpHeaders();
        header = header.set("Authorization",this.session.acces_token.toString());
        console.log(header);
        console.log(header.get("Authorization"));

        return this.http.get<Evenement[]>(`${this.apiBaseUrl}/student/plannedevents/${page}/${size}`,{headers:header});
    }

    public geteventname(name :string) :Observable<Evenement> {
        return this.http.get<Evenement>(`${this.apiBaseUrl}/student/events/${name}`);
    }


    public getAllclubs(page:number,size :number) :Observable<Club[]> {
        return this.http.get<Club[]>(`${this.apiBaseUrl}/student/allclubs/${page}/${size}`);
    }
    public Myclubs(page:number,size :number) :Observable<Club[]> {
        return this.http.get<Club[]>(`${this.apiBaseUrl}/student/Myclubs/${page}/${size}`);
    }

    public getClubId(idc : number) :Observable<Club> {
        return this.http.get<Club>(`${this.apiBaseUrl}/student/Club/${idc}`);
    }

    public getmotall() :Observable<string> {
        return this.http.get(`${this.apiBaseUrl}/student/mot`,{responseType : 'text'});

    }

    public AccountType() :Observable<string> {
        return this.http.get(`${this.apiBaseUrl}/student/AccountType`,{responseType : 'text'});

    }
    public ViewDemande():Observable<any>{
        return null;
    }
/*
    public makeDemande(Demande : any) :Observable<string> {
        return this.http.post(`${this.apiBaseUrl}/student/newDemande`,Demande);

    }
*/
}