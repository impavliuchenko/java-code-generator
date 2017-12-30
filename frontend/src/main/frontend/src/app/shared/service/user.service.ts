import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class UserService {

  constructor(private http: Http){ }

  checkEmail(username: string) : Observable<Response> {
    const params = new URLSearchParams();
    params.set('email', username);
    return this.http.post('http://localhost:4200/api/registration/checkEmail?email='+username, username);
  }
}
