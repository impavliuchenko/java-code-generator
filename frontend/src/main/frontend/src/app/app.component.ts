import {Component} from '@angular/core';
import {CarService} from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  constructor (private carService: CarService){ }

}
