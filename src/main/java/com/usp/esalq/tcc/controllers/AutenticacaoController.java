package com.usp.esalq.tcc.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usp.esalq.tcc.domain.model.autenticacao.AutenticacaoVO;
import com.usp.esalq.tcc.domain.model.autenticacao.DadosAutenticacaoVO;
import com.usp.esalq.tcc.services.AutenticacaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AutenticacaoController {

	private final AutenticacaoService autenticacaoService;
	
	@PostMapping("/autenticar")
	private AutenticacaoVO realizarAutenticacao(@RequestBody DadosAutenticacaoVO dadosAutenticacao) {
		return autenticacaoService.autenticar(dadosAutenticacao);
	}
}
