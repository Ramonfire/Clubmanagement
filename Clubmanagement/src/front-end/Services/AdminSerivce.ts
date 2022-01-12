import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../src/environments/environment";

@Injectable({
    providedIn: 'root'
})
export class AdminSerivce {
    private  apiBaseUrl = environment.apiBaseUrl;
    constructor(private http:HttpClient) {
    }

}