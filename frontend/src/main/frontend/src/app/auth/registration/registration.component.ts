import { Component, OnInit } from '@angular/core';
import {Response} from '@angular/http'
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../shared/service/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  form: FormGroup;

  constructor(private authService: AuthService,
              private router: Router
  ) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      'username': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators. required, Validators.minLength(4)]),
      'name': new FormControl(null, [Validators.required]),
      'dateBirthday' : new FormControl(null, [Validators.required]),
      'agree' : new FormControl(false, [Validators.requiredTrue])
    });
  }

  onSubmit(){
    const formData = this.form.value;
    this.authService.onRegistration(formData)
      .subscribe((response: Response) => {
        console.log(response);
        this.router.navigate(["/login"], {
          queryParams: {
            username: formData.username,
            password: formData.password
          }
        });
    });
  }
}
