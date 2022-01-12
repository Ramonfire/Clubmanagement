import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventsClubComponent } from './eventsclub.component';

describe('ClubsComponent', () => {
  let component: EventsClubComponent;
  let fixture: ComponentFixture<EventsClubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventsClubComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EventsClubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
