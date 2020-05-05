import { Component, OnInit } from '@angular/core';
import { RestDataService } from '../service/rest-data.service';
import { DriverInfo } from '../dashboard/dashboard.component';


export class UserInfo {
  constructor(
    public name,
    public number,
    public gender,
    public time,
    public source,
    public destination,
    public date
  ){}
}

@Component({
  selector: 'app-my-ride',
  templateUrl: './my-ride.component.html',
  styleUrls: ['./my-ride.component.css']
})
export class MyRideComponent implements OnInit {
  public driverDetails:DriverInfo[]
  public rideDetails
  public group

  constructor(
    private service:RestDataService
  ) { }

  ngOnInit(): void {
    this.service.getDriverInfo(Number(sessionStorage.getItem('user'))).subscribe(
      data => {
        console.log('myride\nlength: ' + data.length);
        this.driverDetails = data
        // console.log(data);
      }
    );
    // console.log(this.driverDetails.);

    this.service.getRiderInfo(Number(sessionStorage.getItem('user'))).subscribe(
      data =>{
        console.log('rider info : ' + data);
        this.rideDetails = data;
        console.log(typeof this.rideDetails)
        console.log(this.rideDetails)

        let map = new Map();
        this.rideDetails.forEach((val) => {
          console.log(val);
          var source = val.source
          var destination = val.destination
          var date = val.date
          var time = val.source
          var key = source+destination+date+time;
          console.log(key)
          if(map.has(key)){
            map.set(key, map.get(key).push(val))
          }else{
            map.set(key, [val])
          }
        });
        console.log(map);
      }
    );
    this.group = []
  }

}
