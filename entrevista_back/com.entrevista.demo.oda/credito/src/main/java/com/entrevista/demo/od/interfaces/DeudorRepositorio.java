package com.entrevista.demo.od.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrevista.demo.od.modelos.Deudor;


public interface DeudorRepositorio extends JpaRepository<Deudor, Long> {
	

}
