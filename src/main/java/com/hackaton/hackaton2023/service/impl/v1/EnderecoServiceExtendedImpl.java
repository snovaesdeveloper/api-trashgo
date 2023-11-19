package com.hackaton.hackaton2023.service.impl.v1;

import com.hackaton.hackaton2023.repository.v1.EnderecoRepositoryExtended;
import com.hackaton.hackaton2023.service.impl.EnderecoServiceImpl;
import com.hackaton.hackaton2023.service.v1.EnderecoServiceExtended;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Primary
public class EnderecoServiceExtendedImpl extends EnderecoServiceImpl implements EnderecoServiceExtended {

    private final EnderecoRepositoryExtended enderecoRepositoryExtended;

    public EnderecoServiceExtendedImpl(EnderecoRepositoryExtended enderecoRepositoryExtended) {
        super(enderecoRepositoryExtended);
        this.enderecoRepositoryExtended = enderecoRepositoryExtended;
    }

}
