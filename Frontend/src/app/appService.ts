import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product12 } from './components/product12/product.component';
import { Category } from './components/category/category.component';

@Injectable({
  providedIn: 'root'
})
export class AppService {
   
  
    constructor(private http:HttpClient) { }
  
    public viewProductsByCategory(catId: number):Observable<any>{
      console.log("Am inside service");
      console.log(JSON.stringify(Product12))
      return this.http.get<any>("http://localhost:8082/product/getproductbycatid/"+catId);
    }

    public viewProduct(productName: String):Observable<any>{
      console.log("Am inside service");
      console.log(JSON.stringify(Product12))
      return this.http.get<any>("http://localhost:8082/product/getproductbyname/"+productName);
    }

    getProductCategories(): Observable<Category[]> {
      return this.http.get<Category[]>("http://localhost:8082/category/viewcategory");
     }
  
  }