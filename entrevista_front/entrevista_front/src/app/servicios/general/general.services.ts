import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { Http, Response, Headers, RequestOptions, ResponseContentType } from '@angular/http';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import { UrlServices } from '../urls'
import * as CryptoJS from 'crypto-js';

@Injectable()
export class GeneralService {

    url = new UrlServices();
    strSesion = 'sesion';
    key = 'HackersSeeIT2';
    constructor(private _http: Http, private _router: Router) { }

    autenticar(username, password) {
        const params = new URLSearchParams();
        const headers = new Headers();
        headers.append('Authorization', 'Basic ' + btoa('entrevista:entrevistasecretentrevista'))
        const options = new RequestOptions({ headers: headers });
        console.log(params.toString());
        this._http.post(this.url.login + '&username=' + username + '&password=' + password, params.toString(), options)
            .map(res => res.json())
            .subscribe(
            token => {
                const headersToken = new Headers();
                headersToken.append('Authorization', 'Bearer ' + token.access_token)
                const optionsToken = new RequestOptions({ headers: headersToken });
                this._http.get(this.url.token, optionsToken)
                    .map(res => res.json())
                    .subscribe(
                    usuario => {
                        this._http.get(this.url.getAllPersonas + usuario.principal.personaId, optionsToken).map(res => res.json())
                        .subscribe(persona => {
                            const nombres = persona.nombres.toUpperCase() + ' ' + persona.apellidos.toUpperCase();
                            const usuarioLocalStorage = { 'token': token, 'usuario': usuario.principal }
                            const encrypted = CryptoJS.AES.encrypt(JSON.stringify(usuarioLocalStorage), this.key);
                            const sesion = encrypted.toString()
                            localStorage.setItem(this.strSesion, sesion);
                            window.open('/', '_self');
                        }, err => { });
                    },
                    err => { }
                    );
            },
            err => { }
            );
    }

    autenticarRegistro() {
        let username = 'registro'
        let password = 'password'
        let params = new URLSearchParams();
        let headers = new Headers();
        headers.append('Authorization', 'Basic ' + btoa("acme:acmesecret"))
        let options = new RequestOptions({ headers: headers });
        console.log(params.toString());
        this._http.post(this.url.login + '&username=' + username + '&password=' + password, params.toString(), options)
            .map(res => res.json())
            .subscribe(
            token => {
                let headersToken = new Headers();
                headersToken.append('Authorization', 'Bearer ' + token.access_token)
                let optionsToken = new RequestOptions({ headers: headersToken });
                this._http.get(this.url.token, optionsToken)
                    .map(res => res.json())
                    .subscribe(
                    usuario => {
                        let usuarioLocalStorage = { "token": token, "usuario": usuario.principal }
                        //console.log(usuarioLocalStorage);                                     
                        var encrypted = CryptoJS.AES.encrypt(JSON.stringify(usuarioLocalStorage), this.key);
                        // console.log(encrypted.toString());
                        // var decrypted = CryptoJS.AES.decrypt(encrypted, key);
                        // console.log(decrypted.toString(CryptoJS.enc.Utf8));
                        let sesion = encrypted.toString()
                        localStorage.setItem(this.strSesion, sesion);



                    },
                    err => { this._router.navigate(['/pages/login/131231sd1123']); }
                    );
            },
            err => { this._router.navigate(['/pages/login/131231sd1123']); }
            );
    }

    checkCredentials() {
        if (localStorage.getItem(this.strSesion) == null) {
            this._router.navigate(['/pages/login']);
        }
    }
    getCredentials() {
        if (localStorage.getItem(this.strSesion) == null) {
            this._router.navigate(['/pages/login']);
        } else {
            var decrypted = CryptoJS.AES.decrypt(localStorage.getItem(this.strSesion), this.key);
            let persona = JSON.parse(decrypted.toString(CryptoJS.enc.Utf8));
            console.log(persona, 'haver ');
            return persona.usuario.rol
        }
    }


    
    getPersonaId() {
        if (localStorage.getItem(this.strSesion) == null) {
            this._router.navigate(['/pages/login']);
        } else {
            var decrypted = CryptoJS.AES.decrypt(localStorage.getItem(this.strSesion), this.key);
            let persona = JSON.parse(decrypted.toString(CryptoJS.enc.Utf8))
            return persona.usuario.personaId
        }
    }

    logout() {
        localStorage.removeItem(this.strSesion);
        localStorage.removeItem("nombres");
        this._router.navigate(['/pages/login']);
    }


    getResources(tipo, url, body = null): Observable<any> {
        let result;
        if (localStorage.getItem(this.strSesion) != null) {
            let headersToken = new Headers();
            var decrypted = CryptoJS.AES.decrypt(localStorage.getItem(this.strSesion), this.key);
            let token = JSON.parse(decrypted.toString(CryptoJS.enc.Utf8))
            headersToken.append('Authorization', 'Bearer ' + token.token.access_token)
            let optionsToken = new RequestOptions({ headers: headersToken });
            if (tipo == "get") {
                return this._http["get"](url, optionsToken)
                    .map((res: Response) => {
                        result = res.json();
                        return result;
                    }).catch(this.handleError());
            } else if (tipo == "post") {
                return this._http["post"](url, body, optionsToken)
                    .map((res: Response) => {
                        result = res.json();
                        return result;
                    }).catch(this.handleError());
            } else if (tipo == "getFile") {
                optionsToken = new RequestOptions({ headers: headersToken, responseType: ResponseContentType.Blob });
                return this._http["get"](url, optionsToken)
                    .map((res: Response) => {
                        return res;
                    }).catch(this.handleError());
            }

        }
        return null;
    }


    private handleError() {
        return (res: Response) => {
            let errMessage: any;
            // try {
            //     console.log(res);
            //     if (res.status == 412) {
            //         errMessage = { 'status': res.status, 'message': res.text() };
            //     } else if (res.status == 401) {
            //         window.location.href = this.urlServices.redirect;
            //     }
            //     else {
            //         errMessage = res.json();
            //     }

            // } catch (err) {
            //     errMessage = res.statusText;
            // }
            // // Security errors
            // this.utilService.stopProcess();
            return Observable.throw(errMessage);
        };
    }

}