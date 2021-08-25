import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyAirportComponent } from './modify-airport.component';

describe('ModifyAirportComponent', () => {
  let component: ModifyAirportComponent;
  let fixture: ComponentFixture<ModifyAirportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyAirportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyAirportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
