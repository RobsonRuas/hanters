package com.hanters.api.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NamedQuery;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NamedQuery(name="ProdutosUsuario.produtoAtivo", query="select u from ProdutosUsuario u where pk.usuarioId =?1 and status ='A'" )
public class ProdutosUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@NotBlank
	@Column(nullable = false)
	private String status;

	@Embedded
	private ProdutoUsuarioPK pk;

	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", updatable = false, insertable = false) })
	private Usuario usuario;

	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "produto_id", referencedColumnName = "produto_id", updatable = false, insertable = false) })
	private Produto produto;

}
