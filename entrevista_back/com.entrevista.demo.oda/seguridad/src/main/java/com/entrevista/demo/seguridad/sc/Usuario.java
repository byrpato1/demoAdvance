package com.entrevista.demo.seguridad.sc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.entrevista.demo.seguridad.enums.RolEnum;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {
	
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long usuarioId;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "estado", nullable = false)
	private boolean estado;
	
	@Column(name="persona_id", insertable = false, updatable = false)
	private Long personaId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="persona_id")
	private Persona persona;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RolEnum rol;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// we never lock accounts
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// credentials never expire
		return true;
	}

	@Override
	public boolean isEnabled() {
		return estado;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public Persona getPersona() {
		return persona;
	}

	public RolEnum getRol() {
		return rol;
	}

}
