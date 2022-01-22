import {Component, OnInit} from "@angular/core";
import {Club} from "../../../../Classes/Club";
import {HttpErrorResponse} from "@angular/common/http";
import {ImageModel} from "../../../../Classes/ImageModel";
import {StudentService} from "../../../../Services/StudentService";
import {AuthentificationService} from "../signin/auth.service";
import {Router} from "@angular/router";
import {ImageService} from "../../../../Services/ImageService";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";
import {VisitorService} from "../../../../Services/VisitorService";

@Component({
    selector: 'app-clubs',
    templateUrl: './adminclub.component.html'
})

export class AdminclubComponent implements OnInit {



    ngOnInit() {
    }
club:Club;
    imageSrc:string;
    srcData:SafeResourceUrl;

    constructor(private visitorService:VisitorService,private authentifserv :AuthentificationService,
                private router:Router,
                private imgServ:ImageService,
                private sanitizer: DomSanitizer) {
    }

    async getClub(){
        console.log(sessionStorage.getItem("id"));
        if (sessionStorage.getItem("id")==null){
            alert("redirecting to all clubs page");
            this.router.navigate(["/clubs"])
        }else {
            this.visitorService.getClubId(parseInt(sessionStorage.getItem("id"))).subscribe(
                (response: Club) => {
                    this.club = response;
                    this.getimage();

                }, (error: HttpErrorResponse) => {
                    alert("error while finding the club");
                }
            );
        }
    }


    getimage(){
        this.imgServ.getImage(""+this.club.nomclub).subscribe((response:ImageModel)=>{
            console.log(response.picByte)
            this.imageSrc = 'data:image/'+response.type+';base64,' + response.picByte;
            this.srcData = this.sanitizer.bypassSecurityTrustResourceUrl(this.imageSrc);
        })
    }

}