package com.hackaton.hackaton2023.web.rest.v1;

import com.hackaton.hackaton2023.repository.PagamentoRepository;
import com.hackaton.hackaton2023.service.PagamentoQueryService;
import com.hackaton.hackaton2023.service.v1.PagamentoServiceExtended;
import com.hackaton.hackaton2023.web.rest.PagamentoResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PagamentoResourceExtended extends PagamentoResource {

    private final PagamentoServiceExtended pagamentoServiceExtended;

    public PagamentoResourceExtended(PagamentoServiceExtended pagamentoServiceExtended, PagamentoRepository pagamentoRepository, PagamentoQueryService pagamentoQueryService) {
        super(pagamentoServiceExtended, pagamentoRepository, pagamentoQueryService);
        this.pagamentoServiceExtended = pagamentoServiceExtended;
    }

}
