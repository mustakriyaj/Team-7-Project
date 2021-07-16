import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import { catchError, tap } from 'rxjs/operators';
import { Login } from './models/login';
import { User } from './models/user';
import { Address } from './models/address';
import { Add2 } from './add2';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  register(login:Login): Observable<any> {
    const url = `http://localhost:8082/login/adduser`;
    return this.http.post<Login>(url, login);
  }

  register_user(user:User): Observable<any> {
    const url = `http://localhost:8082/customer/addcustomer`;
    return this.http.post<User>(url, user);
  }

  register_address(address:Address): Observable<any> {
    const url = `http://localhost:8082/address/addaddress`;
    return this.http.post<Address>(url,address);
  }

  updateCustomer(modifyCustomer: User) : Observable<any>{
    return this.http.put("http://localhost:8082/customer/updatecustomer", modifyCustomer, {responseType: "text"});
  }


  viewCustomerById(customerId: number): Observable<any>{
    return this.http.get("http://localhost:8082/customer/getcustomerbyid/"+ customerId);
  }
  
 
    
  // getLoginData(userEmail: string): Observable<any> {
  //   const url = `http://localhost:7071/login/getLoginData/`;
  //   return this.http.post<any>(url,userEmail);
  // }

  logout() {
    this.http.delete(`http://localhost:8082/logout`);
  }

  getLoginData(userEmail: string): Observable<any> {
    const url = `http://localhost:8082/login/getlogindata/${userEmail}`;
    return this.http.get<User>(url);
  }

  getCustomerData(userId: number): Observable<any> {
    const url = `http://localhost:8082/customer/getcustomerdata/${userId}`;
    return this.http.get<User>(url);
  }

  getAddressData(customerId: number): Observable<any> {
    const url = `http://localhost:8082/address/getaddressdata/${customerId}`;
    return this.http.get<Address>(url);
  }
  // login(loginForm){
  //   const url = `http://localhost:7071/login`;
  //   return this.http.post(url, loginForm);
  // }

  /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
   private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

        console.log(error); // log to console instead

        // Let the app keep running by returning an empty result.
        return of(result as T);
    };
}
}
