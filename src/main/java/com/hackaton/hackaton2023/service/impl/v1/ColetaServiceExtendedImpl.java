package com.hackaton.hackaton2023.service.impl.v1;

import com.hackaton.hackaton2023.repository.v1.ColetaRepositoryExtended;
import com.hackaton.hackaton2023.service.impl.ColetaServiceImpl;
import com.hackaton.hackaton2023.service.v1.ColetaServiceExtended;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Primary
public class ColetaServiceExtendedImpl extends ColetaServiceImpl implements ColetaServiceExtended {

    private final ColetaRepositoryExtended coletaRepositoryExtended;

    public ColetaServiceExtendedImpl(ColetaRepositoryExtended coletaRepositoryExtended) {
        super(coletaRepositoryExtended);
        this.coletaRepositoryExtended = coletaRepositoryExtended;
    }

}
