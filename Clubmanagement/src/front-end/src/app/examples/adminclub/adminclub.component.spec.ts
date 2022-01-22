import { ComponentFixture, TestBed } from '@angular/core/testing';

import {AdminclubComponent} from './adminclub.component';

describe('AdminclubComponent', () => {
    let component: AdminclubComponent;
    let fixture: ComponentFixture<AdminclubComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [ AdminclubComponent ]
        })
            .compileComponents();
    });

    beforeEach(() => {
        fixture = TestBed.createComponent(AdminclubComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
