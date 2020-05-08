import { Component, OnInit } from '@angular/core';
import { RestDataService } from '../service/rest-data.service';
import { MatTableDataSource } from '@angular/material/table';
import { LoginStatusService } from '../service/login-status.service';
import { Router } from '@angular/router';

export class DriverInfo {
  constructor(
    public id: number,
    public name: string,
    public number: string,
    public time: string,
    public source: string,
    public destination: string,
    public vehicleNumber: string,
    public date: string,
    public key: number
  ) { }
}

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})


export class DashboardComponent implements OnInit {

  dataSource

  constructor(
    private service: RestDataService,
    public loginStatus: LoginStatusService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.refreshTable();
  }

  refreshTable(): void {
    this.service.getAllRides().subscribe(
      data => {
        this.dataSource = new MatTableDataSource(data);
      }
    );

  }
  displayedColumns: string[] = ['name', 'number', 'vehicleNumber', 'source',
    'destination', 'date', 'time', 'action'];


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  joinRide(driver: DriverInfo) {
    if (this.loginStatus.getLoginStatus()) {
      // console.log(driver.id + " is driverId. user loggedin");
      if (driver.id === Number(sessionStorage.getItem('user'))) {
        // console.log('same')
        alert("Can't join")
      }
      else {
        console.log('user')
        var driverId = driver.id;
        var userId = Number(sessionStorage.getItem('user'));
        // var dateTime = String(driver.date).concat(driver.time);
        this.service.joinRide(driverId, userId, driver.date, driver.key, driver.time).subscribe();
        alert("Joined successfully")
      }
    }
    else {
      this.router.navigate(['login']);
    }
  }
}
