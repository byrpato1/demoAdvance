package com.entrevista.demo.od.controlador;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entrevista.demo.od.filtros.FiltroCatalogo;
import com.entrevista.demo.od.interfaces.CatalogoRepositorio;
import com.entrevista.demo.od.modelos.Catalogo;



@Controller
@RequestMapping("/catalogo")
public class CatalogoControlador extends AbstracControlador<CatalogoRepositorio, Catalogo> {	
	
	@GetMapping("/hijos/{id}")
	@ResponseBody
	public CompletableFuture<List<Catalogo>> getHijos(@PathVariable("id") Long id) {
		FiltroCatalogo filtro = new FiltroCatalogo(id,null);
		return CompletableFuture.completedFuture(repo.findAll(filtro));
	}
	
	@GetMapping("/padres")
	@ResponseBody
	public CompletableFuture<List<Catalogo>> getPadres() {
		FiltroCatalogo filtro = new FiltroCatalogo(null,true);
		return CompletableFuture.completedFuture(repo.findAll(filtro));
	}
	
	@PostMapping("/listaHijos")
	@ResponseBody
	public CompletableFuture<List<Catalogo>>createSimple(@Valid @RequestBody Long[] ids) {

		FiltroCatalogo filtro = new FiltroCatalogo(ids);
		return CompletableFuture.completedFuture(repo.findAll(filtro));

	}

}
