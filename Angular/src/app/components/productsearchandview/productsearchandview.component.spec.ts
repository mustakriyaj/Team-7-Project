import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductsearchandviewComponent } from './productsearchandview.component';

describe('ProductsearchandviewComponent', () => {
  let component: ProductsearchandviewComponent;
  let fixture: ComponentFixture<ProductsearchandviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductsearchandviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductsearchandviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
