import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class BookListService {
  private getUrl: string = "http://18.219.128.158:8080/bookstoreservice/";
  private getCartUrl: string = "http://18.219.128.158:8080/cart/";
  headersRequest: any;

  constructor(private httpClient: HttpClient) { }

  headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Headers': 'Content-Type',
    'token': JSON.stringify(localStorage.getItem("token"))
  });



  getAllBooksList(): Observable<any> {
    return this.httpClient.get<any>(`${this.getUrl}getBookList`);
  }

  getAllBooksListCount(): Observable<any> {
    return this.httpClient.get<any>(`${this.getUrl}count`);
  }

  getAllBooksListCountAscendingOrder(): Observable<any> {
    return this.httpClient.get<any>(`${this.getUrl}sort/price/ascending`);
  }
  getAllBooksListCountDescendingOrder(): Observable<any> {
    return this.httpClient.get<any>(`${this.getUrl}sort/price/descending`);
  }

  deleteBookRecord(id: number): Observable<any> {
    return this.httpClient.delete(`${this.getUrl}delete/${id}`);
  }

}