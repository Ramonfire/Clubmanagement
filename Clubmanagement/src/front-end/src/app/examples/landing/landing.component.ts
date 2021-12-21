import { Component, OnInit } from '@angular/core';
import {formatDate} from "@angular/common";
import {VisitorService} from "../../../../Services/VisitorService";
import {Evenement} from "../../../../Classes/evenement";
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";

@Component({
    selector: 'app-landing',
    templateUrl: './landing.component.html',
    styleUrls: ['./landing.component.scss']
})

export class LandingComponent implements OnInit {

    cards = [
        {
            title: 'Card Title 1',
            description: 'This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.',
            buttonText: 'Button',
            img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
        },
        {
            title: 'Card Title 2',
            description: 'This card has supporting text below as a natural lead-in to additional content.',
            buttonText: 'Button',
            img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
        },
        {
            title: 'Card Title 3',
            description: 'This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action. This text is much longer so that you can see a significant difference between the text in  previous tabs.',
            buttonText: 'Button',
            img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
        },
        {
            title: 'Card Title 4',
            description: 'Some quick example text to build on the card title and make up the bulk of the card content',
            buttonText: 'Button',
            img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
        },
        {
            title: 'Card Title 5',
            description: 'Some quick example text to build on the card title and make up the bulk of the card content',
            buttonText: 'Button',
            img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
        },
        {
            title: 'Card Title 6',
            description: 'Some quick example text to build on the card title and make up the bulk of the card content',
            buttonText: 'Button',
            img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
        }
    ];
    slides: any = [[]];
    chunk(arr: any, chunkSize:any) {
        let R = [];
        for (let i = 0, len = arr.length; i < len; i += chunkSize) {
            R.push(arr.slice(i, i + chunkSize));
        }
        return R;
    }

    public event : Evenement[];

    focus: any;
    focus1: any;
    value:boolean ;
    constructor(private  visitorService :VisitorService) { }

    ngOnInit() {
        this.slides = this.chunk(this.cards, 3);
        this.isnight();
        this.getpublicevent();
    }


    public getpublicevent() : void{
        this.visitorService.getPublicevent(0,3).subscribe(
            (response :Evenement[]) => {
                                            this.event =response;
                                            console.log(this.event);},
            (error :HttpErrorResponse)=>{console.log("no public events");}

        );

    }













    date=new Date();
    isnight() : boolean{
        var date=new Date();
        formatDate(date,"HH","en-GB");
        var currentHour:number=date.getHours();
        if (currentHour>=19 && currentHour<24){
            this.value=true;

        }
            if (currentHour>=0 && currentHour<6){
            this.value=true;

        }

        if (currentHour<12 && currentHour>=6) {
            this.value = false;

        }

        if (currentHour<19 && currentHour>=12) {
            this.value = false;

        }
        console.log(currentHour,this.value)
        return this.value;
    }



}
