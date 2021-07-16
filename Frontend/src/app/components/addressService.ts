import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Add2 } from './add2';


@Injectable({
  providedIn: 'root'
})
export class AddressService {

    constructor(private http:HttpClient) { }
  
    updateAddress(address: Add2) : Observable<any>{
        console.log("Inside update Address");
        console.log(JSON.stringify(address));
        return this.http.put("http://localhost:8082/address/updateaddress", address, {responseType: "text"});
      }

      
      viewAddressById(addressId: number): Observable<any>{
        console.log("Inside view address")
        return this.http.get<Add2>("http://localhost:8082/address/getaddressbyid/"+ addressId);
      }
  }