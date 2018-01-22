import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import { SystemComponent } from './system.component';
import {SystemRoutingModule} from "./system-routing.module";
import {SharedModule} from "../shared/shared.module";
import { DiagramsComponent } from './diagrams/diagrams.component';
import { AccountComponent } from './account/account.component';
import { ExploreComponent } from './explore/explore.component';
import { SidebarComponent } from './shared/component/sidebar/sidebar.component';
import { HeaderComponent } from './shared/component/header/header.component';
import {DropdownDirective} from "./shared/directive/dropdown.directive";

@NgModule({
  declarations: [
    SystemComponent,
    DiagramsComponent,
    AccountComponent,
    ExploreComponent,
    SidebarComponent,
    HeaderComponent,
    DropdownDirective
  ],
  imports:[
    CommonModule,
    SystemRoutingModule,
    SharedModule
  ]
})
export class SystemModule {}
