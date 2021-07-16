import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Category} from './category.component';

describe('CategoryComponent', () => {
  let component: Category;
  let fixture: ComponentFixture<Category>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Category ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Category);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
