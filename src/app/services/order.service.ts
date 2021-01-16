import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private getUrl: string = "http://18.219.128.158:8080/order/";
  private getUrlCustomer: string = "http://18.219.128.158:8080/cart/";

  headersRequest: any;

  constructor(private httpClient: HttpClient) { }

  headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Headers': 'Content-Type',
    'token': localStorage.getItem("token")!
  });


  getOrderDetails(): Observable<any> {
    return this.httpClient.get<any>(`${this.getUrl}details`, { headers: this.headers });
  }

  placeOrder(): Observable<any> {
    return this.httpClient.post<any>(`${this.getUrl}place`, " ", { headers: this.headers });
  }

  getRemoveAllBooksFromCart(): Observable<any> {
    return this.httpClient.delete<any>(`${this.getUrlCustomer}all`, { headers: this.headers });
  }
}