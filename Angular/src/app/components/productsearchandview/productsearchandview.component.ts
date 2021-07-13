import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { AppService } from 'src/app/appService';
import { Router } from '@angular/router';
import { CartService } from 'src/app/CartService';
import { Product12 } from '../product12/product.component';
@Component({
  selector: 'app-productsearchandview',
  templateUrl: './productsearchandview.component.html',
  styleUrls: ['./productsearchandview.component.css']
})
export class ProductsearchandviewComponent implements OnInit {

  errorMsg:string;
  msg:string;
  starRating = 4; 
  stock: String;
  products:Product12[];
  product: Product12 = new Product12();
  cart:Product12[];
  prod: Product12[];
 

  

  constructor(private appService:AppService, private router:Router, private cartService:CartService) { }

  ngOnInit(){
    
    this.appService.viewProductsByCategory(AppComponent.catId).subscribe(data=>this.products=data);
  }

  add(productId){
    let customerId=localStorage.getItem("customerId")
    this.cartService.addItemToCart(customerId,productId)
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
  checkstock(qty:number){
    if(qty>0){this.stock="In Stock! Hurry up!"}
    else{this.stock="Out of Stock"};
    return(this.stock);
  }
 
  back(){
    this.router.navigate(['/home']);
  }
}
