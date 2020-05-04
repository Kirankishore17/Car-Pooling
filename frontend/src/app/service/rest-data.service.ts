import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Employee } from '../signup/signup.component';
import { Driver } from '../create-ride/create-ride.component';
import { DriverInfo } from '../dashboard/dashboard.component';

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

  loginRequest(email:string, password:string) {
    // return this.http.get<Trip>('http://localhost:8080');
    return this.http.get(`http://localhost:8080/login?email=${email}&password=${password}`);
  }

  // checkEmail(email:string) {
  //   // return this.http.get<Trip>('http://localhost:8080');
  //   return this.http.get<Employee>(`http://localhost:8080/mail?email=${email}`);
  // }

  saveEmployee(employee:Employee) {
    return this.http.post<Employee>('http://localhost:8080/employee/new',employee);
  }

  saveDriver(driver:Driver) {
    return this.http.post<Driver>('http://localhost:8080/driver',driver);
  }

  getAllRides() {
    return this.http.get<DriverInfo[]>('http://localhost:8080/allrides');
  }

  joinRide(driverId: number, userId: number, dateTime:string) {
    console.log(driverId + " " +  userId + " " + dateTime +  " sent ")
    return this.http.get(`http://localhost:8080/joinride?driverid=${driverId}&userid=${userId}&date=${dateTime}`);
  }
}
