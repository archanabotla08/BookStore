import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Registration } from '../models/registration.model';
import { Login } from '../models/login.model';
import { ForgetPassword } from '../models/forgetPassword.model';
import { ResetPassword } from '../models/resetPassword.model';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private getUrl: string = "http://localhost:8080/user/";

  constructor(private httpClient: HttpClient) { }

//   getAllEmployeePayRollList(): Observable<any> {
//     return this.httpClient.get<any>(`${this.getUrl}get`);
//   }
  
//   getEmployeePayrollById(id: number): Observable<any> {
//     return this.httpClient.get<any>(`${this.getUrl}get/${id}`);
//   }

//   deleteEmployeePayrollRecord(id: number): Observable<any> {
//     return this.httpClient.delete(`${this.getUrl}delete/${id}`);
//   }

  getUserrRegistration(data: any): Observable<Registration> {
    return this.httpClient.post<Registration>(`${this.getUrl}register`, data);
  }

  getUserLogin(data: any): Observable<Login> {
    return this.httpClient.post<Login>(`${this.getUrl}login`, data);
  }
  getForgetPassword(data: any): Observable<ForgetPassword> {
    return this.httpClient.post<ForgetPassword>(`${this.getUrl}forgetPassword`, data);
  }

  getResetPassword(data: any): Observable<ResetPassword> {
    return this.httpClient.post<ResetPassword>(`${this.getUrl}resetPassword`, data);
  }
}