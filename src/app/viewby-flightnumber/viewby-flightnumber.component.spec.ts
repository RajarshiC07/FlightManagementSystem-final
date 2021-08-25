import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewbyFlightnumberComponent } from './viewby-flightnumber.component';

describe('ViewbyFlightnumberComponent', () => {
  let component: ViewbyFlightnumberComponent;
  let fixture: ComponentFixture<ViewbyFlightnumberComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewbyFlightnumberComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewbyFlightnumberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
