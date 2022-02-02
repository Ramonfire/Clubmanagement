import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClubComponent } from './club.component';
import {CreateReunionComponent} from "../createreunion/createclub.component";

describe('CreateReunionComponent', () => {
    let component:CreateReunionComponent;
    let fixture: ComponentFixture<CreateReunionComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [ CreateReunionComponent ]
        })
            .compileComponents();
    });

    beforeEach(() => {
        fixture = TestBed.createComponent(CreateReunionComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
