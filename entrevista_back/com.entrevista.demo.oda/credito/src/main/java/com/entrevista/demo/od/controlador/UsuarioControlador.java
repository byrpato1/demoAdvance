package com.entrevista.demo.od.controlador;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entrevista.demo.od.interfaces.UsuarioRepositorio;
import com.entrevista.demo.od.modelos.Usuario;



@Controller
@RequestMapping("/usuario")
public class UsuarioControlador extends AbstracControlador<UsuarioRepositorio, Usuario> {	
	
	}
