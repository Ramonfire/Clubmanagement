import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularMaterialCardsClubsComponent } from './angular-material-cards-clubs.component';

describe('AngularMaterialCardsClubsComponent', () => {
  let component: AngularMaterialCardsClubsComponent;
  let fixture: ComponentFixture<AngularMaterialCardsClubsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AngularMaterialCardsClubsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularMaterialCardsClubsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
