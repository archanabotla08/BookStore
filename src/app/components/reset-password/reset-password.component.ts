import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.scss'],
})
export class ResetPasswordComponent implements OnInit {
  resetPasswordDetail!: FormGroup;
  token: any;
  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private router: Router,
    private toastr: ToastrService,
    private activatedRoute: ActivatedRoute
  ) {

    this.token = this.activatedRoute.snapshot.params.token;
    console.log(this.token);
  }

  ngOnInit(): void {
    this.resetPasswordDetail = this.formBuilder.group({
      newPassword: ['', Validators.compose([Validators.required,
      Validators.pattern('^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$')])],
      confirmPassword: ['', Validators.compose([Validators.required,
      Validators.pattern('^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$')])],
    });
  }
  //new password form validation
  isFormValid(): boolean {
    if (this.resetPasswordDetail.controls['newPassword'].valid &&
      this.resetPasswordDetail.controls['confirmPassword'].valid)
      return true;
    this.resetPasswordDetail.markAllAsTouched();
    return false;
  }
  //reset password 
  resetPassword() {
    if (!this.isFormValid())
      return;
    var resetPasswordDTO = {
      'newPassword': this.resetPasswordDetail.controls['newPassword'].value,
      'confirmPassword': this.resetPasswordDetail.controls['confirmPassword'].value,

    };
    this.userService.getResetPassword(resetPasswordDTO, this.token).subscribe((response: any) => {
      if (response.statusCode == 200) {
        this.toastr.success(response.message);
        this.router.navigate(["/login"]);
      } else {
        this.toastr.error(response.message);
      }
    }, err => {
    })
  }
}
