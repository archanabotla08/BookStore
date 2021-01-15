import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'registration/login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {

  loginDetail!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.loginDetail = this.formBuilder.group({
      emailId: [null, Validators.compose([Validators.required,
      Validators.pattern('')])],
      password: ['', Validators.compose([Validators.required,
      Validators.pattern('^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$')])],
    });
  }
  isFormValid(): boolean {
    if (
      this.loginDetail.controls['emailId'].valid &&
      this.loginDetail.controls['password'].valid)
      return true;
    this.loginDetail.markAllAsTouched();
    return false;
  }

  //get logged in
  
  login() {
    if (!this.isFormValid())
      return;
    var loginDTO = {
      'emailId': this.loginDetail.controls['emailId'].value,
      'password': this.loginDetail.controls['password'].value
    };
    this.userService.getUserLogin(loginDTO).subscribe((response: any) => {
      console.log("Response is ====> " + response);
      if (response.statusCode == 200) {
        localStorage.setItem("token", response.data);
        this.toastr.success(response.message);
        this.router.navigate(["/home"]);
      }
    }, error => {
      var response = error.error;
      if (response.statusCode == 400) {
        this.toastr.error(response.message + " " + response.data + " Please RegisterUser Before LogIn");
      } else {
        this.toastr.error(response.message + " " + response.data);
      }
    });
  }

}
