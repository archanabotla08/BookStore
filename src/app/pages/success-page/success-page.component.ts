import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CartService } from 'src/app/services/cart.service';
import { OrderService } from 'src/app/services/order.service';
import { SharedDataService } from 'src/app/services/sharedData.service';


@Component({
  selector: 'app-success-page',
  templateUrl: './success-page.component.html',
  styleUrls: ['./success-page.component.scss']
})
export class SuccessPageComponent implements OnInit {

  orderDetailsList: any;
  orderId: any
  constructor(
    private router: Router,
    private toastr: ToastrService,
    private orderService: OrderService,
    private activatedRoute: ActivatedRoute,
    private sharedData: SharedDataService
  ) { }

  ngOnInit(): void {
    this.getAllBooksFromCart();
    this.sharedData.currentMessage.subscribe(i => { this.orderId = i });
  }

  // delete all books from cart
  
  getAllBooksFromCart() {
    this.orderService.getRemoveAllBooksFromCart().subscribe(response => {
      if (response.statusCode == 200) {
        this.toastr.success(response.message);
      }
    }, error => {
      var response = error.error;
      if (response.statusCode != 200) {
        this.toastr.error(response.message);
      }
    })
  }
}
