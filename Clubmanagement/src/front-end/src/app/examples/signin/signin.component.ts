import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-signin',
    templateUrl: './signin.component.html',
    styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {
    test : Date = new Date();
    focus;
    focus1;
    constructor() { }

    ngOnInit() {}

    isnight() : boolean{
        var date= new Date();
        var currentHour=date.getHours();
        if (currentHour<6 && currentHour>=19){
            return true;
        }
        else if(currentHour>6 && currentHour<19) {
            return false;
        }
    }

}
