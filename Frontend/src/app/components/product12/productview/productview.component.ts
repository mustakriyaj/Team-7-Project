import { Component, OnInit } from '@angular/core';
import { Product12 } from '../product.component';
import { ProductService } from '../ProductService';
import { Category } from '../../category/category.component';

@Component({
  selector: 'app-productview',
  templateUrl: './productview.component.html',
  styleUrls: ['./productview.component.css']
})
export class ProductviewComponent implements OnInit {

  products:Product12[];
  prod:Product12;
  categories: Category[];
  modifyProduct=new Product12();
  updateDiv:boolean=false;
  msg:string | undefined;
  errorMsg:string | undefined;
  constructor(private productService:ProductService) { }



  ngOnInit(): void {
    console.log("Am inside view component");
    this.productService.viewAllProducts().subscribe(data=>this.products=data);
    console.log(this.products);
    this.listProductCategories();
  }

 removeProduct(productId:number){

    if(confirm("Confirm Deletion of Product Id:"+productId)){
      this.productService.removeProduct(productId)
      .subscribe(data=>{
        this.msg=data;
        //Reload account
        this.productService.viewAllProducts().subscribe(data=>this.products=data);
        this.products = this.products.filter(item => item.productId != productId);
        console.log(this.products);
      },
        error=>{
          this.errorMsg=error.error;
          this.msg="product not deleted";
        });

    }

  }
  update(product:Product12)
  {
    console.log(JSON.stringify(product));
    this.modifyProduct=product;
    this.updateDiv=true;//make update division visible
  }
  cancel()
  {
    this.updateDiv=false;//make update division invisible
  }
  updateProduct(){
    this.updateDiv=false;//make update division invisible
    this.productService.UpdateProduct(this.modifyProduct)
          .subscribe(data=>{
            this.msg=data;
            //Reload account
            this.productService.viewAllProducts().subscribe(data=>this.products=data);
            console.log(this.products);
          },
            error=>{
              this.errorMsg=error.error;
              this.msg=undefined;
            });

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
