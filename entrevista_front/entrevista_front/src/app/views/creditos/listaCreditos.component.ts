
import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'app/servicios/usuarios/usuarios.service'
import { ActivatedRoute } from '@angular/router';
import { Properties } from 'app/views/general/properties'
import { SelectItem } from 'primeng/primeng'
import { forEach } from '@angular/router/src/utils/collection';
import { Message } from 'primeng/components/common/api';
import { MessageService } from 'primeng/components/common/messageservice';
import { ConfirmDialogModule, ConfirmationService } from 'primeng/primeng';
import { CreditosService } from '../../servicios/creditos/creditos.service';
import { CatalogosService } from 'app/servicios/creditos/catalogos.service';
import { Persona } from 'app/modelos/persona.model';
import { Deudor } from 'app/modelos/deudor.model';
import { Credito } from 'app/modelos/credito.model';

@Component({
  templateUrl: 'listaCreditos.component.html',
})
export class ListaCreditosComponent implements OnInit {


  msgs: Message[] = [];

  persona = new Persona();
  conyuge = new Persona();
  deudor = new Deudor();
  credito = new Credito();
  listCredito: any[];
  cols: any[];
  properties = new Properties();
  listEstadoCivil: SelectItem[] = [{ label: this.properties.seleccione, value: null }];
  listTipoTelefono: SelectItem[] = [{ label: this.properties.seleccione, value: null }];
  listTipoDireccion: SelectItem[] = [{ label: this.properties.seleccione, value: null }];
  banderaForm: boolean;
  esVisiblePopUpCredito: boolean;
  deudorInfo: any;
  monto: any;
  tasa: any;
  plazo: any;
  cuota: any;
  estadoAprobacion: any;
  constructor(private _usuarioService: UsuarioService,
    private route: ActivatedRoute,
    private messageService: MessageService,
    private confirmationService: ConfirmationService,
    private creditosService: CreditosService,
    private catalogoService: CatalogosService
  ) { }

  ngOnInit() {

    this.cols = [
      { field: 'nombresCompletos', header: 'Apellidos y Nombres' },
      { field: 'numeroIdentificacion', header: 'Nro. Identificación' },
      { field: 'ingresos', header: 'Ingresos' },
      { field: 'plazo', header: 'Plazo' }
  ];
    this.getAllCreditos();
    this.getCatalogosEstadCivil(1);
    this.getCatalogosTelefono(8);
    this.getCatalogosDireccion(5);
    this.banderaForm = false;
  }

  getAllCreditos () {
    this.creditosService.getCreditos().subscribe((creditos: any[]) => {
      creditos.forEach(element => {
        element.nombresCompletos = element.deudor.persona.apellidos + ' ' + element.deudor.persona.nombres;
        element.numeroIdentificacion = element.deudor.persona.numeroIdentificacion;
        element.ingresos = element.deudor.ingreso;
      });
     this.listCredito = creditos;
    }, (err: any) => console.log(err),
      () => {
      });
  }

  nuevo() {
    this.banderaForm = true;
  }

  cancelar() {
    this.banderaForm = false;
  }

  verInfoCredito(data) {
    console.log(data, 'fila');
    this.deudorInfo = data.nombresCompletos;
    this.monto = data.monto;
    this.plazo = data.plazo;
    this.cuota = data.cuota;
    if(data.aprobacion == 'R'){
      this.estadoAprobacion = 'RECHAZADO';
    } else {
      if (data.aprobacion == 'A') {
        this.estadoAprobacion = 'APROBADO';
      } else {
        this.estadoAprobacion = 'EN REVISIÓN';
      }
    }
    this.esVisiblePopUpCredito = true;
  }

  cerraDialog() {
    this.esVisiblePopUpCredito = false;
  }

  guardar() {
    this.banderaForm = false;
    this.creditosService.guardarPersona(this.persona).subscribe((persona: any) => {
      this.deudor.personaId = persona.id
      this.creditosService.guardarDeudor(this.deudor).subscribe((deudor: any) => {
        this.credito.deudorId = deudor.id;
        this.creditosService.guardarCredito(this.credito).subscribe((credito: any) => {
          // this.messageService.add({ severity: 'success', summary: 'Exito', detail: 'Estudiante actualizado.' });
        }, (err: any) => {
          console.log(err)
          // this.messageService.add({ severity: 'error', summary: 'Error', detail: 'No se pudo completar la acción' });
        },
        () => {
        });
        // this.messageService.add({ severity: 'success', summary: 'Exito', detail: 'Estudiante actualizado.' });
      }, (err: any) => {
        console.log(err)
        // this.messageService.add({ severity: 'error', summary: 'Error', detail: 'No se pudo completar la acción' });
      },
      () => {
      });

      // this.messageService.add({ severity: 'success', summary: 'Exito', detail: 'Estudiante actualizado.' });
    }, (err: any) => {

      console.log(err)
      // this.messageService.add({ severity: 'error', summary: 'Error', detail: 'No se pudo completar la acción' });
    },
    () => {
    });
  }

  getCatalogosEstadCivil(id) {
    this.catalogoService.getCatalogosById(id).subscribe((catalogos: any[]) => {
      catalogos.forEach(ctlg => {
            this.listEstadoCivil.push({ label: ctlg.descripcion, value: ctlg.id });
        });
    },
    (err: any) => {
        this.msgs = [];
        this.msgs.push({ severity: 'error', detail: 'Error Servicio Catalogo' });
    },
    () => {});
  }

  getCatalogosTelefono(id) {
    this.catalogoService.getCatalogosById(id).subscribe((catalogos: any[]) => {
      catalogos.forEach(ctlg => {
            this.listTipoTelefono.push({ label: ctlg.descripcion, value: ctlg.id });
        });
    },
    (err: any) => {
        this.msgs = [];
        this.msgs.push({ severity: 'error', detail: 'Error Servicio Catalogo' });
    },
    () => {});
  }

  getCatalogosDireccion(id) {
    this.catalogoService.getCatalogosById(id).subscribe((catalogos: any[]) => {
      catalogos.forEach(ctlg => {
            this.listTipoDireccion.push({ label: ctlg.descripcion, value: ctlg.id });
        });
    },
    (err: any) => {
        this.msgs = [];
        this.msgs.push({ severity: 'error', detail: 'Error Servicio Catalogo' });
    },
    () => {});
  }
}
