import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { ListaCreditosRoutingModule } from './listaCreditos-routing.module';
import {
  PasswordModule,
  InputTextModule,
  PanelModule,
  DataTableModule, SharedModule, TabViewModule, ButtonModule,
  RadioButtonModule, GrowlModule, CalendarModule, DropdownModule, CheckboxModule, FieldsetModule, ConfirmDialogModule, ConfirmationService
} from 'primeng/primeng';
import {DialogModule} from 'primeng/dialog';
import {TableModule} from 'primeng/table';
import { UsuarioService } from 'app/servicios/usuarios/usuarios.service'
import { MessageService } from 'primeng/components/common/messageservice';
import { CreditosService } from 'app/servicios/creditos/creditos.service';
import {KeyFilterModule} from 'primeng/keyfilter';
import { CatalogosService } from 'app/servicios/creditos/catalogos.service';
import { ListaCreditosComponent } from 'app/views/creditos/listaCreditos.component';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
@NgModule({
  imports: [
    DialogModule,
    MessageModule,
    MessagesModule,
    TableModule,
    KeyFilterModule,
    CommonModule,
    FormsModule,
    ListaCreditosRoutingModule,
    ChartsModule,
    PasswordModule,
    DropdownModule,
    InputTextModule,
    PanelModule,
    CheckboxModule,
    FieldsetModule,
    DataTableModule,
    SharedModule,
    ButtonModule,
    CalendarModule,
    TabViewModule,
    ConfirmDialogModule,
    RadioButtonModule,
    GrowlModule

  ],
  declarations: [ListaCreditosComponent]
  , providers: [UsuarioService, MessageService, ConfirmationService, CreditosService,
    CatalogosService]
})
export class ListaCreditosModule { }
