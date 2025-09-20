package com.usp.esalq.tcc.domain.mapper;

import com.usp.esalq.tcc.domain.entity.AutenticacaoEntity;
import com.usp.esalq.tcc.domain.entity.UsuarioEntity;
import com.usp.esalq.tcc.domain.model.autenticacao.AutenticacaoVO;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-20T13:08:37-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class AutenticacaoMapperImpl implements AutenticacaoMapper {

    @Override
    public AutenticacaoVO toAutenticacaoVO(AutenticacaoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String token = null;

        if ( entity.getToken() != null ) {
            token = entity.getToken().toString();
        }

        AutenticacaoVO autenticacaoVO = new AutenticacaoVO( token );

        return autenticacaoVO;
    }

    @Override
    public AutenticacaoEntity toEntity(UUID token, UsuarioEntity usuario) {
        if ( token == null && usuario == null ) {
            return null;
        }

        AutenticacaoEntity autenticacaoEntity = new AutenticacaoEntity();

        autenticacaoEntity.setToken( token );
        autenticacaoEntity.setUsuario( usuario );

        return autenticacaoEntity;
    }
}
