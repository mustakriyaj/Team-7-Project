import { Component, OnInit } from '@angular/core';
import {Category} from '../category.component';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-addcategory',
  templateUrl: './addcategory.component.html',
  styleUrls: ['./addcategory.component.css']
})
export class AddcategoryComponent implements OnInit {

  category:Category=new Category();
  msg:String | undefined;
  errorMsg:String | undefined;
  constructor(private categoryService:CategoryService) { }

  ngOnInit(): void {
  }

  addCategory(){
    this.categoryService.addCategory(this.category)
    .subscribe
    (
      (data)=>
      {
      console.log("data",data);
      this.msg=data;
      this.errorMsg;
      },      
      (error)=>
      {
        this.errorMsg=error.error;
        console.log(error.error);
        this.msg;
      }
     );
  }
}
