import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListaCreditosComponent } from 'app/views/creditos/listaCreditos.component';

const routes: Routes = [
  {
    path: '',
    component: ListaCreditosComponent,
    data: {
      title: 'Lista de Creditos'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListaCreditosRoutingModule {}
