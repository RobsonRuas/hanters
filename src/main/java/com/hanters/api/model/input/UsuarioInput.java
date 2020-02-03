package com.hanters.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioInput {

	@ApiModelProperty(example = "Robson Ruas", required = true)
	@NotBlank
	private String nome;
	
	@ApiModelProperty(example = "31858696819", required = true)
	@NotBlank
	private String cpf;
	
	@ApiModelProperty(example = "Rua Arkansas", required = true)
	@NotBlank
	private String endereco;
	
	@ApiModelProperty(example = "11999635258", required = true)
	@NotBlank
	private String telefone;
	
	@ApiModelProperty(example = "robson@gmail.com", required = true)
	@NotBlank
	private String email;
	
}
