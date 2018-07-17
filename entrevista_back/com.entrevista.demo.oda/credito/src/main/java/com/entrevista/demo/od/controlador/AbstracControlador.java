package com.entrevista.demo.od.controlador;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public abstract class AbstracControlador<T extends JpaRepository<E, Long>, E> {

	@Autowired
	protected T repo;

	@GetMapping("/")
	@ResponseBody
	public CompletableFuture<List<E>> getAll() {
		return CompletableFuture.completedFuture(repo.findAll());
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public E findId(@PathVariable("id") Long id) {
		return repo.findOne(id);
	}
	
	@GetMapping("/filtro")
	@ResponseBody
	public CompletableFuture<List<E>> filtro(@RequestParam Map<String, String> requestParams) {
		// String numeroIdentificacion=requestParams.get("numeroIdentificacion");
		// PersonaFiltros pf = new PersonaFiltros( numeroIdentificacion);
		return null;
	}

	// crea actualiza
	@PostMapping("/")
	@ResponseBody
	public CompletableFuture<E>  createSimple(@Valid @RequestBody E body) {
		return CompletableFuture.completedFuture(repo.save(body));
	}

}
