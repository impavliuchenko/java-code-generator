import {Component} from '@angular/core';
import {CarService} from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'app';
  cars = [];

  constructor (private carService: CarService){ }

  onClickButton(){
    this.carService.getCars()
      .subscribe((response) => {
        this.cars = response.json();
        console.log(response);
      });
  }
}
