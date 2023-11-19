package com.hackaton.hackaton2023.service.impl.v1;

import com.hackaton.hackaton2023.repository.v1.LocalRepositoryExtended;
import com.hackaton.hackaton2023.service.impl.LocalServiceImpl;
import com.hackaton.hackaton2023.service.v1.LocalServiceExtended;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Primary
public class LocalServiceExtendedImpl extends LocalServiceImpl implements LocalServiceExtended {

    private final LocalRepositoryExtended localRepositoryExtended;

    public LocalServiceExtendedImpl(LocalRepositoryExtended localRepositoryExtended) {
        super(localRepositoryExtended);
        this.localRepositoryExtended = localRepositoryExtended;
    }

}
