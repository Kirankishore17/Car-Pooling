import { Component, OnInit } from '@angular/core';
import { RestDataService } from '../service/rest-data.service';
import { Router } from '@angular/router';

export class Employee {
  constructor(
  public id:number,
  public name:string,
  public number:number,
  public gender:string,
  public email:string,
  public password:string
  ){

  }
}

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  public name:string = ''
  public password:string = ''
  public number:number 
  public gender:string = ''
  public email:string = ''
  public confirmPassword:string = ''

  public employee:Employee

  public flag: boolean;
  public result:string
  emailStatus: boolean;
  
  // public emailStatus: boolean;

  constructor(private service:RestDataService, private router:Router) { }

  ngOnInit(): void {
  }

  onRegister(){
    console.log('inside onregister:--')
    this.employee = new Employee(0, this.name, this.number, this.gender, this.email, this.password )
    this.service.saveEmployee(this.employee).subscribe(
      //data => console.log('data: ' + this.employee + ' ' + data),
      response => {
        console.log('response: ' + response)
        if(response === null)
          console.log('response null, new user')
        else
          console.log('already exist try again')
      }
    );
    // console.log(this.name + " " + this.checkName())
    // console.log(this.number + " " + this.checkNumber())
    // console.log(this.email + " " + this.checkEmail() + " | " + this.emailStatus)
    // console.log(this.password + " " + this.checkPassword())    
  }

  checkPassword(){
    if(this.password === this.confirmPassword)
      return true;
    return false;
  }

  checkName(){
    this.name.replace(" ", "_")
    var format = /[!@#$%^&*()+\-=\[\]{};':"\\|,.<>\/?]+/;
    if(!format.test(this.name)){
      return true;
    } else {
      return false;
    }
  }

  checkNumber(){
    if(this.number.toString().length === 10)
      return true;
    return false;
  }

  async checkEmail(){
    this.emailStatus = false;
     if(this.email.indexOf("@") !== -1){
      this.service.checkEmail(this.email)
      .subscribe(
        response => {
        console.log('response: ' + response)
        if(response === null){
          this.emailStatus = true;
          console.log('new email' + response)
        }
        else{
          this.emailStatus = false;
          console.log('already exist' + response)
        }
        }
      )
      
    }else{
      console.log('check @')
    }  
    return this.emailStatus;
  }

  // onRegister(){
    // console.log('register function logs:');
    // // console.log(this.email);
    // // console.log(this.name);
    // if( this.isSignUpValid() ){
    //   this.employee = new Employee(0, this.name, this.number, this.gender, this.email, this.password )
    //   this.service.saveEmployee(this.employee).subscribe(
    //     data => console.log(this.employee)
    //   );
      
    // }else {
    //   console.log('inside else')
    //   this.router.navigate(['signup']);
    // }
  // }

  // isSignUpValid():boolean {
  //   this.flag = true;
  //   if(
  //     (this.password !== this.confirmPassword) ||
  //     (this.returnResponse()) ||
  //     (this.email.indexOf("@") < 0 )
  //     ){
  //     this.flag = false;
  //   }
  //   console.log('flag should be false for mail@gmail: ' + this.flag)
  //   console.log('---------------------> ' + this.service.checkEmail(this.email).subscribe())
  //   // console.log('password: ' + this.password !== this.confirmPassword)
  //   console.log('email response function: ' + this.returnResponse())
  //   // console.log('index@: ' + this.email.indexOf("@") )
  //   return this.flag;
  // }
  // returnResponse(): boolean {
  //   this.service.checkEmail(this.email).subscribe(response => {
  //     console.log('response from call ' + response)
  //     if(response === null)
  //         this.emailStatus =  true;
  //     else
  //         this.emailStatus = false;
  //   } )
  //   return this.emailStatus;
  // }
}
