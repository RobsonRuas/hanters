package com.hunters.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProdutosUsuarioModel {
	
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "A", required = true)
	private String status;
	
	@ApiModelProperty(example = "Id Usuario e Id Produto", required = true)
	private PrudutosUsuarioPkModel pk;

}
