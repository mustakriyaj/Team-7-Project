import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Product12 } from './product.component';

describe('ProductComponent', () => {
  let component: Product12;
  let fixture: ComponentFixture<Product12>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Product12 ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Product12);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
