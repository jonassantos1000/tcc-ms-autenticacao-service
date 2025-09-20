package com.usp.esalq.tcc.domain.model.autenticacao;

import lombok.Builder;

@Builder
public record DadosAutenticacaoVO(
		
		String email,
		String senha
		) {

}
