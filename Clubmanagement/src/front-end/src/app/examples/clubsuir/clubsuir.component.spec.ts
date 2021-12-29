import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClubsUirComponent } from './clubsuir.component';

describe('ClubsComponent', () => {
  let component: ClubsUirComponent;
  let fixture: ComponentFixture<ClubsUirComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClubsUirComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClubsUirComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
