package com.hanters.api.openapi.controller;

import java.util.List;

import org.springframework.beans.factory.parsing.Problem;

import com.hanters.api.model.UsuarioModel;
import com.hanters.api.model.input.UsuarioInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Usuarios")
public interface UsuarioControllerOpenApi {

	@ApiOperation("Lista os Usuários")
	List<UsuarioModel> listar();

	@ApiOperation("Busca um usuário por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID do usuário inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Usuario não encontrado", response = Problem.class)
	})
	UsuarioModel buscar(
			@ApiParam(value = "ID de um usuário", example = "1", required = true)
			Long usuarioId);

	@ApiOperation("Cadastra um usuário")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Usuário cadastrado"),
	})
	UsuarioModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de um novo usuário", required = true)
			UsuarioInput usuarioInput);

	@ApiOperation("Atualiza um usuário por ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Usuário atualizado"),
		@ApiResponse(code = 404, message = "Usuário não encontrado", response = Problem.class)
	})
	UsuarioModel atualizar(
			@ApiParam(value = "ID de um usuário", example = "1", required = true)
			Long usuarioId,
			
			@ApiParam(name = "corpo", value = "Representação de um usuário com os novos dados", required = true)
			UsuarioInput usuarioInput);

	@ApiOperation("Exclui um usuário por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Usuário excluído"),
		@ApiResponse(code = 404, message = "Usuário não encontrado", response = Problem.class)
	})
	void remover(
			@ApiParam(value = "ID de um usuário", example = "1", required = true)
			Long usuarioId);

}