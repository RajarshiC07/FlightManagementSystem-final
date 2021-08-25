import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewbyAirportComponent } from './viewby-airport.component';

describe('ViewbyAirportComponent', () => {
  let component: ViewbyAirportComponent;
  let fixture: ComponentFixture<ViewbyAirportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewbyAirportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewbyAirportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
