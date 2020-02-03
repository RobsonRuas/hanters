package com.hunters.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PrudutosUsuarioPkInput {
	
	@ApiModelProperty(example = "Id Usuario", required = true)
	@NotBlank
	private long usuarioId;
	
	@ApiModelProperty(example = "Id Produto", required = true)
	@NotBlank
	private long produtoId;

}
