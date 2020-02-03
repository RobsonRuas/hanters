package com.hunters.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hunters.api.domain.entity.ProdutosUsuario;
import com.hunters.api.model.ProdutosUsuarioModel;

@Component
public class ProdutosUsuarioModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ProdutosUsuarioModel toModel(ProdutosUsuario produtosUsuarioInput) {
		return modelMapper.map(produtosUsuarioInput, ProdutosUsuarioModel.class);
	}
	
	public List<ProdutosUsuarioModel> toCollectionModel(List<ProdutosUsuario> produtosUsuario) {
		return produtosUsuario.stream()
				.map(produtoUsuario -> toModel(produtoUsuario))
				.collect(Collectors.toList());
	}
	
}
