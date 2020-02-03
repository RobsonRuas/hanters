package com.hunters.api.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class ProdutoUsuarioPK {

	@Column(name = "usuario_id")
	private long usuarioId;
	
	@Column(name = "produto_id")
	private long produtoId;
		
	
	
	
	
	
}
