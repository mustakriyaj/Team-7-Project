import { Component, OnInit } from '@angular/core';
import { Category } from '../category/category.component';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class Product12 {

    productId:number = 0;
    productName:string | undefined;
    price:number | undefined;
    color:string | undefined;
    dimension:string | undefined;
    specification:string | undefined;
    manufacturer:string | undefined;
    quantity:number =0;
    catId: Category;
  find: any;

  constructor(){}
}
