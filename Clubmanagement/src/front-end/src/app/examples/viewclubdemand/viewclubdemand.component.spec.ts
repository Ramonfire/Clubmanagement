import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewclubdemandComponent } from './viewclubdemand.component';

describe('ViewclubdemandComponent', () => {
  let component: ViewclubdemandComponent;
  let fixture: ComponentFixture<ViewclubdemandComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewclubdemandComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewclubdemandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
