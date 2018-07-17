package com.entrevista.demo.od.controlador;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entrevista.demo.od.interfaces.CreditoRepositorio;
import com.entrevista.demo.od.interfaces.PersonaRepositorio;
import com.entrevista.demo.od.modelos.Credito;
import com.entrevista.demo.od.modelos.Persona;
import com.entrevista.demo.od.enums.*;

@Controller
@RequestMapping("/credito")
public class CreditoControlador extends AbstracControlador<CreditoRepositorio, Credito> {
	
	@PostMapping("/")
	@ResponseBody
	public CompletableFuture<Credito> createSimple(@Valid @RequestBody Credito body) {
		if (body.getMonto() < 10000) {
			body.setAprobacion(AprobaCreditoEnum.R);
		} else {
			if (body.getMonto() > 10000 && body.getMonto() < 20000) {
				body.setAprobacion(AprobaCreditoEnum.A);
			} else {
				body.setAprobacion(AprobaCreditoEnum.EN);
			}
		}
		return CompletableFuture.completedFuture(repo.save(body));
	}
}
