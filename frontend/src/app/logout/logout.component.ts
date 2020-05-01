import { Component, OnInit } from '@angular/core';
import { LoginStatusService } from '../service/login-status.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private loginStatus:LoginStatusService) { }

  ngOnInit(): void {
    this.loginStatus.setLoginStatus(false);
    sessionStorage.clear();
    
  }

}
