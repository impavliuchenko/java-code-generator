import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SystemComponent} from "./system.component";
import {AuthGuardService} from "../shared/service/guard/auth-guard.service";
import {DiagramsComponent} from "./diagrams/diagrams.component";
import {AccountComponent} from "./account/account.component";
import {ExploreComponent} from "./explore/explore.component";
const systemRoutes: Routes = [
  {path: 'system', component: SystemComponent, canActivate: [AuthGuardService], children: [
    {path: 'diagrams', component: DiagramsComponent},
    {path: 'account', component: AccountComponent},
    {path: 'explore', component: ExploreComponent},
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(systemRoutes)],
  exports: [RouterModule]
})
export class SystemRoutingModule { }
