package com.hackaton.hackaton2023.service.impl.v1;

import com.hackaton.hackaton2023.domain.RelacaoLocalColeta;
import com.hackaton.hackaton2023.repository.v1.RelacaoLocalColetaRepositoryExtended;
import com.hackaton.hackaton2023.service.impl.RelacaoLocalColetaServiceImpl;
import com.hackaton.hackaton2023.service.v1.RelacaoLocalColetaServiceExtended;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Primary
public class RelacaoLocalCotaServiceExtendedImpl extends RelacaoLocalColetaServiceImpl implements RelacaoLocalColetaServiceExtended {

    private final RelacaoLocalColetaRepositoryExtended relacaoLocalColetaRepositoryExtended;

    public RelacaoLocalCotaServiceExtendedImpl(RelacaoLocalColetaRepositoryExtended relacaoLocalColetaRepositoryExtended) {
        super(relacaoLocalColetaRepositoryExtended);
        this.relacaoLocalColetaRepositoryExtended = relacaoLocalColetaRepositoryExtended;
    }

    @Override
    public void deleteByColetaId(Long id) {
        relacaoLocalColetaRepositoryExtended.deleteByColetaId(id);
    }
}
