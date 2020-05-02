import { Component, OnInit } from '@angular/core';
import { RestDataService } from '../service/rest-data.service';
import { Router } from '@angular/router';
import { LoginStatusService } from '../service/login-status.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email:string = '';
  password:string = ''

  constructor(
    private service:RestDataService,
    private router:Router,
    private loginStatus:LoginStatusService) { }

  ngOnInit(): void {
    this.loginStatus.setLoginStatus(false);
  }

  onLogin(){
    console.log(this.checkLogin());
    if(this.checkLogin()){
      this.service.loginRequest(this.email, this.password).subscribe(
        response => {console.log(response) 
          if(response === null){
            this.loginStatus.setLoginStatus(false);
            alert('invalid email/password')
            
          }
          else{
            this.loginStatus.setLoginStatus(true);
            sessionStorage.clear();
            sessionStorage.setItem('user', response.toString())
            console.log('navigated inside db call' )
            this.router.navigate(['dashboard']);
          } 
        },
        error => console.log(error)
      );
    }
    else {
      this.router.navigate['login']
      this.email = ''
      this.password = ''
      console.log('navigated')
      alert('Invalid entry')
    }    
  }

  checkLogin(){
    var format = /[!#$%^&*()+\-=\[\]{};':"\\|,<>\/?]+/;
    if(format.test(this.email))
      return false;
    if(this.email === '' || this.password === '')
      return false;
    // if(this.email.indexOf("@") === -1 || this.email.indexOf(".") === -1)
    //   return false;
    if(this.email.indexOf(" ") !== -1 || this.password.indexOf(" ") !== -1)
      return false;
    return true;
  }

}
