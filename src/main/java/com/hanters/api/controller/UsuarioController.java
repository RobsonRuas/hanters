package com.hanters.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hanters.api.assembler.UsuarioInputDisassembler;
import com.hanters.api.assembler.UsuarioModelAssembler;
import com.hanters.api.domain.entity.Usuario;
import com.hanters.api.domain.repository.UsuarioRepository;
import com.hanters.api.domain.service.CadastroUsuarioService;
import com.hanters.api.model.UsuarioModel;
import com.hanters.api.model.input.UsuarioInput;
import com.hanters.api.openapi.controller.UsuarioControllerOpenApi;

@RestController
@RequestMapping(path = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController implements UsuarioControllerOpenApi {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuario;
	
	@Autowired
	private UsuarioModelAssembler usuarioModelAssembler;
	
	@Autowired
	private UsuarioInputDisassembler usuarioInputDisassembler;
	
	@Override
	@GetMapping
	public List<UsuarioModel> listar() {
		List<Usuario> todosUsuarios = usuarioRepository.findAll();
		
		return usuarioModelAssembler.toCollectionModel(todosUsuarios);
	}
	
	@Override
	@GetMapping("/{usuarioId}")
	public UsuarioModel buscar(@PathVariable Long usuarioId) {
		Usuario usuario = cadastroUsuario.buscarOuFalhar(usuarioId);
		
		return usuarioModelAssembler.toModel(usuario);
	}
	
	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioModel adicionar(@RequestBody @Valid UsuarioInput usuarioInput) {
		Usuario usuario = usuarioInputDisassembler.toDomainObject(usuarioInput);
		
		usuario = cadastroUsuario.salvar(usuario);
		
		return usuarioModelAssembler.toModel(usuario);
	}
	
	@Override
	@PutMapping("/{usuarioId}")
	public UsuarioModel atualizar(@PathVariable Long usuarioId,
			@RequestBody @Valid UsuarioInput usuarioInput) {
		Usuario usuarioAtual = cadastroUsuario.buscarOuFalhar(usuarioId);
		
		usuarioInputDisassembler.copyToDomainObject(usuarioInput, usuarioAtual);
		
		usuarioAtual = cadastroUsuario.salvar(usuarioAtual);
		
		return usuarioModelAssembler.toModel(usuarioAtual);
	}
	
	@Override
	@DeleteMapping("/{usuarioId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long usuarioId) {
		cadastroUsuario.excluir(usuarioId);	
	}
	
}
