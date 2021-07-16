import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AddcategoryComponent } from './components/category/addcategory/addcategory.component';
import { Category } from './components/category/category.component';
import { ViewComponent } from './components/category/view/view.component';
import { Product12 } from './components/product12/product.component';
import { ProductComponent } from './components/product12/product/product.component';
import { ProductviewComponent } from './components/product12/productview/productview.component';
import { CartComponent } from './components/cart/cart.component';
import { AdminComponent } from './components/admin/admin.component';
import { ProductsearchandviewComponent } from './components/productsearchandview/productsearchandview.component';
import { SearchproductComponent } from './components/searchproduct/searchproduct.component';
import { EditprofileComponent } from './components/editprofile/editprofile.component';


const routes: Routes = [
  { path: 'home',     component: HomeComponent},
  { path: 'category',  component: Category},
  {path:'addcategory', component:AddcategoryComponent},
  {path:'view', component:ViewComponent},
  {path:'product12', component:Product12},
  {path:'product', component:ProductComponent},
  {path:'productview', component:ProductviewComponent},
  {path:'cart', component:CartComponent},
  {path:'admin', component:AdminComponent},
  {path:'productsearchandview', component:ProductsearchandviewComponent},
  {path:'searchproduct', component:SearchproductComponent},
  {path:'editprofile', component:EditprofileComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
