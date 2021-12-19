import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
@Injectable({
    providedIn: 'root'
})
export  class  eventService {





    constructor(private http: HttpClient) {

    }


    getPublicevent() {
        return this.http.get(`http://localhost:8080/Clubpage/Visitor/publicevent/0/3`);
    }


}