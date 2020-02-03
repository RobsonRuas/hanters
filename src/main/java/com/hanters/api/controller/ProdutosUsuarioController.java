package com.hanters.api.controller;

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

import com.hanters.api.assembler.ProdutosUsuarioModelAssembler;
import com.hanters.api.domain.entity.ProdutosUsuario;
import com.hanters.api.domain.repository.ProdutosUsuarioRepository;
import com.hanters.api.domain.service.CadastroProdutosUsuarioService;
import com.hanters.api.model.ProdutosUsuarioModel;
import com.hanters.api.model.input.ProdutosUsuarioInput;
import com.hanters.api.openapi.controller.ProdutosUsuarioControllerOpenApi;

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
