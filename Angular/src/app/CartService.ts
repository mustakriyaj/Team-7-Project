import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product12 } from './components/product12/product.component';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(public http:HttpClient) { }

  addItemToCart(customerId,productId):Observable<any>
  {
    return this.http.get("http://localhost:8082/addcart/"+customerId+"/"+productId,{responseType:'text'});
  }
  
  removeCartItem(cartId: number) :Observable<any>{
    return this.http.delete("http://localhost:8082/removecartitem/"+cartId);
  }

  getCartItems(customerId): Observable<any> {
    return this.http.get<any>("http://localhost:8082/getcartitems/"+customerId);
   }




  // setCart(cart:Product12[] ) {
  //   this.cart=cart;
  //   console.log(cart)
  // }
  // getCart( ):Product12[] {
  //   console.log(this.cart)
  //   return this.cart;

  // }

}
