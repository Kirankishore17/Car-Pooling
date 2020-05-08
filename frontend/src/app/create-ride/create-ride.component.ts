import { Component, OnInit } from '@angular/core';
import { RestDataService } from '../service/rest-data.service';
import { Router } from '@angular/router';
import { DashboardComponent } from '../dashboard/dashboard.component';

export class Driver {
  constructor(
    public id: number,
    public time: string,
    public seats: number,
    public source: string,
    public destination: string,
    public vehicleNumber: string,
    public date: string
  ) { }
}


@Component({
  selector: 'app-create-ride',
  templateUrl: './create-ride.component.html',
  styleUrls: ['./create-ride.component.css']
})

export class CreateRideComponent implements OnInit {

  constructor(
    private service: RestDataService,
    private router: Router
  ) {
  }

  public time: string = ''
  public seats: number = 0
  public source: string = ''
  public destination: string = ''
  public vehicleNumber: string = ''
  public date: string = ''

  options: string[] = ["Adyar", "Anna Nagar", "Besant Nagar", "Egmore", "George Town", "Kodambakkam",
    "Mylapore", "Perambur", "Nungambakkam", "Vadapalani", "Adambakkam", "Alandur", "Alwarpet",
    "Ambattur", "Ambattur Industrial Estate", "Aminjikarai", "Anna Nagar", "Anna Salai",
    "Arcot Road", "Arumbakkam", "Ashok Nagar", "Avadi", "Ayanavaram", "Broadway",
    "Chepauk", "Chetpet", "Chintadripet", "CIT Nagar", "East Coast Road", "Ennore",
    "Gandhi Nagar", "Gopalapuram", "Guindy", "Guindy Industrial Estate", "IIT Madras",
    "Indira Nagar", "Injambakkam", "Jafferkhanpet", "Kamaraj Nagar", "Kandanchavadi",
    "Karapakkam", "Kattupakkam", "Kilkattalai", "Kilpauk", "Kilpauk Garden", "KK Nagar",
    "Korattur", "Kottivakkam", "Kotturpuram", "Koyambedu", "Little Mount", "Madhavaram",
    "Madipakkam", "Maduravoyal", "Mambalam", "Mandaveli", "Medavakkam", "Meenambakkam",
    "Mogapper", "Mount Road", "Mylapore", "Nandambakkam", "Nandanam", "Neelankarai",
    "North Usman Road", "Old Mahabalipuram Road", "Palavakkam", "Pallavaram", "Pallikaranai",
    "Pammal", "Park Town", "Parrys", "Perungudi", "Poonamalle High Road", "Porur", "Purasavakkam",
    "Purasavakkam High Road", "RA Puram", "Ramapuram", "Royapettah", "Royapuram", "Saidapet",
    "Saligramam", "Santhome", "Selaiyur", "Shastri Nagar", "Sholinganallur", "Sowcarpet",
    "Spencer Plaza", "St Thomas Mount", "T. Nagar", "Taramani", "Teynampet", "Tharamani",
    "Thiruvanmiyur", "Tiruvottiyur", "Thuraipakkam", "Thousand Lights", "Thiyagaraya Nagar",
    "Thiruvallikeni", "Triplicane", "Velachery", "Villivakkam", "Virtusa DLF", "Virtusa OMR", "Washermanpet"].sort();

  ngOnInit() {
  }

  onCreate() {
    if (
      this.checkLocation() &&
      this.checkDate() &&
      this.checkSeats() &&
      this.checkTime() &&
      this.checkVehicleNumber()
    ) {
      var dd = (new Date(this.date).getDate())
      var mm = (new Date(this.date).getMonth()) + 1
      var yyyy = (new Date(this.date).getFullYear())
      var rideDate = dd + "/" + mm + "/" + yyyy;

      this.service.saveDriver(new Driver(Number(sessionStorage.getItem('user')),
        this.time, this.seats, this.source, this.destination, this.vehicleNumber, rideDate)).subscribe()
      this.router.navigate(['myride']);
    } else {
      alert('try again')
    }

  }

  checkTime() {
    if (this.time === '')
      return false;
    return true;
  }

  checkVehicleNumber() {
    this.vehicleNumber = this.vehicleNumber.toUpperCase();
    let format = /^[A-Z]{2}[0-9]{1,2}[A-Z]{1,2}[0-9]{4}$/
    if (!format.test(this.vehicleNumber))
      return false;
    if (this.vehicleNumber === '')
      return false;
    return true;
  }

  checkDate() {
    if (this.date === '')
      return false;
    let d = new Date()
    d.setDate(d.getDate() - 1)
    if (new Date(this.date) < d)
      return false;
    return true;
  }

  checkLocation() {
    if (this.source === '' || this.destination === '' || this.source === this.destination)
      return false;
    return true;
  }

  checkSeats() {
    if (this.seats === 0 || this.seats > 7 || this.seats < 0)
      return false;
    return true;
  }

}
