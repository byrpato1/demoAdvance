package com.entrevista.demo.od.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.entrevista.demo.od.modelos.Catalogo;


public interface CatalogoRepositorio extends JpaRepository<Catalogo, Long>, JpaSpecificationExecutor<Catalogo> {
	
    @Query("SELECT t FROM Catalogo t where t.catalogoPadreId = ?1 and estado = true order by valor asc") 
    List<Catalogo> listarCatalogoByPadreId(Long catalogoPadreId);
}
