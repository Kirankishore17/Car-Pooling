import { Component, OnInit } from '@angular/core';
import { RestDataService } from '../service/rest-data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email:string = '';
  password:string = ''

  constructor(private service:RestDataService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.email + " " + this.password);
    this.service.loginRequest().subscribe(
      response => {console.log(response) 
        if(response === null)
          console.log('response null') 
      },
      error => console.log(error)
    );
  }

}
