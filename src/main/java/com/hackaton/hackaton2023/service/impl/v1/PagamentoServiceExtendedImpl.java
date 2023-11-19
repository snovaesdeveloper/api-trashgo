package com.hackaton.hackaton2023.service.impl.v1;

import com.hackaton.hackaton2023.repository.v1.PagamentoRepositoryExtended;
import com.hackaton.hackaton2023.service.impl.PagamentoServiceImpl;
import com.hackaton.hackaton2023.service.v1.PagamentoServiceExtended;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Primary
public class PagamentoServiceExtendedImpl extends PagamentoServiceImpl implements PagamentoServiceExtended {

    private final PagamentoRepositoryExtended pagamentoRepositoryExtended;

    public PagamentoServiceExtendedImpl(PagamentoRepositoryExtended pagamentoRepositoryExtended) {
        super(pagamentoRepositoryExtended);
        this.pagamentoRepositoryExtended = pagamentoRepositoryExtended;
    }

}
