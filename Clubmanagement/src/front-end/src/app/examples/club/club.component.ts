import {Component, OnInit} from "@angular/core";
import {VisitorService} from "../../../../Services/VisitorService";
import {StudentService} from "../../../../Services/StudentService";
import {Router} from "@angular/router";
import {Club} from "../../../../Classes/Club";
import {HttpErrorResponse} from "@angular/common/http";
import {AuthentificationService} from "../signin/auth.service";
import {Members} from "../../../../Classes/Members";

@Component({
    selector: 'app-clubs',
    templateUrl: './club.component.html'
})

export class ClubComponent implements OnInit {

    club:Club;

    ngOnInit(): void {

        this.getClub();
    }
constructor(private VisitorService:VisitorService
            ,private studenService:StudentService,private authentifserv :AuthentificationService,
            private router:Router) {}



    getClub(){
        console.log(sessionStorage.getItem("id"));
        if (sessionStorage.getItem("id")==null){
            alert("redirecting to all clubs page");
            this.router.navigate(["/clubs"])
        }else {
            this.VisitorService.getClubId(parseInt(sessionStorage.getItem("id"))).subscribe(
                (response: Club) => {
                    this.club = response;

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

//sending to admin panel of the club
    redirectClubAdminpage() {
        this.router.navigate(["/clubs"])
    }
}
