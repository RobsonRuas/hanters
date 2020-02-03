package com.hunters.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hunters.api.domain.entity.ProdutosUsuario;

@Repository
public interface ProdutosUsuarioRepository extends JpaRepository<ProdutosUsuario, Long> {

	ProdutosUsuario produtoAtivo(long usuarioId);

}
