import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Address } from '../models/address';
import { User } from '../models/user';
import { UserService } from '../user.service';
import { NgModel } from '@angular/forms';
import { Add2 } from '../add2';
import { AddressService } from '../addressService';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})

export class EditprofileComponent implements OnInit {

  cust: User;
  address: Add2=new Add2();


 custId:number=parseInt(localStorage.getItem("customerId"));
 valadd:number=parseInt(localStorage.getItem("addressId"));
 valpass:number=parseInt(localStorage.getItem("password"));
 userId: number=parseInt(localStorage.getItem("userId"));
  customer:User;
  modifyCustomer:User;
  updateDiv:boolean=false;
  msg:string;
  errorMsg:string;
  modifyAddress: Add2;
  msg2:string;
  errorMsg2:string;
  
  
  
  constructor(private userservice:UserService, private addressService:AddressService) { }



  ngOnInit(){

   console.log(this.valadd)
    this.addressService.viewAddressById(this.valadd).subscribe(data=>{console.log('Address' , (data)); this.modifyAddress=data});
    this.userservice.viewCustomerById(this.custId).subscribe(data=>this.cust=(data));
    console.log(this.cust);
    
  }
 
  
  updateCustomer(){
    console.log(this.cust); 
    this.cust.customerId=this.custId;
    this.cust.userId=this.userId;
    this.userservice.updateCustomer(this.cust)
          .subscribe(data=>{
            this.msg=data;
          },
            error=>{
              this.errorMsg=error.error;
              this.msg=undefined;
            });
            localStorage.setItem('firstName', this.cust.firstName);
            AppComponent.firstName=localStorage.getItem("firstName");      
}
  
  UpdateAddress(){
    console.log(this.modifyAddress); 
    this.modifyAddress.customerId=this.custId;
    this.modifyAddress.addressId=this.valadd;
    this.addressService.updateAddress(this.modifyAddress)
          .subscribe(data=>{
            this.msg2=data;
          },
            error=>{
              this.errorMsg2=error.error;
              this.msg2=undefined;
            });

  }

}