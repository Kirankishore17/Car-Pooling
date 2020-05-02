import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { LoginStatusService } from './login-status.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private status:LoginStatusService) { }

  canActivate(route:ActivatedRouteSnapshot, state: RouterStateSnapshot){
    return this.status.getLoginStatus();
  }
  
}
