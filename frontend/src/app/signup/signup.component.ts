import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  name = '';
  password = '';
  number = '';
  confirmPassword = '';
  gender = '';
  email = '';

  constructor() { }

  ngOnInit(): void {
  }

  onRegister(){
    console.log(this.gender) ;
  }
}
