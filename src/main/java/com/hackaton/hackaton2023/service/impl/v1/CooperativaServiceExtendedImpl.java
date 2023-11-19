package com.hackaton.hackaton2023.service.impl.v1;

import com.hackaton.hackaton2023.repository.v1.CooperativaRepositoryExtended;
import com.hackaton.hackaton2023.service.impl.CooperativaServiceImpl;
import com.hackaton.hackaton2023.service.v1.CooperativaServiceExtended;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Primary
public class CooperativaServiceExtendedImpl extends CooperativaServiceImpl implements CooperativaServiceExtended {

    private final CooperativaRepositoryExtended cooperativaRepositoryExtended;

    public CooperativaServiceExtendedImpl(CooperativaRepositoryExtended cooperativaRepositoryExtended) {
        super(cooperativaRepositoryExtended);
        this.cooperativaRepositoryExtended = cooperativaRepositoryExtended;
    }

}
