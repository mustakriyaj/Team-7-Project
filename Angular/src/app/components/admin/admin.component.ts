import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  adminnav:boolean=true;

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  returnUrl:string="/home";
logout(){
  this.adminnav=false;
  AppComponent.appnav=true;
  this.router.navigateByUrl(this.returnUrl);
}

}
