package com.hunters.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioModel {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Robson Ruas")
	private String nome;
	
	@ApiModelProperty(example = "31858526958")
	private String cpf;
	
	@ApiModelProperty(example = "Rua Arkansas")
	private String endereco;
	
	@ApiModelProperty(example = "119958525525")
	private String telefone;
	
	@ApiModelProperty(example = "robson@gmail.com")
	private String email;
	
}
