import { Component, OnInit } from '@angular/core';
import {Response} from "@angular/http";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../shared/service/auth.service";
import {User} from "../../shared/model/user.model";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {isNullOrUndefined} from "util";
import {Message} from "../../shared/model/message.model";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup;
  message: Message;

  constructor(
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {

    this.message = new Message('danger', '');

    let username: string = null;
    let password: string = null;

    this.route.queryParams.subscribe((params: Params) => {
      if (!isNullOrUndefined(params['username'])) {
          username = params['username'];
          password = params['password'];
      }
    });

    this.authService.logOut();
    window.localStorage.clear();

    this.form = new FormGroup({
      'email': new FormControl(username, [Validators.required, Validators.email]),
      'password': new FormControl(password, [Validators. required, Validators.minLength(4)])
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
        this.router.navigate(["/system/diagrams"]);
        },
        (error => {
          this.showMessage('Данные неверные!')
        }));
  }

  toRegistration(){
    window.localStorage.clear();
  }

  showMessage(text: string = '', type: string = 'danger') {
    this.message = new Message(type, text);
    window.setTimeout(() => {
      this.message.text = ''
    }, 3000);
  }
}
