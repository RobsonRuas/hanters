package com.hunters.api.domain.exception;

public class ProdutosUsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ProdutosUsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ProdutosUsuarioNaoEncontradoException(Long estadoId) {
		this(String.format("Não existe produto para o usuario com código %d", estadoId));
	}
	
}
