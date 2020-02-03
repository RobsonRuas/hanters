package com.hunters.api.openapi.controller;

import java.util.List;

import com.hunters.api.model.ProdutosUsuarioModel;
import com.hunters.api.model.input.ProdutosUsuarioInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Produto Usuário")
public interface ProdutosUsuarioControllerOpenApi {

	@ApiOperation("Lista de Produtos do Usuários")
	List<ProdutosUsuarioModel> listar();

	ProdutosUsuarioModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de um novo produto para o usuário", required = true)
			ProdutosUsuarioInput produtosUsuarioInput);


}