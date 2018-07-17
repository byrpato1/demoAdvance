package com.entrevista.demo.seguridad.sc;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	Usuario findOneByUsername(String username);

}
