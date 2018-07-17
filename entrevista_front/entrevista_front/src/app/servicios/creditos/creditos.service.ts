import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { GeneralService } from '../General/general.services'
import { UrlServices } from '../urls'
@Injectable()
export class CreditosService {

    url = new UrlServices();
    constructor(private _generalServices: GeneralService) {
        _generalServices.checkCredentials();
    }

    getCreditos(): Observable<any> {
        return this._generalServices.getResources('get', this.url.getAllCreditos)
    }

    guardarPersona(persona): Observable<any> {
        return this._generalServices.getResources('post', this.url.savePersona, persona)
    }

    guardarDeudor(deudor): Observable<any> {
        return this._generalServices.getResources('post', this.url.saveDeudor, deudor)
    }

    guardarCredito(credito): Observable<any> {
        return this._generalServices.getResources('post', this.url.saveCredito, credito)
    }

}