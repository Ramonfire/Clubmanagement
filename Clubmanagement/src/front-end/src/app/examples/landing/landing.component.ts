import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-landing',
    templateUrl: './landing.component.html',
    styleUrls: ['./landing.component.scss']
})

export class LandingComponent implements OnInit {
  focus: any;
  focus1: any;

  constructor() { }

  ngOnInit() {}

    timeVerifyNight(){
      let date: Date = new Date();
      var currentHour=date.getHours();
      if (currentHour>=19 && currentHour<6){
        return true;
      }
      else {
          return false;
      }
    }

    timeVerifyDay(){
      let date: Date = new Date();
      var currentHour=date.getHours();
      if (currentHour>=6 && currentHour<19){
        return true;
      }
      else {
          return false;
      }
    }

}
