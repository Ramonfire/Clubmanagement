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



     header =new HttpHeaders();
    session = new Session();




//to review
    public getevent(page:number,size :number) :Observable<Evenement[]> {

        this.session.acces_token=sessionStorage.getItem("acces_token");
        this.header.append("acces_token",this.session.acces_token.toString())

        return this.http.get<Evenement[]>(`${this.apiBaseUrl}/student/plannedevents/${page}/${size}`,{headers:this.header});
    }

    public geteventname(name :string) :Observable<Evenement> {

        this.session.acces_token=sessionStorage.getItem("acces_token");
        this.header.append("acces_token",this.session.acces_token.toString())
        return this.http.get<Evenement>(`${this.apiBaseUrl}/student/events/${name}`,{headers:this.header});
    }


    public getAllclubs(page:number,size :number) :Observable<Club[]> {

        this.session.acces_token=sessionStorage.getItem("acces_token");
        this.header.append("acces_token",this.session.acces_token.toString());
        return this.http.get<Club[]>(`${this.apiBaseUrl}/student/allclubs/${page}/${size}`,{headers:this.header});
    }
    public Myclubs(page:number,size :number) :Observable<Club[]> {

        this.session.acces_token=sessionStorage.getItem("acces_token");
        this.header.append("acces_token",this.session.acces_token.toString());
        return this.http.get<Club[]>(`${this.apiBaseUrl}/student/Myclubs/${page}/${size}`,{headers:this.header});
    }

    public getClubId(idc : number) :Observable<Club> {

        this.session.acces_token=sessionStorage.getItem("acces_token");
        this.header.append("acces_token",this.session.acces_token.toString());
        return this.http.get<Club>(`${this.apiBaseUrl}/student/Club/${idc}`,{headers:this.header});
    }

    public getmotall() :Observable<string> {

        this.session.acces_token=sessionStorage.getItem("acces_token");
        this.header.append("acces_token",this.session.acces_token.toString());
        return this.http.get(`${this.apiBaseUrl}/student/mot`,{responseType : 'text',headers:this.header});

    }

    public AccountType() :Observable<string> {

        this.session.acces_token=sessionStorage.getItem("acces_token");
        this.header.append("acces_token",this.session.acces_token.toString());
        return this.http.get(`${this.apiBaseUrl}/student/AccountType`,{responseType : 'text',headers:this.header});

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