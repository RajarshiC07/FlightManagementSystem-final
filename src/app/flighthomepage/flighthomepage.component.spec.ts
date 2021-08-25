import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlighthomepageComponent } from './flighthomepage.component';

describe('FlighthomepageComponent', () => {
  let component: FlighthomepageComponent;
  let fixture: ComponentFixture<FlighthomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlighthomepageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlighthomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
