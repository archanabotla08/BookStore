import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './components/authGuard/auth.guard';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './components/reset-password/reset-password.component';
import { CartComponent } from './pages/cart/cart.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { SuccessPageComponent } from './pages/success-page/success-page.component';

const routes: Routes = [
  { path: '', component: HomeComponent, },
  { path: '', redirectTo: "/login", pathMatch: 'full' },
  { path: 'registration', component: RegistrationComponent, },
  { path: 'login',component: LoginComponent},
  { path: 'forgot', component: ForgotPasswordComponent,},
  { path: 'resetPassword/:token',component: ResetPasswordComponent},
  { path: 'home', component: HomeComponent,},
  { path: 'cart', component: CartComponent,canActivate: [AuthGuard],},
  { path: 'success',component: SuccessPageComponent,canActivate: [AuthGuard],},
 
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
