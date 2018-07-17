package com.entrevista.demo.od.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entrevista.demo.od.interfaces.PersonaRepositorio;
import com.entrevista.demo.od.modelos.Persona;



@Controller
@RequestMapping("/persona")
public class PersonaControlador extends AbstracControlador<PersonaRepositorio, Persona> {	
}
