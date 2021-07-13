import { Component, OnInit } from '@angular/core';
import { Product12 } from '../product.component';
import { ProductService } from '../ProductService';
import { Category } from '../../category/category.component';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  product: Product12 = new Product12();
  categories: Category[];
  msg:String | undefined;
  errorMsg:String | undefined;
  products:Product12[]=[]

  constructor(private productService:ProductService) { }

  ngOnInit(){
    this.listProductCategories();
  }

  addProduct(){
    this.productService.addProduct(this.product)
    .subscribe
    (
      (data)=>
      {
      console.log("data",data);
      this.msg=data;
      this.errorMsg=undefined;
      },
      (error)=>
      {
        this.errorMsg=error.error;
        console.log(error.error);
        this.msg=undefined
      }
     );
  }

  listProductCategories() {
    this.productService.getProductCategories().subscribe(
      data => {
        console.log('Categories' + JSON.stringify(data));
        this.categories = data;
      }
    );

}

}
