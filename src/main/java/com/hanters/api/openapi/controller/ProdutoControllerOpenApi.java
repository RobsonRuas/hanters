package com.hanters.api.openapi.controller;

import java.util.List;

import com.hanters.api.model.ProdutoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Estados")
public interface ProdutoControllerOpenApi {

	@ApiOperation("Lista os Usuários")
	List<ProdutoModel> listar();

}