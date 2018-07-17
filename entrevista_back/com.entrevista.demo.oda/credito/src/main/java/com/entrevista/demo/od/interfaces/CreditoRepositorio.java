package com.entrevista.demo.od.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entrevista.demo.od.modelos.Credito;


public interface CreditoRepositorio extends JpaRepository<Credito, Long> {
	
	@Query("SELECT t FROM Credito t where t.deudor.id = ?1 ") 
	Credito buscarPorDeudorId(Long deudorId);

}
