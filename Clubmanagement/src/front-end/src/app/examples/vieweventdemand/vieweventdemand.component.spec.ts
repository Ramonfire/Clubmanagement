import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VieweventdemandComponent } from './vieweventdemand.component';

describe('VieweventdemandComponent', () => {
  let component: VieweventdemandComponent;
  let fixture: ComponentFixture<VieweventdemandComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VieweventdemandComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VieweventdemandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
