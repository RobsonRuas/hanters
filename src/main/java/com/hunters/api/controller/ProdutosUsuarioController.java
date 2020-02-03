package com.hunters.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hunters.api.assembler.ProdutosUsuarioModelAssembler;
import com.hunters.api.domain.entity.ProdutosUsuario;
import com.hunters.api.domain.repository.ProdutosUsuarioRepository;
import com.hunters.api.domain.service.CadastroProdutosUsuarioService;
import com.hunters.api.model.ProdutosUsuarioModel;
import com.hunters.api.model.input.ProdutosUsuarioInput;
import com.hunters.api.openapi.controller.ProdutosUsuarioControllerOpenApi;

@RestController
@RequestMapping(path = "/produtosUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutosUsuarioController implements ProdutosUsuarioControllerOpenApi {

	@Autowired
	private ProdutosUsuarioRepository produtosUsuarioRepository;

	@Autowired
	private CadastroProdutosUsuarioService cadastroProdutosUsuario;

	@Autowired
	private ProdutosUsuarioModelAssembler produtosUsuarioModelAssembler;

	@Override
	@GetMapping
	public List<ProdutosUsuarioModel> listar() {
		List<ProdutosUsuario> todosProdutosUsuario = produtosUsuarioRepository.findAll();

		return produtosUsuarioModelAssembler.toCollectionModel(todosProdutosUsuario);
	}

	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutosUsuarioModel adicionar(@RequestBody ProdutosUsuarioInput produtosUsuarioInput) {
		return cadastroProdutosUsuario.adicionar(produtosUsuarioInput);
	}

}
