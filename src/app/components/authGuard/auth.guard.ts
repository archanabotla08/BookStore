import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';
const helper = new JwtHelperService();
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
 
  // Inject Router so we can hand off the user to the Login Page 
  constructor(private router: Router) {}
 
  canActivate(): boolean {
        if( String(localStorage.getItem('token')) == '' || String(localStorage.getItem('token')) == 'null' ){
          console.log("inauth Guard" ,String(localStorage.getItem('token')));
           this.router.navigateByUrl('/login');
           return false;
       }
       const isExpired = helper.isTokenExpired(String(localStorage.getItem('token')));
       if(isExpired){
        console.log("inauth Guard is expired" ,String(localStorage.getItem('token')));
           this.router.navigateByUrl('/login');
           return false;
       }
       console.log("successfi");
       return true;
  }
}