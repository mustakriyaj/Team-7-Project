import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product12 } from './product.component';
import { Category } from '../category/category.component';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

    constructor(private http:HttpClient) { }
  
    public viewAllProducts():Observable<any>{
      console.log("Am inside service");
      console.log(Product12)
      return this.http.get<any>("http://localhost:8082/product/getallproducts");
    }
  
  
  
    public addProduct(product:Product12):Observable<any>{
      console.log("inside product service")
      console.log(JSON.stringify(product))
      return this.http.post("http://localhost:8082/product/addproduct",product,{responseType:'text'});
    }
  
    removeProduct(productId: number) :Observable<any>{
      console.log("http://localhost:8082/del/"+productId);
      return this.http.delete("http://localhost:8082/product/removeproduct/"+productId,{responseType:'text'});
    }
  
    UpdateProduct(modifyProduct: Product12) {
      console.log("inside product service")
      return this.http.put("http://localhost:8082/product/updateproduct",modifyProduct,{responseType:'text'});
  
    }

    getProductCategories(): Observable<Category[]> {
      return this.http.get<Category[]>("http://localhost:8082/category/viewcategory");
     }
  
  }