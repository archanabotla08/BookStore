import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class BookListService {
  private getUrl: string = "http://localhost:8080/bookstoreservice/";

  constructor(private httpClient: HttpClient) { }

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
  
//   getEmployeePayrollById(id: number): Observable<any> {
//     return this.httpClient.get<any>(`${this.getUrl}get/${id}`);
//   }



//   getUserrRegistration(data: any): Observable<Registration> {
//     return this.httpClient.post<Registration>(`${this.getUrl}register`, data);
//   }

//   getUserLogin(data: any): Observable<Login> {
//     return this.httpClient.post<Login>(`${this.getUrl}login`, data);
//   }
//   updateEmployeePayRollRecord(data: any) {
//     var id = data.id;
//     return this.httpClient.put<EmployeePayRoll>(`${this.getUrl}update/${id}`, data);
//   }
}