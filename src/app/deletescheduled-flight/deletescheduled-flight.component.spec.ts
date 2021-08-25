import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletescheduledFlightComponent } from './deletescheduled-flight.component';

describe('DeletescheduledFlightComponent', () => {
  let component: DeletescheduledFlightComponent;
  let fixture: ComponentFixture<DeletescheduledFlightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeletescheduledFlightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletescheduledFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
