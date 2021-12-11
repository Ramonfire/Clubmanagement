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

    ngOnInit() {
        this.isnight()
    }


    value:boolean;
    date=new Date();
    isnight() : boolean{
        var date=new Date();
        var currentHour:number=date.getHours();
        if (currentHour>=19 && currentHour<24){
            this.value=true;

        }
        if (currentHour>=0 && currentHour<6){
            this.value=true;

        }

        if (currentHour<12 && currentHour>6) {
            this.value = false;

        }

        if (currentHour<19 && currentHour>12) {
            this.value = false;

        }
        return this.value;
    }

}
