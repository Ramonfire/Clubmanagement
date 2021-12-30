import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { LandingComponent } from './landing/landing.component';
import { ProfileComponent } from './profile/profile.component';
import { SigninComponent } from './signin/signin.component';
import {SignupComponent} from "./signup/signup.component";
import {EventComponent} from "./event/event.component";
import {RouterModule} from "@angular/router";
import { ClubsComponent } from './clubs/clubs.component';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        NgbModule,
        RouterModule,
    ],
    declarations: [
        LandingComponent,
        SigninComponent,
        SignupComponent,
        ProfileComponent,
        EventComponent,
        ClubsComponent
    ]
})
export class ExamplesModule { }
