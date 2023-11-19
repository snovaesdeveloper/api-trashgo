package com.hackaton.hackaton2023.web.rest.v1;

import com.hackaton.hackaton2023.domain.Coleta;
import com.hackaton.hackaton2023.domain.RelacaoLocalColeta;
import com.hackaton.hackaton2023.repository.ColetaRepository;
import com.hackaton.hackaton2023.service.ColetaQueryService;
import com.hackaton.hackaton2023.service.RelacaoLocalColetaService;
import com.hackaton.hackaton2023.service.v1.ColetaServiceExtended;
import com.hackaton.hackaton2023.service.v1.RelacaoLocalColetaServiceExtended;
import com.hackaton.hackaton2023.web.rest.ColetaResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class ColetaResourceExtended extends ColetaResource {

    private final ColetaServiceExtended coletaServiceExtended;
    private final RelacaoLocalColetaServiceExtended relacaoLocalColetaServiceExtended;

    public ColetaResourceExtended(ColetaServiceExtended coletaServiceExtended, ColetaRepository coletaRepository, ColetaQueryService coletaQueryService, RelacaoLocalColetaServiceExtended relacaoLocalColetaServiceExtended) {
        super(coletaServiceExtended, coletaRepository, coletaQueryService);
        this.coletaServiceExtended = coletaServiceExtended;
        this.relacaoLocalColetaServiceExtended = relacaoLocalColetaServiceExtended;
    }

    @Override
    public ResponseEntity<Coleta> createColeta(@RequestBody Coleta coleta) throws URISyntaxException {
        Set<RelacaoLocalColeta> pontosColeta = coleta.getPontosColetas();
        coleta.setPontosColetas(null);
        coleta.setPontosColeta(pontosColeta.size());
        Coleta coletaSaved = super.createColeta(coleta).getBody();
        pontosColeta.forEach(relacaoLocalColeta -> {
            relacaoLocalColeta.setColeta(coletaSaved);
            relacaoLocalColetaServiceExtended.save(relacaoLocalColeta);
        });
        return ResponseEntity.ok().body(coletaSaved);
    }

    @Override
    public ResponseEntity<Coleta> updateColeta(@PathVariable(value = "id", required = false) final Long id, @RequestBody Coleta coleta) throws URISyntaxException {
        Set<RelacaoLocalColeta> pontosColeta = coleta.getPontosColetas();
        coleta.setPontosColetas(null);
        coleta.setPontosColeta(pontosColeta.size());
        Coleta coletaSaved = super.updateColeta(id, coleta).getBody();
        relacaoLocalColetaServiceExtended.deleteByColetaId(coleta.getId());
        pontosColeta.forEach(relacaoLocalColeta -> {
            relacaoLocalColeta.setColeta(coletaSaved);
            relacaoLocalColetaServiceExtended.save(relacaoLocalColeta);
        });
        return ResponseEntity.ok().body(coletaSaved);
    }

}
