import { Component, OnInit } from '@angular/core';
import { RestDataService } from '../service/rest-data.service';
import { Router } from '@angular/router';

export class Employee {
  constructor(
    public id: number,
    public name: string,
    public number: string,
    public gender: string,
    public email: string,
    public password: string
  ) {

  }
}

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  public name: string = ''
  public password: string = ''
  public number: string = ''
  public gender: string = ''
  public email: string = ''
  public confirmPassword: string = ''

  public employee: Employee

  constructor(private service: RestDataService, private router: Router) { }

  ngOnInit(): void {
  }

  onRegister() {
    // console.log('inside onregister:--')
    if (
      this.checkName() &&
      this.checkNumber() &&
      this.checkEmail() &&
      this.checkPassword() &&
      this.checkGender()
    ) {
      this.employee = new Employee(0, this.name.toUpperCase(), this.number, this.gender, this.email, this.password)
      this.service.saveEmployee(this.employee).subscribe(
        //data => console.log('data: ' + this.employee + ' ' + data),
        response => {
          // console.log('response: ' + response)
          if (response === null) {
            // console.log('new user created')
            this.router.navigate(['dashboard'])
          }
          else {
            alert('email already exist try again')
          }
        }
      );
    }
    else {
      alert('invalid entry')
      //console.log(this.name + " " + this.checkName())
      // console.log(this.number + " " + this.checkNumber() + " ")
      //console.log(this.email + " " + this.checkEmail() )
      //console.log(this.password + " " + this.checkPassword()) 
    }


  }

  checkPassword() {
    if (this.password === this.confirmPassword)
      return true;
    return false;
  }

  checkName() {
    this.name.replace(/ /g, "_")
    var format = /[!@#$%^&*()+\-=\[\]{};':"\\|,.<>\/?0-9]+/;
    if (!format.test(this.name)) {
      return true;
    } else {
      return false;
    }
  }

  checkNumber() {
    if (String(this.number).length === 10)
      return true;
    return false;
  }

  checkEmail() {
    var format = /[!#$%^&*()+\-=\[\]{};':"\\|,<>\/?]+/;
    if (format.test(this.email))
      return false;
    if (this.email === '' || this.email.indexOf(" ") !== -1)
      return false;
    if (this.email.indexOf("@") === -1 || this.email.indexOf(".") === -1)
      return false;
    return true;
  }

  checkGender() {
    if (this.gender === '')
      return false;
    return true;
  }

}
