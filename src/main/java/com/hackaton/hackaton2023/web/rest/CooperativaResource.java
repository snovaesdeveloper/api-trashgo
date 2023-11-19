package com.hackaton.hackaton2023.web.rest;

import com.hackaton.hackaton2023.domain.Cooperativa;
import com.hackaton.hackaton2023.repository.CooperativaRepository;
import com.hackaton.hackaton2023.service.CooperativaQueryService;
import com.hackaton.hackaton2023.service.CooperativaService;
import com.hackaton.hackaton2023.service.criteria.CooperativaCriteria;
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
 * REST controller for managing {@link com.hackaton.hackaton2023.domain.Cooperativa}.
 */
@RestController
@RequestMapping("/api")
public class CooperativaResource {

    private final Logger log = LoggerFactory.getLogger(CooperativaResource.class);

    private static final String ENTITY_NAME = "cooperativa";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CooperativaService cooperativaService;

    private final CooperativaRepository cooperativaRepository;

    private final CooperativaQueryService cooperativaQueryService;

    public CooperativaResource(
        CooperativaService cooperativaService,
        CooperativaRepository cooperativaRepository,
        CooperativaQueryService cooperativaQueryService
    ) {
        this.cooperativaService = cooperativaService;
        this.cooperativaRepository = cooperativaRepository;
        this.cooperativaQueryService = cooperativaQueryService;
    }

    /**
     * {@code POST  /cooperativas} : Create a new cooperativa.
     *
     * @param cooperativa the cooperativa to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cooperativa, or with status {@code 400 (Bad Request)} if the cooperativa has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cooperativas")
    public ResponseEntity<Cooperativa> createCooperativa(@RequestBody Cooperativa cooperativa) throws URISyntaxException {
        log.debug("REST request to save Cooperativa : {}", cooperativa);
        if (cooperativa.getId() != null) {
            throw new BadRequestAlertException("A new cooperativa cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Cooperativa result = cooperativaService.save(cooperativa);
        return ResponseEntity
            .created(new URI("/api/cooperativas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cooperativas/:id} : Updates an existing cooperativa.
     *
     * @param id the id of the cooperativa to save.
     * @param cooperativa the cooperativa to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cooperativa,
     * or with status {@code 400 (Bad Request)} if the cooperativa is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cooperativa couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cooperativas/{id}")
    public ResponseEntity<Cooperativa> updateCooperativa(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Cooperativa cooperativa
    ) throws URISyntaxException {
        log.debug("REST request to update Cooperativa : {}, {}", id, cooperativa);
        if (cooperativa.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cooperativa.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cooperativaRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Cooperativa result = cooperativaService.save(cooperativa);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cooperativa.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cooperativas/:id} : Partial updates given fields of an existing cooperativa, field will ignore if it is null
     *
     * @param id the id of the cooperativa to save.
     * @param cooperativa the cooperativa to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cooperativa,
     * or with status {@code 400 (Bad Request)} if the cooperativa is not valid,
     * or with status {@code 404 (Not Found)} if the cooperativa is not found,
     * or with status {@code 500 (Internal Server Error)} if the cooperativa couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cooperativas/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<Cooperativa> partialUpdateCooperativa(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Cooperativa cooperativa
    ) throws URISyntaxException {
        log.debug("REST request to partial update Cooperativa partially : {}, {}", id, cooperativa);
        if (cooperativa.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cooperativa.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cooperativaRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Cooperativa> result = cooperativaService.partialUpdate(cooperativa);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cooperativa.getId().toString())
        );
    }

    /**
     * {@code GET  /cooperativas} : get all the cooperativas.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cooperativas in body.
     */
    @GetMapping("/cooperativas")
    public ResponseEntity<List<Cooperativa>> getAllCooperativas(CooperativaCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Cooperativas by criteria: {}", criteria);
        Page<Cooperativa> page = cooperativaQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cooperativas/count} : count all the cooperativas.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/cooperativas/count")
    public ResponseEntity<Long> countCooperativas(CooperativaCriteria criteria) {
        log.debug("REST request to count Cooperativas by criteria: {}", criteria);
        return ResponseEntity.ok().body(cooperativaQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cooperativas/:id} : get the "id" cooperativa.
     *
     * @param id the id of the cooperativa to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cooperativa, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cooperativas/{id}")
    public ResponseEntity<Cooperativa> getCooperativa(@PathVariable Long id) {
        log.debug("REST request to get Cooperativa : {}", id);
        Optional<Cooperativa> cooperativa = cooperativaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cooperativa);
    }

    /**
     * {@code DELETE  /cooperativas/:id} : delete the "id" cooperativa.
     *
     * @param id the id of the cooperativa to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cooperativas/{id}")
    public ResponseEntity<Void> deleteCooperativa(@PathVariable Long id) {
        log.debug("REST request to delete Cooperativa : {}", id);
        cooperativaService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
