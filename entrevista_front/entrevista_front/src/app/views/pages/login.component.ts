import { Component , OnInit} from '@angular/core';
import { GeneralService } from 'app/servicios/General/general.services'
import { ActivatedRoute } from '@angular/router';
@Component({
  templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit{

  error=null;
  usuario=null;
  password=null;
  mensaje = null;
  constructor(private generalService: GeneralService,
    private route: ActivatedRoute,) {

  }
  ngOnInit() {
    
    this.route.params.subscribe(params => {
      console.log(params['error']);
      if (params['idPersona'] != null) {
        this.generalService.logout();
      }
      if (params['error'] != null && params['error']=="logout") {
        this.generalService.logout();
      }
    })
  }


  logear() {
    if (this.usuario != null && this.password != null) {

      this.generalService.autenticar(this.usuario, this.password);

    } else {

      this.mensaje = 'Credenciales Incorrectas';
    }

  }
}
