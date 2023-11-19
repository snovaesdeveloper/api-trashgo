package com.hackaton.hackaton2023.service.v1;

import com.hackaton.hackaton2023.service.RelacaoLocalColetaService;

public interface RelacaoLocalColetaServiceExtended extends RelacaoLocalColetaService {
    void deleteByColetaId(Long id);
}
