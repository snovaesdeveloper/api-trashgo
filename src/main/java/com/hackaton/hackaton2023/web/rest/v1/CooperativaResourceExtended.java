package com.hackaton.hackaton2023.web.rest.v1;

import com.hackaton.hackaton2023.repository.CooperativaRepository;
import com.hackaton.hackaton2023.service.CooperativaQueryService;
import com.hackaton.hackaton2023.service.v1.CooperativaServiceExtended;
import com.hackaton.hackaton2023.web.rest.CooperativaResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CooperativaResourceExtended extends CooperativaResource {

    private final CooperativaServiceExtended cooperativaServiceExtended;

    public CooperativaResourceExtended(CooperativaServiceExtended cooperativaServiceExtended, CooperativaRepository cooperativaRepository, CooperativaQueryService cooperativaQueryService) {
        super(cooperativaServiceExtended, cooperativaRepository, cooperativaQueryService);
        this.cooperativaServiceExtended = cooperativaServiceExtended;
    }

}
