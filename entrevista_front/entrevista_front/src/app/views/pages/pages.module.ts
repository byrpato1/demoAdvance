import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { P404Component } from './404.component';
import { P500Component } from './500.component';
import { LoginComponent } from './login.component';
import { RegisterComponent } from './register.component';
import { UsuarioService } from 'app/servicios/usuarios/usuarios.service'
import {MessageService} from 'primeng/components/common/messageservice';
import { PagesRoutingModule } from './pages-routing.module';
import {GeneralService} from 'app/servicios/General/general.services'
import {PasswordModule,
  InputTextModule,
  PanelModule,
  DataTableModule, SharedModule , TabViewModule, ButtonModule, MessagesModule,
  MessageModule, RadioButtonModule, GrowlModule, CalendarModule,
  DropdownModule, CheckboxModule, FieldsetModule, ConfirmDialogModule, ConfirmationService} from 'primeng/primeng';
@NgModule({
  imports: [  CommonModule,
    FormsModule, PagesRoutingModule ,
    CommonModule,
    FormsModule,
    PasswordModule,
    DropdownModule,
    InputTextModule,
    PanelModule,
    MessagesModule,
    MessageModule,
    CheckboxModule,
    FieldsetModule,
    DataTableModule,
    SharedModule,
    ButtonModule,
    CalendarModule,
    TabViewModule,
    ConfirmDialogModule,
    RadioButtonModule,
    GrowlModule],
  declarations: [
    P404Component,
    P500Component,
    LoginComponent,
    RegisterComponent
  ],
  providers: [GeneralService, UsuarioService,
    MessageService, ConfirmationService]
})
export class PagesModule { }
