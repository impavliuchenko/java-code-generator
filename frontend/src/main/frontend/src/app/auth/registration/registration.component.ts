import { Component, OnInit } from '@angular/core';
import {Response} from '@angular/http'
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../shared/service/auth.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  form: FormGroup;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      'username': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators. required, Validators.minLength(4)]),
      'name': new FormControl(null, [Validators.required]),
      'nickName': new FormControl(null, [Validators.required]),
      'dateBirthday' : new FormControl(null, [Validators.required]),
      'agree' : new FormControl(false, [Validators.requiredTrue])
    });
  }

  onSubmit(){
    const formData = this.form.value;
    this.authService.onRegistration(formData).subscribe((response: Response) => {
      console.log(response);
    });

  }

}
