import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import { SystemComponent } from './system.component';
import {SystemRoutingModule} from "./system-routing.module";
import {SharedModule} from "../shared/shared.module";
import { DiagramsComponent } from './diagrams/diagrams.component';
import { AccountComponent } from './account/account.component';
import { ExploreComponent } from './explore/explore.component';

@NgModule({
  declarations: [SystemComponent, DiagramsComponent, AccountComponent, ExploreComponent],
  imports:[
    CommonModule,
    SystemRoutingModule,
    SharedModule
  ]
})
export class SystemModule {}
