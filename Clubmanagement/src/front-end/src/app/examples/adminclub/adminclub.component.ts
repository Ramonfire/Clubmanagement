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
import {Members} from "../../../../Classes/Members";
import {MemberService} from "../../../../Services/MemberService";
import {StudentMember} from "../../../../Classes/StudentMember";
import {AdminSerivce} from "../../../../Services/AdminSerivce";

@Component({
    selector: 'app-clubs',
    templateUrl: './adminclub.component.html'
})

export class AdminclubComponent implements OnInit {



    ngOnInit() {
        this.getClub()
        console.log(sessionStorage.getItem("pagenumadmin"))
    }
club:Club;
    imageSrc:string;
    srcData:SafeResourceUrl;

    constructor(private visitorService:VisitorService,private authentifserv :AuthentificationService,
                private router:Router,
                private imgServ:ImageService,
                private sanitizer: DomSanitizer,
                private memberService:MemberService,
                private adminService:AdminSerivce) {
    }

    async getClub(){
        if (sessionStorage.getItem("id")==null){
            alert("redirecting to all clubs page");
            this.router.navigate(["/clubs"])
        }else {
            console.log(sessionStorage.getItem("id"))
            this.visitorService.getClubId(parseInt(sessionStorage.getItem("id"))).subscribe(
                (response: Club) => {
                    this.club = response;
                    this.getimage();
                    this.getMembers()
                    console.log(this.test)

                }, (error: HttpErrorResponse) => {
                    alert("error while finding the club");
                }
            );
        }
    }

test:boolean=false;
    getimage(){
        this.imgServ.getImage(""+this.club.nomclub).subscribe((response:ImageModel)=>{
            if (response.picByte==null) this.test=false; else this.test=true;
            this.imageSrc = 'data:image/'+response.type+';base64,' + response.picByte;
            this.srcData = this.sanitizer.bypassSecurityTrustResourceUrl(this.imageSrc);
        })
    }

    //getting members with their ids and roles
    members:StudentMember[];
    getMembers(){
        this.memberService.getMembersByClubid(parseInt(sessionStorage.getItem("id")),parseInt(sessionStorage.getItem("pagenumadmin")),100)
            .subscribe((response:StudentMember[])=>{
                this.members=response;
        },(error:HttpErrorResponse)=>{alert(error.error)})

}


//image upload

SelectedFile:File;
    OnImageUplaod(){
    this.imgServ.onUpload(this.SelectedFile,this.club.nomclub).subscribe((response:string)=>{
        console.log(response);
        location.reload();
    },(error:HttpErrorResponse)=>{ alert(error.status)})
    }

//remove member from club
    deletemember() {

    }

    email: string;
    role: string;

    addComite() {
        if (this.email==null){
            alert("insert an email");
        }if (this.role==null){
            alert("choose a role")
        }else {
            if (sessionStorage.getItem("role")==="Role_Admin"){
this.adminService.AddComiteMember(parseInt(sessionStorage.getItem("id")),this.role,this.email).subscribe((response:string)=>{
alert(response);
},(error:HttpErrorResponse)=>{alert(error.status)});
            }else {
                this.memberService.AddComiteMember(parseInt(sessionStorage.getItem("id")),this.role,this.email).subscribe((response:string)=>{
                    alert(response);
                },(error:HttpErrorResponse)=>{alert(error.status)});

            }
        }
    }

    verifyUser(){
        if (sessionStorage.getItem("role")==="Role_Admin") return true; else return false;
    }



}