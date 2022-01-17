import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { ComponentsComponent } from './components/components.component';
import { ProfileComponent } from './examples/profile/profile.component';
import { SigninComponent } from './examples/signin/signin.component';
import { AuthentificationService } from './examples/signin/auth.service';
import { SignupComponent } from './examples/signup/signup.component';
import { LandingComponent } from './examples/landing/landing.component';
import { EventComponent } from './examples/event/event.component';
import { ClubsComponent } from './examples/clubs/clubs.component';
import { NucleoiconsComponent } from './components/nucleoicons/nucleoicons.component';
import {ClubComponent} from "./examples/club/club.component";
import {AdminComponent} from "./examples/admin/admin.component";
import {EventsClubComponent} from "./examples/eventsclub/eventsclub.component";
import {CreateclubComponent} from "./examples/createclub/createclub.component";
import {ViewclubdemandComponent} from "./examples/viewclubdemand/viewclubdemand.component";
import {VieweventdemandComponent} from "./examples/vieweventdemand/vieweventdemand.component";

const routes: Routes =[
    { path: '', redirectTo: 'landing', pathMatch: 'full' },
    { path: 'home',             component: ComponentsComponent },
    { path: 'signin',           component: SigninComponent },
    { path: 'signup',           component: SignupComponent },
    { path: 'landing',          component: LandingComponent },
    { path: 'clubs',          component: ClubsComponent },
    { path: 'event',          component: EventComponent },
    { path: 'club',          component: ClubComponent },
    { path: 'profile',          component: ProfileComponent },
    { path: 'admin',          component: AdminComponent },
    { path: 'eventsclub',          component: EventsClubComponent },
    {path: 'createclub',          component: CreateclubComponent },
    {path: 'viewclubdemand',          component: ViewclubdemandComponent },
    {path: 'vieweventdemand',          component: VieweventdemandComponent },
    { path: 'nucleoicons',      component: NucleoiconsComponent }
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes,{
      useHash: true
    })
  ],
  exports: [
  ],
})
export class AppRoutingModule { }
