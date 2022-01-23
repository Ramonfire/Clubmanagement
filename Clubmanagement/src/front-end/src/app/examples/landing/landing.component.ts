import { Component, OnInit } from '@angular/core';
import {formatDate} from "@angular/common";
import {VisitorService} from "../../../../Services/VisitorService";
import {StudentService} from "../../../../Services/StudentService";
import {Evenement} from "../../../../Classes/evenement";
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";
import {AuthentificationService} from "../../../../Services/auth.service";
import {AccountService} from "../../../../Services/AccountService";
import {compte} from "../../../../Classes/compte";
import {role} from "../../../../Classes/role";

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

    public event : Evenement[]
    public mot :string;


    focus: any;
    focus1: any;
    value:boolean ;
    constructor(private  visitorService :VisitorService, private  authServie : AuthentificationService,private studentservice : StudentService,private accoutnServ:AccountService) {
        sessionStorage.setItem("pagenumadmin",""+0);
        sessionStorage.setItem("id",""+0);
        sessionStorage.setItem("pagenum",""+0);
    }

    ngOnInit() {
        sessionStorage.setItem("pagenum","0");
        this.slides = this.chunk(this.cards, 3);
        this.isnight();
        this.getevent();
        this.getmot();
        this.getRole();

    }


    public getevent() : void{
        if(!this.verifyauthen()) {
            this.visitorService.getPublicevent(0, 3).subscribe(
                (response: Evenement[]) => {
                    this.event = response;
                },
                (error: HttpErrorResponse) => {
                    console.log("no public events");
                }
            );
        }else {
            this.studentservice.getevent(0, 3).subscribe(
                (response: Evenement[]) => {
                    this.event = response;
                },
                (error: HttpErrorResponse) => {
                    console.log("no events");
                }
            );
        }
    }



    public getmot() : void{
        this.visitorService.getmotall().subscribe(
            (response :string) => {
                this.mot =response;},
            (error :HttpErrorResponse)=>{console.log(error.message);}

        );

    }







    
    Role:role;
    // works .error is cz of angualr logic
    public getRole(){
        if(this.verifyauthen()){
            this.accoutnServ.GetAccountInto().subscribe((response:compte)=>{
                this.Role=response.roles[0];
                sessionStorage.setItem("role",this.Role.name);
            })

        }
    }

public verifyauthen(): boolean{
        return this.authServie.isUserLoggedIn();
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

