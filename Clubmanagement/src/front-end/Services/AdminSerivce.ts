import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class AdminSerivce {

    constructor(private http:HttpClient) {
    }

}