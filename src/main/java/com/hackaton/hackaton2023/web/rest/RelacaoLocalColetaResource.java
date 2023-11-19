package com.hackaton.hackaton2023.web.rest;

import com.hackaton.hackaton2023.domain.RelacaoLocalColeta;
import com.hackaton.hackaton2023.repository.RelacaoLocalColetaRepository;
import com.hackaton.hackaton2023.service.RelacaoLocalColetaQueryService;
import com.hackaton.hackaton2023.service.RelacaoLocalColetaService;
import com.hackaton.hackaton2023.service.criteria.RelacaoLocalColetaCriteria;
import com.hackaton.hackaton2023.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.hackaton.hackaton2023.domain.RelacaoLocalColeta}.
 */
@RestController
@RequestMapping("/api")
public class RelacaoLocalColetaResource {

    private final Logger log = LoggerFactory.getLogger(RelacaoLocalColetaResource.class);

    private static final String ENTITY_NAME = "relacaoLocalColeta";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RelacaoLocalColetaService relacaoLocalColetaService;

    private final RelacaoLocalColetaRepository relacaoLocalColetaRepository;

    private final RelacaoLocalColetaQueryService relacaoLocalColetaQueryService;

    public RelacaoLocalColetaResource(
        RelacaoLocalColetaService relacaoLocalColetaService,
        RelacaoLocalColetaRepository relacaoLocalColetaRepository,
        RelacaoLocalColetaQueryService relacaoLocalColetaQueryService
    ) {
        this.relacaoLocalColetaService = relacaoLocalColetaService;
        this.relacaoLocalColetaRepository = relacaoLocalColetaRepository;
        this.relacaoLocalColetaQueryService = relacaoLocalColetaQueryService;
    }

    /**
     * {@code POST  /relacao-local-coletas} : Create a new relacaoLocalColeta.
     *
     * @param relacaoLocalColeta the relacaoLocalColeta to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new relacaoLocalColeta, or with status {@code 400 (Bad Request)} if the relacaoLocalColeta has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/relacao-local-coletas")
    public ResponseEntity<RelacaoLocalColeta> createRelacaoLocalColeta(@RequestBody RelacaoLocalColeta relacaoLocalColeta)
        throws URISyntaxException {
        log.debug("REST request to save RelacaoLocalColeta : {}", relacaoLocalColeta);
        if (relacaoLocalColeta.getId() != null) {
            throw new BadRequestAlertException("A new relacaoLocalColeta cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RelacaoLocalColeta result = relacaoLocalColetaService.save(relacaoLocalColeta);
        return ResponseEntity
            .created(new URI("/api/relacao-local-coletas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /relacao-local-coletas/:id} : Updates an existing relacaoLocalColeta.
     *
     * @param id the id of the relacaoLocalColeta to save.
     * @param relacaoLocalColeta the relacaoLocalColeta to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated relacaoLocalColeta,
     * or with status {@code 400 (Bad Request)} if the relacaoLocalColeta is not valid,
     * or with status {@code 500 (Internal Server Error)} if the relacaoLocalColeta couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/relacao-local-coletas/{id}")
    public ResponseEntity<RelacaoLocalColeta> updateRelacaoLocalColeta(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody RelacaoLocalColeta relacaoLocalColeta
    ) throws URISyntaxException {
        log.debug("REST request to update RelacaoLocalColeta : {}, {}", id, relacaoLocalColeta);
        if (relacaoLocalColeta.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, relacaoLocalColeta.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!relacaoLocalColetaRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        RelacaoLocalColeta result = relacaoLocalColetaService.save(relacaoLocalColeta);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, relacaoLocalColeta.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /relacao-local-coletas/:id} : Partial updates given fields of an existing relacaoLocalColeta, field will ignore if it is null
     *
     * @param id the id of the relacaoLocalColeta to save.
     * @param relacaoLocalColeta the relacaoLocalColeta to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated relacaoLocalColeta,
     * or with status {@code 400 (Bad Request)} if the relacaoLocalColeta is not valid,
     * or with status {@code 404 (Not Found)} if the relacaoLocalColeta is not found,
     * or with status {@code 500 (Internal Server Error)} if the relacaoLocalColeta couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/relacao-local-coletas/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<RelacaoLocalColeta> partialUpdateRelacaoLocalColeta(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody RelacaoLocalColeta relacaoLocalColeta
    ) throws URISyntaxException {
        log.debug("REST request to partial update RelacaoLocalColeta partially : {}, {}", id, relacaoLocalColeta);
        if (relacaoLocalColeta.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, relacaoLocalColeta.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!relacaoLocalColetaRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<RelacaoLocalColeta> result = relacaoLocalColetaService.partialUpdate(relacaoLocalColeta);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, relacaoLocalColeta.getId().toString())
        );
    }

    /**
     * {@code GET  /relacao-local-coletas} : get all the relacaoLocalColetas.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of relacaoLocalColetas in body.
     */
    @GetMapping("/relacao-local-coletas")
    public ResponseEntity<List<RelacaoLocalColeta>> getAllRelacaoLocalColetas(RelacaoLocalColetaCriteria criteria, Pageable pageable) {
        log.debug("REST request to get RelacaoLocalColetas by criteria: {}", criteria);
        Page<RelacaoLocalColeta> page = relacaoLocalColetaQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /relacao-local-coletas/count} : count all the relacaoLocalColetas.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/relacao-local-coletas/count")
    public ResponseEntity<Long> countRelacaoLocalColetas(RelacaoLocalColetaCriteria criteria) {
        log.debug("REST request to count RelacaoLocalColetas by criteria: {}", criteria);
        return ResponseEntity.ok().body(relacaoLocalColetaQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /relacao-local-coletas/:id} : get the "id" relacaoLocalColeta.
     *
     * @param id the id of the relacaoLocalColeta to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the relacaoLocalColeta, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/relacao-local-coletas/{id}")
    public ResponseEntity<RelacaoLocalColeta> getRelacaoLocalColeta(@PathVariable Long id) {
        log.debug("REST request to get RelacaoLocalColeta : {}", id);
        Optional<RelacaoLocalColeta> relacaoLocalColeta = relacaoLocalColetaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(relacaoLocalColeta);
    }

    /**
     * {@code DELETE  /relacao-local-coletas/:id} : delete the "id" relacaoLocalColeta.
     *
     * @param id the id of the relacaoLocalColeta to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/relacao-local-coletas/{id}")
    public ResponseEntity<Void> deleteRelacaoLocalColeta(@PathVariable Long id) {
        log.debug("REST request to delete RelacaoLocalColeta : {}", id);
        relacaoLocalColetaService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
