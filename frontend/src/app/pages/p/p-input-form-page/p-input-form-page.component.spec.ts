import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PInputFormPageComponent } from './p-input-form-page.component';

describe('PInputFormPageComponent', () => {
  let component: PInputFormPageComponent;
  let fixture: ComponentFixture<PInputFormPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PInputFormPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PInputFormPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
