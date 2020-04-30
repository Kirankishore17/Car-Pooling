import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Employee } from '../signup/signup.component';

export class Trip {
  constructor(public driverId:number, public userId:number, public date:string){}
}


@Injectable({
  providedIn: 'root'
})
export class RestDataService {

  constructor(
    private http:HttpClient
  ) { }

  loginRequest() {
    // return this.http.get<Trip>('http://localhost:8080');
    return this.http.get('http://localhost:8080/login?email=mail&password=p');
  }

  checkEmail(email:string) {
    // return this.http.get<Trip>('http://localhost:8080');
    return this.http.get<Employee>(`http://localhost:8080/mail?email=${email}`);
  }

  saveEmployee(employee:Employee) {
    console.log('received ' + employee.name)
    return this.http.post<Employee>('http://localhost:8080/employee/new',employee);
  }

}
