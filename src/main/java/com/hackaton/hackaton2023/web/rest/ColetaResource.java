package com.hackaton.hackaton2023.web.rest;

import com.hackaton.hackaton2023.domain.Coleta;
import com.hackaton.hackaton2023.repository.ColetaRepository;
import com.hackaton.hackaton2023.service.ColetaQueryService;
import com.hackaton.hackaton2023.service.ColetaService;
import com.hackaton.hackaton2023.service.criteria.ColetaCriteria;
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
 * REST controller for managing {@link com.hackaton.hackaton2023.domain.Coleta}.
 */
@RestController
@RequestMapping("/api")
public class ColetaResource {

    private final Logger log = LoggerFactory.getLogger(ColetaResource.class);

    private static final String ENTITY_NAME = "coleta";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ColetaService coletaService;

    private final ColetaRepository coletaRepository;

    private final ColetaQueryService coletaQueryService;

    public ColetaResource(ColetaService coletaService, ColetaRepository coletaRepository, ColetaQueryService coletaQueryService) {
        this.coletaService = coletaService;
        this.coletaRepository = coletaRepository;
        this.coletaQueryService = coletaQueryService;
    }

    /**
     * {@code POST  /coletas} : Create a new coleta.
     *
     * @param coleta the coleta to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new coleta, or with status {@code 400 (Bad Request)} if the coleta has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/coletas")
    public ResponseEntity<Coleta> createColeta(@RequestBody Coleta coleta) throws URISyntaxException {
        log.debug("REST request to save Coleta : {}", coleta);
        if (coleta.getId() != null) {
            throw new BadRequestAlertException("A new coleta cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Coleta result = coletaService.save(coleta);
        return ResponseEntity
            .created(new URI("/api/coletas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /coletas/:id} : Updates an existing coleta.
     *
     * @param id the id of the coleta to save.
     * @param coleta the coleta to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated coleta,
     * or with status {@code 400 (Bad Request)} if the coleta is not valid,
     * or with status {@code 500 (Internal Server Error)} if the coleta couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/coletas/{id}")
    public ResponseEntity<Coleta> updateColeta(@PathVariable(value = "id", required = false) final Long id, @RequestBody Coleta coleta)
        throws URISyntaxException {
        log.debug("REST request to update Coleta : {}, {}", id, coleta);
        if (coleta.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, coleta.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!coletaRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Coleta result = coletaService.save(coleta);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, coleta.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /coletas/:id} : Partial updates given fields of an existing coleta, field will ignore if it is null
     *
     * @param id the id of the coleta to save.
     * @param coleta the coleta to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated coleta,
     * or with status {@code 400 (Bad Request)} if the coleta is not valid,
     * or with status {@code 404 (Not Found)} if the coleta is not found,
     * or with status {@code 500 (Internal Server Error)} if the coleta couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/coletas/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<Coleta> partialUpdateColeta(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Coleta coleta
    ) throws URISyntaxException {
        log.debug("REST request to partial update Coleta partially : {}, {}", id, coleta);
        if (coleta.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, coleta.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!coletaRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Coleta> result = coletaService.partialUpdate(coleta);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, coleta.getId().toString())
        );
    }

    /**
     * {@code GET  /coletas} : get all the coletas.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of coletas in body.
     */
    @GetMapping("/coletas")
    public ResponseEntity<List<Coleta>> getAllColetas(ColetaCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Coletas by criteria: {}", criteria);
        Page<Coleta> page = coletaQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /coletas/count} : count all the coletas.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/coletas/count")
    public ResponseEntity<Long> countColetas(ColetaCriteria criteria) {
        log.debug("REST request to count Coletas by criteria: {}", criteria);
        return ResponseEntity.ok().body(coletaQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /coletas/:id} : get the "id" coleta.
     *
     * @param id the id of the coleta to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the coleta, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/coletas/{id}")
    public ResponseEntity<Coleta> getColeta(@PathVariable Long id) {
        log.debug("REST request to get Coleta : {}", id);
        Optional<Coleta> coleta = coletaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(coleta);
    }

    /**
     * {@code DELETE  /coletas/:id} : delete the "id" coleta.
     *
     * @param id the id of the coleta to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/coletas/{id}")
    public ResponseEntity<Void> deleteColeta(@PathVariable Long id) {
        log.debug("REST request to delete Coleta : {}", id);
        coletaService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
