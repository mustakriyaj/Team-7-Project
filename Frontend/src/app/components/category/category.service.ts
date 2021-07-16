import '@angular/compiler';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category} from './category.component';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient) { }

  public viewCategory():Observable<any>{
    console.log("Am inside service");
    return this.http.get("http://localhost:8082/category/viewcategory");
  }

  public addCategory(category:Category):Observable<any>{
    console.log("Inside AddCategory")
    console.log(JSON.stringify(category))
    return this.http.post("http://localhost:8082/category/addcategory",category,{responseType:'text'});
  }

  deleteCategory(catId: number) :Observable<any>{
    console.log("http://localhost:8082/del/"+catId);
    return this.http.delete("http://localhost:8082/category/deletecategory/"+catId,{responseType:'text'});
  }
  
  updateCategory(modifyCategory: Category) {
    return this.http.put("http://localhost:8082/category/updatecategory",modifyCategory,{responseType:'text'});
    
  }
  

}
