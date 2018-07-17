import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { GeneralService } from '../General/general.services'
import { UrlServices } from '../urls'
@Injectable()
export class CatalogosService {

    url = new UrlServices();
    constructor(private _generalServices: GeneralService) {
        _generalServices.checkCredentials();
    }

    getCatalogosById(id): Observable<any> {
        return this._generalServices.getResources('get', this.url.getCatalogosById + id)
    }

    guardarPersona(persona): Observable<any> {
        return this._generalServices.getResources('post', this.url.savePersona, persona)
    }

}