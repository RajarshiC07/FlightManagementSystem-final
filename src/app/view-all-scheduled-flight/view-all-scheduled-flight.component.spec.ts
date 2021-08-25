import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllScheduledFlightComponent } from './view-all-scheduled-flight.component';

describe('ViewAllScheduledFlightComponent', () => {
  let component: ViewAllScheduledFlightComponent;
  let fixture: ComponentFixture<ViewAllScheduledFlightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAllScheduledFlightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllScheduledFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
