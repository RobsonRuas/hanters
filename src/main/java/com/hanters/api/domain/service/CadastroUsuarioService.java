package com.hanters.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hanters.api.domain.entity.Usuario;
import com.hanters.api.domain.exception.EntidadeEmUsoException;
import com.hanters.api.domain.exception.UsuarioNaoEncontradoException;
import com.hanters.api.domain.repository.UsuarioRepository;

@Service
public class CadastroUsuarioService {

	private static final String MSG_ESTADO_EM_USO 
		= "Usuário de código %d não pode ser removido, pois está em uso";
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public void excluir(Long usuarioId) {
		try {
			usuarioRepository.deleteById(usuarioId);
			usuarioRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new UsuarioNaoEncontradoException(usuarioId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_ESTADO_EM_USO, usuarioId));
		}
	}

	public Usuario buscarOuFalhar(Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
			.orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
	}
	
}
