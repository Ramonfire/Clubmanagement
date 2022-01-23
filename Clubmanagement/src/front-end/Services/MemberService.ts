import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {environment} from "../src/environments/environment";
import {Observable} from "rxjs";
import {Members} from "../Classes/Members";
import {StudentMember} from "../Classes/StudentMember";

@Injectable({
    providedIn: 'root'
})
export class MemberService {
    private  apiBaseUrl = environment.apiBaseUrl;
    constructor( private http:HttpClient) {
    }



    public getMemberByClub(id:number):Observable<Members>{
      return   this.http.get<Members>(`${this.apiBaseUrl}/member/GetPersonalInfo/${id}`);

    }

    getMembersByClubid(number: number,page:number,size:number):Observable<StudentMember[]> {
        return this.http.get<StudentMember[]>(`${this.apiBaseUrl}/member/GetClubMembers/${number}/${page}/${size}`)
    }
}