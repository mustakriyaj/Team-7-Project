import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { AppService } from 'src/app/appService';
import { CartService } from 'src/app/CartService';
import { Router } from '@angular/router';
import { Product12 } from '../product12/product.component';

@Component({
  selector: 'app-searchproduct',
  templateUrl: './searchproduct.component.html',
  styleUrls: ['./searchproduct.component.css']
})
export class SearchproductComponent implements OnInit {

  errorMsg:string;
  msg:string;
  starRating = 4; 
  stock: String;
  products:Product12[];
  product: Product12 = new Product12();
  cart:Product12[];
  prod: Product12[];

  constructor(private appService:AppService,private cartService:CartService,private router:Router) { }

  ngOnInit(): void {
    if(this.appService.viewProduct(AppComponent.productName)){
    this.appService.viewProduct(AppComponent.productName).subscribe(data=>{console.log('Products' + JSON.stringify(data)); this.product=data},
    error=>{
      confirm("No Such Product! Want to continue?")
      this.errorMsg=error.error;
      this.product= new Product12();
    }
    );
  }
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

