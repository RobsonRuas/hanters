package com.hunters.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hunters.api.assembler.ProdutosUsuarioInputDisassembler;
import com.hunters.api.assembler.ProdutosUsuarioModelAssembler;
import com.hunters.api.domain.entity.ProdutosUsuario;
import com.hunters.api.domain.exception.EntidadeEmUsoException;
import com.hunters.api.domain.exception.NegocioException;
import com.hunters.api.domain.exception.ProdutosUsuarioNaoEncontradoException;
import com.hunters.api.domain.repository.ProdutosUsuarioRepository;
import com.hunters.api.model.ProdutosUsuarioModel;
import com.hunters.api.model.input.ProdutosUsuarioInput;

@Service
public class CadastroProdutosUsuarioService {

	private static final String MSG_ESTADO_EM_USO = "Usuário de código %d não pode ser removido, pois está em uso";

	@Autowired
	private ProdutosUsuarioRepository produtosUsuarioRepository;

	@Autowired
	private CadastroProdutosUsuarioService cadastroProdutosUsuario;

	@Autowired
	private ProdutosUsuarioModelAssembler produtosUsuarioModelAssembler;

	@Autowired
	private ProdutosUsuarioInputDisassembler produtosUsuarioInputDisassembler;

	@Transactional
	public ProdutosUsuario salvar(ProdutosUsuario produtosUsuario) {
		return produtosUsuarioRepository.save(produtosUsuario);
	}

	@Transactional
	public void excluir(Long id) {
		try {
			produtosUsuarioRepository.deleteById(id);
			produtosUsuarioRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new ProdutosUsuarioNaoEncontradoException(id);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_ESTADO_EM_USO, id));
		}
	}

	public ProdutosUsuario buscarOuFalhar(Long id) {
		return produtosUsuarioRepository.findById(id).orElseThrow(() -> new ProdutosUsuarioNaoEncontradoException(id));
	}

	public ProdutosUsuarioModel adicionar(ProdutosUsuarioInput produtosUsuarioInput) {
		
		if(!produtosUsuarioInput.getStatus().equals("A")) {
			throw new NegocioException("Status Produto Usuario inválido");
		}
		
		
		ProdutosUsuario prodUsuario = produtosUsuarioRepository
				.produtoAtivo(produtosUsuarioInput.getPk().getUsuarioId());

		if (prodUsuario != null) {
			prodUsuario.setStatus("C");
			cadastroProdutosUsuario.salvar(prodUsuario);
		}

		ProdutosUsuario produtosUsuario = produtosUsuarioInputDisassembler.toDomainObject(produtosUsuarioInput);

		produtosUsuario = cadastroProdutosUsuario.salvar(produtosUsuario);

		return produtosUsuarioModelAssembler.toModel(produtosUsuario);
	}

}
