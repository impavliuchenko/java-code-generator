import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {CarService} from './app.service';
import {HttpModule} from '@angular/http';
import {AppRoutingModule} from "./app-routing.module";
import {AuthModule} from "./auth/auth.module";
import {SystemModule} from "./system/system.module";
import {UserService} from "./shared/service/user.service";
import {AuthService} from "./shared/service/auth.service";
import {AuthGuardService} from "./shared/service/guard/auth-guard.service";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    AuthModule,
    SystemModule,
    AppRoutingModule
  ],
  providers: [CarService, UserService, AuthService, AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
