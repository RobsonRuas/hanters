package com.hanters.api.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_Id")
	private long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@NotBlank
	@Column(nullable = false)
	private String cpf;
	
	@NotBlank
	@Column(nullable = false)
	private String endereco;
	
	@NotBlank
	@Column(nullable = false)
	private String telefone;
	
	@NotBlank
	@Column(nullable = false)
	private String email;
	
	
	@OneToMany(mappedBy = "usuario", targetEntity = ProdutosUsuario.class, fetch = FetchType.LAZY)
	private Set<ProdutosUsuario> produtosUsuario;
	
}