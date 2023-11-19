package com.hackaton.hackaton2023.web.rest.v1;

import com.hackaton.hackaton2023.repository.EnderecoRepository;
import com.hackaton.hackaton2023.service.EnderecoQueryService;
import com.hackaton.hackaton2023.service.v1.EnderecoServiceExtended;
import com.hackaton.hackaton2023.web.rest.EnderecoResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EnderecoResourceExtended extends EnderecoResource {

    private final EnderecoServiceExtended enderecoServiceExtended;

    public EnderecoResourceExtended(EnderecoServiceExtended enderecoServiceExtended, EnderecoRepository enderecoRepository, EnderecoQueryService enderecoQueryService) {
        super(enderecoServiceExtended, enderecoRepository, enderecoQueryService);
        this.enderecoServiceExtended = enderecoServiceExtended;
    }

}
