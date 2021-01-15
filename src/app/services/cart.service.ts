import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class CartService {
  private getUrl: string = "http://localhost:8080/cart/";
  private getUrlCu: string = "http://localhost:8080/customer/";


  headersRequest: any;

  constructor(private httpClient: HttpClient) { }

  headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Headers': 'Content-Type',
    'token': localStorage.getItem("token")!
  });


  getAllBooksListCountInCart(): Observable<any> {
    return this.httpClient.get<any>(`${this.getUrl}allbooks`, { headers: this.headers });
  }

  addBookToCart(bookId: any): Observable<any> {
    var token = localStorage.getItem("token")!;
    const options = {
      headers: new HttpHeaders({
        'token': token,
        'Content-Type': 'application/json'
      })
    };
    return this.httpClient.post<any>(`${this.getUrl}book?bookId=` + bookId, " ", options);
  }

  // addCustomerDetails(data: any): Observable<any> {
  //   return this.httpClient.post<any>(`${this.getUrl}details`,data,{headers: this.headers});
  // }

  getAllCustomerDetails(): Observable<any> {
    return this.httpClient.get<any>(`${this.getUrlCu}details`, { headers: this.headers });
  }

  addBookToWishlist(bookId: any): Observable<any> {
    var token = localStorage.getItem("token")!;
    const options = {
      headers: new HttpHeaders({
        'token': token,
        'Content-Type': 'application/json'
      })
    };
    return this.httpClient.post<any>(`${this.getUrl}wishlist/book?bookId=` + bookId, " ", { headers: this.headers });
  }

  decrementBookQuantity(bookId: any): Observable<any> {
    return this.httpClient.delete<any>(`${this.getUrl}item?bookId=` + bookId, { headers: this.headers });
  }
  incrementBookQuantity(bookId: any): Observable<any> {
    return this.httpClient.post<any>(`${this.getUrl}moreitems?bookId=` + bookId, " ", { headers: this.headers });
  }
  deleteBookFromCart(bookId: any): Observable<any> {
    return this.httpClient.delete<any>(`${this.getUrl}book?bookId=` + bookId, { headers: this.headers });
  }

}