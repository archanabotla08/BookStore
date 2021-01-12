import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Toast, ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss'],
})
export class ForgotPasswordComponent implements OnInit {

  forgetPasswordDetail!: FormGroup;
  
  constructor(
    private formBuilder: FormBuilder,
    private userService : UserService,
    private router: Router,
    private toastr : ToastrService

  ) { }

  ngOnInit(): void {
    this.forgetPasswordDetail = this.formBuilder.group({
      emailId: [null,  Validators.compose([Validators.required,
        Validators.pattern('')])]
    });
  }
  isFormValid(): boolean {
    if(
        this.forgetPasswordDetail.controls['emailId'].valid )
    return true;
    this.forgetPasswordDetail.markAllAsTouched();
    return false;
  }

  forgetPassword(){
    if(!this.isFormValid())
    return;
  var forgetPasswordDTO = {
    'emailId': this.forgetPasswordDetail.controls['emailId'].value
  };
  this.userService.getForgetPassword(forgetPasswordDTO).subscribe((response:any) => {
    console.log("Response is ====> " + response);
    if(response.statusCode == 200 ){
      this.toastr.success(response.message);
      // this.router.navigate(["/home"]);  
    }
  
  })
  }
}
