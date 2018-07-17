export class UrlServices {

    servidor = 'http://localhost'
    autorizacion = this.servidor + ':9040/seguridad-entrevista';
    proxy = this.servidor + ':2003/credito-entrevista';
    login = this.autorizacion + '/oauth/token?grant_type=password'
    token = this.autorizacion + '/user'

    personaProxy = this.proxy + '';
    getAllPersonas = this.personaProxy + '/persona/';
    catalogos = this.proxy + '/catalogo/'
    getAllCatalogos = this.catalogos
    getAllCatalogosPadre = this.catalogos + 'padres'

    // catalogos
    getCatalogosById = this.catalogos + 'hijos/';


    // Creditos
    urlDeudor = this.proxy + '/deudor';
    urlCreditos = this.proxy + '/credito';
    getAllCreditos = this.urlCreditos + '/';
    urlPersona = this.proxy + '/persona';
    savePersona = this.urlPersona + '/'
    saveDeudor = this.urlDeudor + '/';
    saveCredito = this.urlCreditos + '/';

    constructor() {

    }
}