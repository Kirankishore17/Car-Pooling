import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class LoginStatusService {
  
  status:boolean = false;

  constructor() { }

  setLoginStatus(status: boolean) {
    this.status = status;
  }

  getLoginStatus(){
    return this.status;
  }

}
