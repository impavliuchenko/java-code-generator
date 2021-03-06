import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {User} from "../model/user.model";
import {Observable} from "rxjs/Observable";
import {JwtHelper} from "angular2-jwt";

@Injectable()
export class AuthService {

  private isLoggedIn = false;

  constructor(private http: Http){ }

  isAuth(){
    return this.isLoggedIn;
  }

  logIn(){
    this.isLoggedIn = true;
  }

  logOut(){
    this.isLoggedIn = false;
  }

  onLogin(user: User) : Observable<Response> {
    return this.http.post('http://localhost:4200/api/login', user);
  }

  onRegistration(user: User) : Observable<Response> {
    console.log(user);
    return this.http.post('http://localhost:4200/api/registration', user);
  }

  decodeOptions(opt: string) {
    const jwtHelper: JwtHelper = new JwtHelper();
    return jwtHelper.decodeToken(opt);
  }
}
