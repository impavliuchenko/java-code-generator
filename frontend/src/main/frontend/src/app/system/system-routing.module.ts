import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SystemComponent} from "./system.component";
import {AuthGuardService} from "../shared/service/guard/auth-guard.service";
const systemRoutes: Routes = [
  {path: 'system', component: SystemComponent, canActivate: [AuthGuardService]}
];

@NgModule({
  imports: [RouterModule.forChild(systemRoutes)],
  exports: [RouterModule]
})
export class SystemRoutingModule { }
