import { Component, OnInit } from '@angular/core';
import {Response} from "@angular/http";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../shared/service/auth.service";
import {User} from "../../shared/model/user.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form: FormGroup;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.authService.logOut();
    window.localStorage.clear();
    this.form = new FormGroup({
      'email': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators. required, Validators.minLength(4)])
    });
  }

  onSubmit(){
    const formData = this.form.value;
    this.authService.onLogin(formData)
      .subscribe((response: Response) => {
        const token : string = response.headers.get('X-Auth-Token');
        const user : User = this.authService.decodeOptions(response['_body']);
        window.localStorage.setItem('token', token);
        window.localStorage.setItem('user', JSON.stringify(user));
        this.authService.logIn();
      });
    this.router.navigate(["/system"]);

  }

  toRegistration(){
    window.localStorage.clear();
  }
}
