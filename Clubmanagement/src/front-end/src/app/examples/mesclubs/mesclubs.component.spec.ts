import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MesClubsComponent } from './mesclubs.component';

describe('ClubsComponent', () => {
  let component: MesClubsComponent;
  let fixture: ComponentFixture<MesClubsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MesClubsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MesClubsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
