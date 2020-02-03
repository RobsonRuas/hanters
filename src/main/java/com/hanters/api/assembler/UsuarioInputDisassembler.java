package com.hanters.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hanters.api.domain.entity.Usuario;
import com.hanters.api.model.input.UsuarioInput;

@Component
public class UsuarioInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Usuario toDomainObject(UsuarioInput usuarioInput) {
		return modelMapper.map(usuarioInput, Usuario.class);
	}
	
	public void copyToDomainObject(UsuarioInput usuarioInput, Usuario usuario) {
		modelMapper.map(usuarioInput, usuario);
	}
	
}
