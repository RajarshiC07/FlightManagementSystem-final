import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduledFlightHomePageComponent } from './scheduled-flight-home-page.component';

describe('ScheduledFlightHomePageComponent', () => {
  let component: ScheduledFlightHomePageComponent;
  let fixture: ComponentFixture<ScheduledFlightHomePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduledFlightHomePageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduledFlightHomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
