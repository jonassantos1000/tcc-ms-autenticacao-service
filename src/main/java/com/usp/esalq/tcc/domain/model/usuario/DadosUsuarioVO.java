package com.usp.esalq.tcc.domain.model.usuario;

import lombok.Builder;

@Builder
public record DadosUsuarioVO(String nome, String email, String senha) {

}
