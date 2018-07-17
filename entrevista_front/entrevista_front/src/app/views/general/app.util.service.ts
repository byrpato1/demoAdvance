import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';

import 'rxjs/add/operator/map';
// import * as jsPDF from 'jspdf'
// import { BlockUI, NgBlockUI } from 'ng-block-ui';
import { Properties } from 'app/views/general/properties';
import * as $ from 'jquery';

@Injectable()
export class UtilService {


    tiempoHeader: string;
    ipHeader: string;

    constructor(private http: Http) {
    }
    properties: Properties = new Properties();

    
    
    //Construir los parámetros del reporte. 
    envioReporte(options) {
        let $form = $("<form />");

        $form.attr("action", this.properties.urlReportes);
        $form.attr("method", options.method);
        // $form.attr("target", '_blank');

        for (let data in options.data)
            $form.append('<input type="hidden" name="' + data + '" value="' + options.data[data] + '" />');

        $("body").append($form);
        $form.submit();
    }
}