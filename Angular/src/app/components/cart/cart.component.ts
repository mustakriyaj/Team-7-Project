import { Component, OnInit } from '@angular/core';
import { Product12 } from '../product12/product.component';
import { CartService } from 'src/app/CartService';
import { Cart } from 'src/app/Cart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  

  errorMsg:String| undefined;
  msg:String;
  cart:Cart[]=[];
  customerId=localStorage.getItem("customerId");
  val: number=1;
  

  
  constructor(private cartService:CartService) { }

  ngOnInit(): void {
    if(this.customerId!=undefined){
    this.cartService.getCartItems(this.customerId).subscribe(data=>
      {
      this.cart=data},
        error=>{
          this.errorMsg=error.error;
          this.msg=undefined;
        }
      );}
      else{
        this.errorMsg="Login to use Cart"
      }
    console.log(this.cart);
  }


  removeCartItem(cartId:number){
    

    if(confirm("Confirm Deletion of Product Id:"+cartId)){
      this.cartService.removeCartItem(cartId)
      .subscribe(data=>{
        this.msg=data;
        this.errorMsg=undefined;
       this.cartService.getCartItems(this.customerId).subscribe(data=>this.cart=(data));
       this.cart = this.cart.filter(item => item.cartId != cartId);
        console.log(this.cart);
      },
        error=>{
          this.errorMsg=error.error;
          this.msg=undefined;
        });

    }

  }
  order(){
    console.log("datamember")

    console.log(this.cart)
    console.log("service datamember")
}


}
