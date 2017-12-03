import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

@Injectable()
export class CarService {

  constructor(private http: Http) {
  }

  getCars() {
    return this.http.get("https://java-code-generator.herokuapp.com/api/hello");
  }
}
