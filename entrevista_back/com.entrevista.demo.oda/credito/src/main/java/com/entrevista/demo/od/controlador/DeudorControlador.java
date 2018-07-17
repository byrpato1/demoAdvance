package com.entrevista.demo.od.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entrevista.demo.od.interfaces.DeudorRepositorio;
import com.entrevista.demo.od.modelos.Deudor;



@Controller
@RequestMapping("/deudor")
public class DeudorControlador extends AbstracControlador<DeudorRepositorio, Deudor> {	
}
