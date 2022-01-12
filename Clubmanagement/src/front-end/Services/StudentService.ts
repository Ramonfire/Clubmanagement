import {environment} from "../src/environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Evenement} from "../Classes/evenement";
import {Club} from "../Classes/Club";
import {Injectable} from "@angular/core";
import {Session} from "../Classes/Session";
import {Members} from "../Classes/Members";

@Injectable({
    providedIn: 'root'
})
export class StudentService {
    private  apiBaseUrl = environment.apiBaseUrl;
    constructor(private http: HttpClient) {
    }

    public formated = new FormData();




//to review
    public getevent(page:number,size :number) :Observable<Evenement[]> {


        return this.http.get<Evenement[]>(`${this.apiBaseUrl}/student/plannedevents/${page}/${size}`);
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
//not working to be reviewed
    public JoinClub(member:Members): Observable<string>{
        return this.http.post(`${this.apiBaseUrl}/student/joinClub`,{idmember:member.idmember,clubid:member.clubid,studentid:member.studentid,role:member.role},{responseType : 'text'});
    }
    public verifyMembership(idc:number):Observable<boolean>{
        return  this.http.get<boolean>(`${this.apiBaseUrl}/student/Verify/${idc}`);
    }

/*
    public makeDemande(Demande : any) :Observable<string> {
        return this.http.post(`${this.apiBaseUrl}/student/newDemande`,Demande);

    }
*/
}