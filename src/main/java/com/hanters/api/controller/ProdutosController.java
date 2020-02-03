package com.hanters.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanters.api.assembler.ProdutoModelAssembler;
import com.hanters.api.domain.entity.Produto;
import com.hanters.api.domain.repository.ProdutoRepository;
import com.hanters.api.model.ProdutoModel;
import com.hanters.api.openapi.controller.ProdutoControllerOpenApi;

@RestController
@RequestMapping(path = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutosController implements ProdutoControllerOpenApi {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@Autowired
	private ProdutoModelAssembler produtoModelAssembler;
	
	@Override
	@GetMapping
	public List<ProdutoModel> listar() {
		List<Produto> todosUsuarios = produtoRepository.findAll();
		return produtoModelAssembler.toCollectionModel(todosUsuarios);
	}
	
	
}
