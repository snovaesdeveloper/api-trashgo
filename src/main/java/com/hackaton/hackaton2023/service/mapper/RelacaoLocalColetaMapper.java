package com.hackaton.hackaton2023.service.mapper;

import com.hackaton.hackaton2023.domain.RelacaoLocalColeta;

public class RelacaoLocalColetaMapper {

    public static RelacaoLocalColetaDTO toDTO(RelacaoLocalColeta relacao){
        RelacaoLocalColetaDTO dto = new RelacaoLocalColetaDTO();
        dto.setLocal(relacao.getLocal());
        return dto;
    }

}
