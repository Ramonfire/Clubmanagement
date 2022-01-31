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
import {resolve} from "@angular/compiler-cli/src/ngtsc/file_system";
import {compte} from "../../../../Classes/compte";

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

    constructor(private visitorService:VisitorService,
                private authentifserv :AuthentificationService,
                private  studentService:StudentService,
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
                    this.getMembers();
                    this.getPedags();
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
    public onFileChanged(event) {
        //Select File
        this.SelectedFile = event.target.files[0];
    }

SelectedFile:File;
    OnImageUplaod(){
    this.imgServ.onUpload(this.SelectedFile,this.club.nomclub).subscribe((response:string)=>{
        console.log(response);
        location.reload();
    },(error:HttpErrorResponse)=>{ alert(error.status)})
    }

//remove member from club
    deletemember(email:string) {
        this.memberService.DeleteMember(email,parseInt(sessionStorage.getItem("id"))).subscribe((response:string)=>{
            alert(response);
            location.reload();
        })

    }

    email: string;
    role: string;
    budget: any;
    message1:string;
    verify1:boolean=false;

    addComite() {
        if (this.email==null||this.role==null){
            this.verify1=true;
           this.message1="invalid credentials";
        }else {
            if (sessionStorage.getItem("role")==="Role_Admin"){
this.adminService.AddComiteMember(parseInt(sessionStorage.getItem("id")),this.role,this.email).subscribe((response:string)=>{
alert(response);
    location.reload()
},(error:HttpErrorResponse)=>{alert(error.status)});
            }else {
                this.memberService.AddComiteMember(parseInt(sessionStorage.getItem("id")),this.role,this.email).subscribe((response:string)=>{
                    alert(response);
                    location.reload()
                },(error:HttpErrorResponse)=>{alert(error.status)});

            }
        }
    }

    verifyUser(){
        if (sessionStorage.getItem("role")==="Role_Admin") return true; else return false;
    }

verify:boolean=false;
    message:string;
    addnewBudget() {
        if (this.budget==null){
            this.verify=true;
            this.message="insert a budget before confirming"
        }else {
        this.adminService.addnewBudget(this.club.idc,this.budget).subscribe((response:string)=>{
            alert(response);
            location.reload();
        });
        }
    }

pedag:compte[];

    getPedags(){
        this.studentService.getpedag().subscribe((response:compte[])=>{
            this.pedag=response;
            console.log(this.pedag)
        })
    }
    idpedag: number;
    changePedag() {
        this.memberService.ChangePedag(this.idpedag,this.club.idc).subscribe((response:string)=>{
            alert(response)
        })
    }
}

