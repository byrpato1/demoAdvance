import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { GeneralService } from '../General/general.services'
import { UrlServices } from '../urls'
@Injectable()
export class UsuarioService {

    url = new UrlServices();
    constructor(private _generalServices: GeneralService) {
        // _generalServices.autenticar('usuario', 'password');
    }

    getUsuarioId() {
        return this._generalServices.getPersonaId();
    }

    getUsuarios(rol): Observable<any> {
        return this._generalServices.getResources('get', this.url.getAllPersonas)
    }
}