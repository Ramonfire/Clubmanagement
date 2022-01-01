import { Component, OnInit } from '@angular/core';
import {StudentService} from "../../../../Services/StudentService";
import {Club} from "../../../../Classes/Club";
import {Evenement} from "../../../../Classes/evenement";
import {HttpErrorResponse} from "@angular/common/http";
import {VisitorService} from "../../../../Services/VisitorService";

@Component({
  selector: 'app-clubs',
  templateUrl: './clubs.component.html',
  styleUrls: ['./clubs.component.scss']
})
export class ClubsComponent implements OnInit {

  clubs:Club[];

  constructor(private visservice:VisitorService) { }

  ngOnInit(): void {
    this.getClubs();
  }

getClubs(){
    this.visservice.getAllclubs(0,10).subscribe(
        (response: Club[]) => {
          this.clubs = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
    );
}

}
