package com.entrevista.demo.od.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entrevista.demo.od.modelos.Persona;


public interface PersonaRepositorio extends JpaRepository<Persona, Long> {
	
	@Query("SELECT t FROM Persona t where t.numeroIdentificacion = ?1")
	Persona findByNumeroIdentificacion(String numeroIdentificacion);

}
