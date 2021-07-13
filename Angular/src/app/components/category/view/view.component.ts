import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../category.service';
import { Category } from '../category.component';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  categories:Category[]=[];
  modifyCategory=new Category();
  updateDiv:boolean=false;
  msg:string;
  errorMsg:string;
  constructor(private categoryService:CategoryService) { }

  ngOnInit(): void {
    console.log("Am inside view component");
    this.categoryService.viewCategory().subscribe(data=>this.categories=data);
    console.log(this.categories);
  }

  deleteCategory(catId:number){

    if(confirm("Confirm Deletion of Account Id:"+catId)){
      this.categoryService.deleteCategory(catId)
      .subscribe(data=>{
        this.msg=data;
        this.errorMsg=undefined;
        //Reload account
        this.categoryService.viewCategory().subscribe(data=>this.categories=data);
        this.categories = this.categories.filter(item => item.catId != catId);
        console.log(this.categories);
      },
        error=>{
          this.errorMsg=error.error;
          this.msg=undefined;
        });

    }
    
  }
  update(category:Category)
  {
    console.log(JSON.stringify(category));
    this.modifyCategory=category;
    this.updateDiv=true;//make update division visible
  }
  cancel()
  {
    this.updateDiv=false;//make update division invisible
  }
  updateCategory(){
    this.updateDiv=false;//make update division invisible
    this.categoryService.updateCategory(this.modifyCategory)
          .subscribe(data=>{
            this.msg=data;
            this.errorMsg=undefined;
            //Reload account
            this.categoryService.viewCategory().subscribe(data=>this.categories=data);
            console.log(this.categories);
          },
            error=>{
              this.errorMsg=error.error;
              this.msg=undefined;
            });

  }


}
