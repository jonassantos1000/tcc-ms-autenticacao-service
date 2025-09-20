package com.usp.esalq.tcc.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.usp.esalq.tcc.domain.entity.AutenticacaoEntity;
import com.usp.esalq.tcc.domain.entity.UsuarioEntity;
import com.usp.esalq.tcc.domain.mapper.AutenticacaoMapper;
import com.usp.esalq.tcc.domain.model.autenticacao.AutenticacaoVO;
import com.usp.esalq.tcc.domain.model.autenticacao.DadosAutenticacaoVO;
import com.usp.esalq.tcc.exceptions.MsgException;
import com.usp.esalq.tcc.repository.AutenticacaoRepository;
import com.usp.esalq.tcc.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutenticacaoService {
	
	private final AutenticacaoMapper mapper;
	
	private final AutenticacaoRepository autenticacaoRepository;
	private final UsuarioRepository usuarioRepository;

	@Transactional
	public AutenticacaoVO autenticar(DadosAutenticacaoVO dadosAutenticacao) {
		UsuarioEntity usuario = usuarioRepository.findByEmailAndSenha(dadosAutenticacao.email(), dadosAutenticacao.senha()).orElseThrow(() -> new MsgException("Usuário e/ou senha inválido."));
		
		AutenticacaoEntity entity = Optional.ofNullable(usuario.getAutenticacao())
			.map(this::atualizarToken)
			.orElseGet(() -> gerarToken(usuario));
		
		return mapper.toAutenticacaoVO(entity);
	}

	private AutenticacaoEntity gerarToken(UsuarioEntity usuario) {
		AutenticacaoEntity autenticacao = mapper.toEntity(UUID.randomUUID(), usuario);
		return autenticacaoRepository.save(autenticacao);
	}

	private AutenticacaoEntity atualizarToken(AutenticacaoEntity autenticacao) {
		autenticacao.setToken(UUID.randomUUID());
		return autenticacaoRepository.save(autenticacao);
	}
}
