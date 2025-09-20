package com.usp.esalq.tcc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usp.esalq.tcc.domain.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	Optional<UsuarioEntity> findByEmailAndSenha(String email, String senha);
	
	boolean existsByEmail(String email);
}
