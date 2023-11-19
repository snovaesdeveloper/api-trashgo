package com.hackaton.hackaton2023.web.rest.v1;

import com.hackaton.hackaton2023.domain.Endereco;
import com.hackaton.hackaton2023.domain.Local;
import com.hackaton.hackaton2023.repository.LocalRepository;
import com.hackaton.hackaton2023.service.LocalQueryService;
import com.hackaton.hackaton2023.service.v1.EnderecoServiceExtended;
import com.hackaton.hackaton2023.service.v1.LocalServiceExtended;
import com.hackaton.hackaton2023.web.rest.LocalResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1")
public class LocalResourceExtended extends LocalResource {

    private final LocalServiceExtended localServiceExtended;
    private final EnderecoServiceExtended enderecoServiceExtended;

    public LocalResourceExtended(LocalServiceExtended localServiceExtended, LocalRepository localRepository, LocalQueryService localQueryService, EnderecoServiceExtended enderecoServiceExtended) {
        super(localServiceExtended, localRepository, localQueryService);
        this.localServiceExtended = localServiceExtended;
        this.enderecoServiceExtended = enderecoServiceExtended;
    }

    @Override
    public ResponseEntity<Local> createLocal(@RequestBody Local local) throws URISyntaxException {
        local.setEndereco(enderecoServiceExtended.save(local.getEndereco()));
        return super.createLocal(local);
    }

    @Override
    public ResponseEntity<Local> updateLocal(@PathVariable(value = "id", required = false) final Long id, @RequestBody Local local) throws URISyntaxException {
        if(local.getEndereco() != null)
            enderecoServiceExtended.save(local.getEndereco());
        return super.updateLocal(id, local);
    }

}
