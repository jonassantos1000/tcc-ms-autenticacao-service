package com.usp.esalq.tcc.domain.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.usp.esalq.tcc.domain.entity.AutenticacaoEntity;
import com.usp.esalq.tcc.domain.entity.UsuarioEntity;
import com.usp.esalq.tcc.domain.model.autenticacao.AutenticacaoVO;

@Mapper(componentModel = "spring")
public interface AutenticacaoMapper {

	AutenticacaoVO toAutenticacaoVO(AutenticacaoEntity entity); 
	
	@Mapping(target = "id", ignore = true)
	AutenticacaoEntity toEntity(UUID token, UsuarioEntity usuario); 
}
