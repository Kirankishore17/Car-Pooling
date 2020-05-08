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
  ) { }
}

@Component({
  selector: 'app-my-ride',
  templateUrl: './my-ride.component.html',
  styleUrls: ['./my-ride.component.css']
})
export class MyRideComponent implements OnInit {
  public driverDetails: DriverInfo[]
  public rideDetails
  public map: Map<any, any>;
  public group

  constructor(
    private service: RestDataService
  ) { }

  ngOnInit(): void {
    let keys = [1];

    this.service.getDriverInfo(Number(sessionStorage.getItem('user'))).subscribe(
      data => {
        this.driverDetails = data
      }
    );

    this.service.getRiderInfo(Number(sessionStorage.getItem('user'))).subscribe(
      data => {
        this.rideDetails = data;
        // console.log(typeof this.rideDetails)

        this.map = new Map();
        this.rideDetails.forEach((val) => {
          var source = val.source
          var destination = val.destination
          var date = val.date
          var time = val.time
          var key = source + destination + date + time;
          if (this.map.has(key)) {
            // console.log('map has key')
            var p = this.map.get(key)
            p.name.push(val.name)
            p.number.push(val.number)
            p.gender.push(val.gender)
            p.length = p.length + 1;
            // console.log(p.name)
            // console.log(this.map)

          } else {
            // console.log('new key set')
            this.map.set(key, {
              "source": source, "destination": destination, "date": date, "time": time,
              "name": [val.name], "gender": [val.gender], "number": [val.number], "length": 1
            })
            //keys.push(String(key));
            keys.push(8);
            // console.log(this.map);
          }
        });
        // console.log('outside loop');
        // console.log(this.map);
      }
    );
    this.group = []
    // console.log('keys: ' + keys)
    for (let eachKey of keys) {
      if (this.map.has("IIT MadrasRA Puram6/5/2020IIT Madras")) {
        this.group.push(this.map.get("IIT MadrasRA Puram6/5/2020IIT Madras"))
        // console.log(eachKey)
      }
    }
    // console.log('group: ' + this.group);
  }

}
