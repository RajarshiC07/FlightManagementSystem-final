import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookinghomeComponent } from './bookinghome.component';

describe('BookinghomeComponent', () => {
  let component: BookinghomeComponent;
  let fixture: ComponentFixture<BookinghomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookinghomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookinghomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
