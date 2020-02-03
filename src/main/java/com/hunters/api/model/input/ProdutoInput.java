package com.hunters.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoInput {

	@ApiModelProperty(example = "COMUM", required = true)
	@NotBlank
	private String nome;
	
}
