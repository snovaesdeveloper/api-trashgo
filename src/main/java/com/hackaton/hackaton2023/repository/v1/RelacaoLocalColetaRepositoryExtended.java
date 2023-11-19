package com.hackaton.hackaton2023.repository.v1;

import com.hackaton.hackaton2023.domain.RelacaoLocalColeta;
import com.hackaton.hackaton2023.repository.RelacaoLocalColetaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public interface RelacaoLocalColetaRepositoryExtended extends RelacaoLocalColetaRepository {
    void deleteByColetaId(Long id);
}
