package com.entrevista.demo.od.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrevista.demo.od.modelos.Usuario;


public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	

}
