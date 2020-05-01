import { Component, OnInit } from '@angular/core';
import { LoginStatusService } from '../service/login-status.service';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(public loginStatus:LoginStatusService) { }

  ngOnInit(): void {

  }

}
