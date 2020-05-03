import { Component, OnInit } from '@angular/core';
import { RestDataService } from '../service/rest-data.service';
import { Router } from '@angular/router';

export class Driver {
  constructor(
  public id:number,
  public time:string,
  public seats:number,
  public source:string,
  public destination:string,
  public vehicleNumber:string,
  public date:string  
  ){}
}


@Component({
  selector: 'app-create-ride',
  templateUrl: './create-ride.component.html',
  styleUrls: ['./create-ride.component.css']
})

export class CreateRideComponent implements OnInit {

  constructor(
    private service:RestDataService,
    private router:Router
    ) {
     }
    
     public time:string = ''
     public seats:number = 0
     public source:string = ''
     public destination:string = ''
     public vehicleNumber:string = ''
     public date:string = ''

  options: string[] = ["Adyar", "Anna Nagar", "Besant Nagar", "Egmore", "George Town", "Kodambakkam",
    "Mylapore", "Perambur", "Nungambakkam", "Vadapalani", "Adambakkam", "Alandur", "unagar", "Alwarpet",
    "Ambattur", "Ambattur Industrial Estate", "Ambattur OT", "Aminjikarai", "Anna Nagar", "Anna Salai",
    "Arcot Road", "Arumbakkam", "Ashok Nagar", "Avadi", "Ayanavaram", "Ayyappanthangal", "Broadway",
    "Chepauk", "Chetpet", "Chintadripet", "Choolaimedu", "CIT Nagar", "East Coast Road", "Ennore", 
    "Gandhi Nagar", "Gopalapuram", "Greams Road", "Guindy", "Guindy Industrial Estate", "IIT Madras", 
    "Indira Nagar", "Injambakkam", "Jafferkhanpet", "Jawahar Nagar", "Kamaraj Nagar", "Kandanchavadi", 
    "Karapakkam", "Kattupakkam", "Kilkattalai", "Kilpauk", "Kilpauk Garden", "KK Nagar", "Kolathur", 
    "Korattur", "Kottivakkam", "Kotturpuram", "Kovilambakkam", "Koyambedu", "Little Mount", "Madhavaram", 
    "Madipakkam", "Maduravoyal", "Mambalam", "Mandaveli", "Mandavelipakkam", "Medavakkam", "Meenambakkam", 
    "Mogapper", "Mount Road", "Mylapore", "Nandambakkam", "Nandanam", "Nelson Manickam Road", "New Washermanpet", "Neelankarai", "North Usman Road", "Nungambakkam High Road", "Old Mahabalipuram Road", "Otteri", "Padi", "Palavakkam", "Pallavaram", "Pallikaranai", "Pammal", "Park Town", "Parrys", "Pattalam", "Pazhavanthangal", "Perambur Barracks Road", "Perungudi", "Poonamalle High Road", "Porur", "Pudupet", "Purasavakkam", "Purasavakkam High Road", "RA Puram", "Rajaji Salai", "Ramapuram", "Royapettah", "Royapuram", "Saidapet", "Saligramam", "Santhome", "Selaiyur", "Shastri Nagar", "Shenoy Nagar", "Sholinganallur", "Sholinganallur", "Sowcarpet", "Spencer Plaza", "St Thomas Mount", "T. Nagar", "Thillai Ganga Nagar", "Taramani", "Teynampet", "Tharamani", "Thirumangalam", "Thiruvanmiyur", "Tiruvottiyur", "Thuraipakkam", "Thousand Lights", "Thiyagaraya Nagar", "Tirumullaivayal", "Thiruvallikeni", "Tiruverkadu Road", "Triplicane", "Valasaravakkam", "Velachery",
    "Villivakkam", "Virugambakkam", "Virtusa DLF", "Virtusa OMR", "Vyasarpadi", "Washermanpet"].sort();

  ngOnInit() {
  }

  onCreate(){
    if(
      this.checkLocation() &&
      this.checkDate() &&
      this.checkSeats() &&
      this.checkTime() &&
      this.checkVehicleNumber()
    ){
      var dd = (new Date(this.date).getDate())
      var mm = (new Date(this.date).getMonth())
      var yyyy = (new Date(this.date).getFullYear())
      var rideDate = dd + "/" + mm + "/" + yyyy;  

      this.service.saveDriver(new Driver(Number(sessionStorage.getItem('user')),
        this.time, this.seats, this.source, this.destination, this.vehicleNumber, rideDate)).subscribe()

      console.log('data sent')
    }else{
      alert('try again')
    }

  }

  checkTime(){
    if(this.time === '')
      return false;
    return true;
  }

  checkVehicleNumber(){
    this.vehicleNumber = this.vehicleNumber.toUpperCase();
    let format = /^[A-Z]{2}[0-9]{1,2}[A-Z]{1,2}[0-9]{4}$/
    if(!format.test(this.vehicleNumber))
      return false;
    if(this.vehicleNumber === '')
      return false;
    return true;
  }

  checkDate(){
    console.log(this.date)
    if(this.date === '')
      return false;
    if(new Date(this.date) < new Date())
      return false;
    return true;
  }

  checkLocation(){
    if(this.source === '' || this.destination === '' || this.source === this.destination)
      return false;
    return true;
  }

  checkSeats(){
    if(this.seats === 0 || this.seats > 6 || this.seats < 0)
      return false;
    return true;
  }

}
