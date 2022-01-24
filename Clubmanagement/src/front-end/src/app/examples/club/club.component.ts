import {Component, OnInit} from "@angular/core";
import {VisitorService} from "../../../../Services/VisitorService";
import {StudentService} from "../../../../Services/StudentService";
import {Router} from "@angular/router";
import {Club} from "../../../../Classes/Club";
import {HttpErrorResponse} from "@angular/common/http";
import {AuthentificationService} from "../signin/auth.service";
import {Members} from "../../../../Classes/Members";
import {ImageService} from "../../../../Services/ImageService";
import {ImageModel} from "../../../../Classes/ImageModel";
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import {waitForAsync} from "@angular/core/testing";
import {MemberService} from "../../../../Services/MemberService";


@Component({
    selector: 'app-clubs',
    templateUrl: './club.component.html'
})

export class ClubComponent implements OnInit {

    club:Club;

    ngOnInit(): void {

        this.getClub();
        sessionStorage.setItem("pagenumadmin",""+0);
    }
constructor(private VisitorService:VisitorService
            ,private studenService:StudentService,private authentifserv :AuthentificationService,
            private router:Router,
            private imgServ:ImageService,
            private sanitizer: DomSanitizer,
            private memberService:MemberService) {}



   async getClub(){
        console.log(sessionStorage.getItem("id"));
        if (sessionStorage.getItem("id")==null){
            alert("redirecting to all clubs page");
            this.router.navigate(["/clubs"])
        }else {
            this.VisitorService.getClubId(parseInt(sessionStorage.getItem("id"))).subscribe(
                (response: Club) => {
                    this.club = response;
                    this.getimage();
                    this.getMember();

                }, (error: HttpErrorResponse) => {
                    alert("error while finding the club");
                }
            );
        }
    }

// not working to be reviwed
    rejoindreClub() {
        let integer = this.club.idc;
        let member= new Members(integer,0,"member");
        this.studenService.JoinClub(member).subscribe((response:string)=>{
            alert(response);
            location.reload();

            }, (error:HttpErrorResponse)=>{alert(error.error.code)});
    }



    //getting member
    member:Members;
    getMember(){
        if (this.authentifserv.isUserLoggedIn()){
        this.memberService.getMemberByClub(this.club.idc).subscribe((response:Members)=>{
            this.member=response;
            console.log(response)
            console.log(this.member.role);

        },(error:HttpErrorResponse)=>{alert(error.error)})}
    }

    verifyMemberComite(){
        if (this.authentifserv.isUserLoggedIn()){
            if (sessionStorage.getItem("role")==="Role_Admin"){return true}else {
            let x:string=this.member.role;
        if (x==="member" || x===null){
            return false;
        }else return true;}}else return false;
    }




//sending to admin panel of the club
    redirectClubAdminpage() {
        this.router.navigate(["/adminclub"])
    }




    verifyUser(){
        if (this.authentifserv.isUserLoggedIn()){
            if (sessionStorage.getItem("role")=="Role_Admin"){return false;}
            else return true
        }else return false
    }



imageSrc:string;
    srcData : SafeResourceUrl;
    testing:string;




    getimage(){
          this.imgServ.getImage(""+this.club.nomclub).subscribe((response:ImageModel)=>{
this.testing=''+response;
            this.imageSrc = 'data:image/'+response.type+';base64,' + response.picByte;
            this.srcData = this.sanitizer.bypassSecurityTrustResourceUrl(this.imageSrc);
        })
    }

}
