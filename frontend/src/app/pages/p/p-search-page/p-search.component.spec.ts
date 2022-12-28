import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PSearchComponent } from './p-search.component';

describe('PSearchComponent', () => {
  let component: PSearchComponent;
  let fixture: ComponentFixture<PSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PSearchComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
