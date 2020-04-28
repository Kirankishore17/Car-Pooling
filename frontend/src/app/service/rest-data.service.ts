import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class RestDataService {

  constructor(
    private http:HttpClient
  ) { }

  loginRequest() {
    console.log( this.http.get('http://localhost:8080').subscribe(
      response => console.log(response)
    ) );
  }
}
