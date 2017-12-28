import { Component, OnInit } from '@angular/core';
import {LoginComponent} from "../login/login.component";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  constructor(private  loginComponent: LoginComponent) { }

  ngOnInit() {
    this.loginComponent.toRegistration();
  }

}
