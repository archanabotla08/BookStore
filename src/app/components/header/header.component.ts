import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(
    private router: Router,
    private toastr : ToastrService,
    private cartService: CartService
  ) { }

  ngOnInit(): void {
  }
  //logout method
  logout(){
    console.log("in Logout");
    var token = localStorage.getItem('token');
    console.log("token After logout:",token);
    if(token != '' && token != null){
      this.toastr.success("logout successfull");
      localStorage.clear();
      this.router.navigate(["/home"]);
    }else{
      this.toastr.error("User Not Logged In");
    }
  }
}
