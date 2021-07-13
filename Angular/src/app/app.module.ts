import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Category } from './components/category/category.component';
import { CartComponent } from './components/cart/cart.component';
import { HomeComponent } from './components/home/home.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AddcategoryComponent } from './components/category/addcategory/addcategory.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { CategoryService } from './components/category/category.service';
import { ViewComponent } from './components/category/view/view.component';
import { ProductviewComponent } from './components/product12/productview/productview.component';
import { Product12 } from './components/product12/product.component';
import { ProductComponent } from './components/product12/product/product.component';
import { UserService } from './components/user.service';
import { FooterComponent } from './components/footer/footer.component';
import { AdminComponent } from './components/admin/admin.component';
import { ProductsearchandviewComponent } from './components/productsearchandview/productsearchandview.component';
import { SearchproductComponent } from './components/searchproduct/searchproduct.component';
import { EditprofileComponent } from './components/editprofile/editprofile.component';

@NgModule({
  declarations: [
    AppComponent,
    Category,
    Product12,
    ProductComponent,
    CartComponent,
    HomeComponent,
    AddcategoryComponent,
    ViewComponent,
    ProductviewComponent,
    FooterComponent,
    AdminComponent,
    ProductsearchandviewComponent,
    SearchproductComponent,
    EditprofileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [CategoryService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
