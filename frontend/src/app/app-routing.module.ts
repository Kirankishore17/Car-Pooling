import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { LogoutComponent } from './logout/logout.component';
import { RouteGuardService } from './service/route-guard.service';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CreateRideComponent } from './create-ride/create-ride.component';


const routes: Routes = [
  {path:'', component:HomeComponent},  
  {path:"login", component:LoginComponent},  
  {path:"logout", component:LogoutComponent, canActivate:[RouteGuardService]},  
  {path:"signup", component:SignupComponent},  
  {path:"dashboard", component:DashboardComponent},  
  {path:"driver", component:CreateRideComponent, canActivate:[RouteGuardService]},  
  {path:"**", component:HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
