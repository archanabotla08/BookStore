import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { elementAt } from 'rxjs/operators';
import { CartService } from 'src/app/services/cart.service';
import { CustomerService } from 'src/app/services/customer.service';
import { OrderService } from 'src/app/services/order.service';
import { SharedDataService } from 'src/app/services/sharedData.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss'],
})
export class CartComponent implements OnInit {

  panelOpenState = false;
  booksListInCart: any;
  customerDetail!: FormGroup;
  bookListDetail!: FormGroup;
  orderBookList: any;
  totalPrice: any;
  imageURL: any;
  orderDetailsList: any;
  orderId: any;
  bookQuantity = 1;
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private toastr: ToastrService,
    private cartService: CartService,
    private orderService: OrderService,
    private customerService: CustomerService,
    private sharedDataService: SharedDataService
  ) { }

  ngOnInit(): void {
    this.getBookListCartCount();

    this.sharedDataService.currentRelevance.subscribe(element => {  });

    //customer form validation

    this.customerDetail = this.formBuilder.group({
      fullName: ['', Validators.compose([Validators.required, Validators.minLength(2),
      Validators.pattern('^[A-Z][a-zA-Z\\s]{2,}$')])],
      phoneNumber: ['', Validators.compose([Validators.required,
      Validators.pattern('^[6-9][0-9]{9}$')])],
      address: ['', Validators.compose([Validators.required, Validators.minLength(2),
      Validators.pattern('^[A-Z][a-zA-Z\\s]{2,}$')])],
      city: ['', Validators.compose([Validators.required,
      Validators.pattern('^[a-zA-Z]{2,}$')])],
      state: ['', Validators.compose([Validators.required,
      Validators.pattern('^[a-zA-Z]{2,}$')])],
      locality: ['', Validators.compose([Validators.required,
      Validators.pattern('^[a-zA-Z]{2,}$')])],
      locationType: ['', Validators.required],
      landmark: ['', Validators.compose([Validators.required,
      Validators.pattern('^[a-zA-Z]{2,}$')])],
      pinCode: ['', Validators.compose([Validators.required,
      Validators.pattern('^[0-9]{6}$')])],
    });
    this.bookListDetail = this.formBuilder.group({
      authorName: [''],
      bookDetails: [''],
      bookName: [''],
      imageURL: [''],
      price: [''],
      quantity: ['']
    })
  }

  isFormValid(): boolean {
    if (
      this.customerDetail.controls['fullName'].valid &&
      this.customerDetail.controls['phoneNumber'].valid &&
      this.customerDetail.controls['address'].valid &&
      this.customerDetail.controls['city'].valid &&
      this.customerDetail.controls['state'].valid &&
      this.customerDetail.controls['locality'].valid &&
      this.customerDetail.controls['landmark'].valid &&
      this.customerDetail.controls['locationType'].valid &&
      this.customerDetail.controls['pinCode'].valid)
      return true;
    this.customerDetail.markAllAsTouched();
    return false;
  }

  // add customer details 
  addCustomerDetails() {
    if (!this.isFormValid())
      return;
    var customerDetailsDTO = {
      'fullName': this.customerDetail.controls['fullName'].value,
      'phoneNumber': this.customerDetail.controls['phoneNumber'].value,
      'address': this.customerDetail.controls['address'].value,
      'city': this.customerDetail.controls['city'].value,
      'state': this.customerDetail.controls['state'].value,
      'locality': this.customerDetail.controls['locality'].value,
      'landmark': this.customerDetail.controls['landmark'].value,
      'locationType': this.customerDetail.controls['locationType'].value,
      'pinCode': this.customerDetail.controls['pinCode'].value
    };

    this.customerService.addCustomerDetails(customerDetailsDTO).subscribe((response: any) => {
      if (response.statusCode == 200) {
        this.toastr.success(response.message);
        this.nextStep();
      }

    }, error => {
      var response = error.error;
      if (response.statusCode != 200) {
        this.toastr.error(response.message);
      }
    });

  }

  // Place order

  placeOrder(bookId: any) {
    this.orderService.placeOrder().subscribe(response => {
      console.log("place order: ", response);
      if (response.statusCode == 200) {
        this.toastr.success(response.message);
        this.getOrderDetails();
      }
    }, error => { })
    this.getOrderDetails();
  }

  // get order details

  getOrderDetails() {
    this.orderService.getOrderDetails().subscribe(response => {
      console.log(response)
      if (response.statusCode == 200) {
        this.toastr.success(response.message);
        this.orderBookList = response.data.cartBooks;
      }
    }, error => {
      var response = error.error;
      this.toastr.error(response.message);
    });
  }

  //get Quantity decrement
  
  bookQuantityDecrement(bookId: any) {
    console.log(bookId);
    this.cartService.decrementBookQuantity(bookId).subscribe(response => {
      if (response.statusCode == 200) {
        this.bookQuantity -= 1;
        (response.data).forEach((element: any) => {
          if (this.bookQuantity < 1) {
            this.bookQuantity = 1
          } else {
            this.bookQuantity -= 1;
          }
          this.bookListDetail.controls['quantity'].setValue(element.quantity);
        });
        this.toastr.success(response.message);
        this.getBookListCartCount();
      }
    }, error => {
      var response = error.error;
      if (response.statusCode == 500) {
        this.toastr.error(response.message)
      }
    })
  }

  //get Quantity increment

  bookQuantityIncrement(bookId: any) {
    console.log(bookId);
    this.cartService.incrementBookQuantity(bookId).subscribe(response => {

      if (response.statusCode == 200) {
        (response.data).forEach((element: any) => {
          this.bookQuantity += 1;
        });
        this.toastr.success(response.message);
        this.getBookListCartCount();
      }
    }, error => {
      var response = error.error;
      if (response.statusCode == 500) {
        this.toastr.error(response.message)
      }
    })

  }

  //delete book from cart

  deleteBookFromCart(bookId: any) {
    this.cartService.deleteBookFromCart(bookId).subscribe(response => {
      if (response.statusCode == 200) {
        this.toastr.success(response.message);
        this.getBookListCartCount();
      }
    }, error => {
      var response = error.error;
      if (response.statusCode != 200) {
        this.toastr.error(response.message);
      }
    })
  }
  step = 0;

//step for cart
  setStep(index: number) {
    this.step = index;
  }

  nextStep() {
    this.step++;
  }

  prevStep() {
    this.step--;
  }

  //getBookListCartCount

  getBookListCartCount() {
    this.cartService.getAllBooksListCountInCart().subscribe(response => {
      this.booksListInCart = response.data;
      (response.data).forEach((element: any) => {
        this.bookListDetail.controls['quantity'].setValue(element.quantity);
      });
      console.log("cart:", response);
      this.toastr.success(response.message);
    }, error => { })
  }

  // url for route on checkout button
  
  checkout(orderId: any, bookId: any) {
    this.sharedDataService.changeMessage(orderId);
    this.router.navigate(["/success"]);
  }

  fields: string[] = ['locationType'];
  validatePrevious(num: Number) {
    for (var i = 0; i <= num; i++)
      this.customerDetail.controls[this.fields[i]].markAsTouched();
  }
}
