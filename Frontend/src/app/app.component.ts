import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { AppService } from './appService';
import { Category } from './components/category/category.component';
import { Product12 } from './components/product12/product.component';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { CartService } from './CartService';
import { CartComponent } from './components/cart/cart.component';
import { UserService } from './components/user.service';
import { Login } from './components/models/login';
import { User } from './components/models/user';
import { Address } from './components/models/address';
import { ProductsearchandviewComponent } from './components/productsearchandview/productsearchandview.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'OSA';
  val:String;
  categories:Category[];
  products:Product12[];
  productName:String;
  signbtn:boolean=true;
  admin:boolean=false;
  logoutbtn:boolean=false;
  errorMsg:string;
  msg:string;
  val2:String;
  static appnav:boolean=true;
  static catId:number;
  static productName:string;
  static firstName:string;
  
  
 

  constructor(private router:Router, private appService:AppService,private cartService:CartService, private modalService: NgbModal, private userService:UserService) { }
  
  closeResult: any;

  

  ngOnInit(): void {
    this.router.navigate(['home']);
    this.listProductCategories();
    AppComponent.appnav=true
    localStorage.clear();
  }



  listProductCategories() {
    this.appService.getProductCategories().subscribe(
      data => {
        console.log('Categories' + JSON.stringify(data));
        this.categories = data;
      }
    );

}


logout(){
  this.signbtn=true
  this.logoutbtn=false
  this.isLoginAdmin=false
  localStorage.clear();
}

open(content: any) {
  this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  });
}

private getDismissReason(reason: any): string {
  if (reason === ModalDismissReasons.ESC) {
    return 'by pressing ESC';
  } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
    return 'by clicking on a backdrop';
  } else {
    return  `with: ${reason}`;
  }
}


//for login from mustak
  isLoginUser: boolean = false;
  isLoginAdmin: boolean = false;
  isLogout: boolean = true;
model: any = {
  email:undefined,
  password:undefined
};

returnUrl:string = '/';

verify() {
  console.log(this.model);
  this.userService.getLoginData(this.model.email).subscribe(
    response => {
      if (response.password === this.model.password){
        if(response.role === "ADMIN"){
          this.isLoginAdmin=true;
          this.isLoginUser=false;
          AppComponent.appnav=false;
          this.isLogout=false;
          this.returnUrl = '/admin';
          sessionStorage.setItem('Role',response.role);
          console.log(sessionStorage.getItem('Role'));
          this.router.navigateByUrl(this.returnUrl);
        }
        else if(response.role === "USER"){
          this.isLoginAdmin=false;
          this.isLoginUser=true;
          this.isLogout=false;
          this.signbtn=false
          this.logoutbtn=true
          this.returnUrl = '/home';
          localStorage.setItem('userId', response.userId);
          localStorage.setItem('Role', response.role);
          localStorage.setItem('userEmail', response.userEmail);
          localStorage.setItem('password', response.password);
          console.log(sessionStorage.getItem('Role'));
          this.userService.getCustomerData(response.userId).subscribe(
            response => {
              localStorage.setItem('customerId', response.customerId);
              localStorage.setItem('firstName', response.firstName);
              AppComponent.firstName=localStorage.getItem("firstName");
              localStorage.setItem('lastName', response.lastName);
              localStorage.setItem('mobileNumber', response.mobileNumber);
              this.userService.getAddressData(response.customerId).subscribe(
                response => {
                  localStorage.setItem('addressId', response.addressId);})
            }
          );
          
          console.log(sessionStorage.getItem('Role'));
          sessionStorage.setItem('data', JSON.stringify(response));
          this.router.navigateByUrl(this.returnUrl);
        }
      }
      else{
        alert("Invalid Credintials");
      }
    },
    error => {
      alert("Invalid Credintials");
    }
  );
}

 get staticfirst(){
   return AppComponent.firstName;
 }
//register by mustak
login: Login = new Login();
  user: User = new User();
  address: Address = new Address();
  model1: any = {
    first_name:undefined,
    last_name:undefined,
    building_name:undefined,
    street_no:undefined,
    city:undefined,
    state:undefined,
    pincode:undefined,
    country:undefined,
    mobile_number:undefined,
    email:undefined,
    password:undefined,
    password_repeat:undefined
  }


  register(){
    this.login.userEmail = this.model1.email;
    this.login.password = this.model1.password;
    this.login.role = 'USER';
    this.userService.register(this.login).subscribe(response => {
      console.log(response);
      this.user.firstName = this.model1.first_name;
      this.user.lastName = this.model1.last_name;
      this.user.mobileNumber = this.model1.mobile_number;
      this.user.email = this.model1.email;
      this.user.userId = response.userId;
      this.userService.register_user(this.user).subscribe(response => {
        console.log(response);
        this.address.buildingName = this.model1.building_name;
        this.address.streetNo = this.model1.street_no;
        this.address.city = this.model1.city;
        this.address.state = this.model1.state;
        this.address.country = this.model1.country;
        this.address.pincode = this.model1.pincode;
        this.address.customerId = response.customerId;
        this.userService.register_address(this.address).subscribe(response => {
          console.log(response);
          alert("Registration successful!");
          this.router.navigate(['/login']);
        },
        error => {alert("Registration failed!");}
        );
      });
    });
  }

  viewcat(catId: number){
    AppComponent.catId=catId;
}
viewprod(productName: string){
  AppComponent.productName=productName;
}


  get staticBtn() {
    return AppComponent.appnav;
  }
  get staticviewcat(){
    return AppComponent.catId;
  }
  get staticviewprod(){
    return AppComponent.productName;
  }
}
