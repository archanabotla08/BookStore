import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/User';

@Component({
  selector: 'app-signform',
  templateUrl: './signform.component.html',
  styleUrls: ['./signform.component.scss']
})
export class SignformComponent implements OnInit {

  userDetail!: FormGroup;
  
  constructor(
    private formBuilder: FormBuilder,
    private userService : UserService,
    private router: Router,
    private toastr : ToastrService
  ) { 
   
  }

  ngOnInit(): void {
    this.userDetail = this.formBuilder.group({
      fullName: ['', Validators.compose([Validators.required, Validators.minLength(2),
      Validators.pattern('^[A-Z][a-zA-Z\\s]{2,}$')])],
      mobileNumber: ['',  Validators.compose([Validators.required,
        Validators.pattern('^[6-9][0-9]{9}$')])],
      emailId: [null,  Validators.compose([Validators.required,
        Validators.pattern('')])],
      password: ['', Validators.compose([Validators.required,
        Validators.pattern('^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$')])],
    });
  }

  isFormValid(): boolean {
    if(this.userDetail.controls['fullName'].valid &&
        this.userDetail.controls['mobileNumber'].valid &&
        this.userDetail.controls['emailId'].valid &&
        this.userDetail.controls['password'].valid)
    return true;
    this.userDetail.markAllAsTouched();
    return false;
  }

  register() {
    if(!this.isFormValid())
      return;
    var registrationDTO = {
      'fullName': this.userDetail.controls['fullName'].value,
      'emailId': this.userDetail.controls['emailId'].value,
      'mobileNumber': this.userDetail.controls['mobileNumber'].value,
      'password': this.userDetail.controls['password'].value
    };
    console.log("USer dto in Register()", registrationDTO)
    this.userService.getUserrRegistration(registrationDTO).subscribe((response:any) => {
     if(response.statusCode == 201) {
       this.toastr.success(response.message);
     }else{
       this.toastr.error(response.message);
     }
      
      console.log("Response is ====> " + response);
    })
  }

}
