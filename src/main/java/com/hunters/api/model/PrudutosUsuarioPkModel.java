package com.hunters.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PrudutosUsuarioPkModel {
	
	@ApiModelProperty(example = "Id Usuario", required = true)
	private long usuarioId;
	
	@ApiModelProperty(example = "Id Produto", required = true)
	private long produtoId;

}
