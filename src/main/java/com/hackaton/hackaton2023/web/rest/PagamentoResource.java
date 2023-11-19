package com.hackaton.hackaton2023.web.rest;

import com.hackaton.hackaton2023.domain.Pagamento;
import com.hackaton.hackaton2023.repository.PagamentoRepository;
import com.hackaton.hackaton2023.service.PagamentoQueryService;
import com.hackaton.hackaton2023.service.PagamentoService;
import com.hackaton.hackaton2023.service.criteria.PagamentoCriteria;
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
 * REST controller for managing {@link com.hackaton.hackaton2023.domain.Pagamento}.
 */
@RestController
@RequestMapping("/api")
public class PagamentoResource {

    private final Logger log = LoggerFactory.getLogger(PagamentoResource.class);

    private static final String ENTITY_NAME = "pagamento";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PagamentoService pagamentoService;

    private final PagamentoRepository pagamentoRepository;

    private final PagamentoQueryService pagamentoQueryService;

    public PagamentoResource(
        PagamentoService pagamentoService,
        PagamentoRepository pagamentoRepository,
        PagamentoQueryService pagamentoQueryService
    ) {
        this.pagamentoService = pagamentoService;
        this.pagamentoRepository = pagamentoRepository;
        this.pagamentoQueryService = pagamentoQueryService;
    }

    /**
     * {@code POST  /pagamentos} : Create a new pagamento.
     *
     * @param pagamento the pagamento to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pagamento, or with status {@code 400 (Bad Request)} if the pagamento has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pagamentos")
    public ResponseEntity<Pagamento> createPagamento(@RequestBody Pagamento pagamento) throws URISyntaxException {
        log.debug("REST request to save Pagamento : {}", pagamento);
        if (pagamento.getId() != null) {
            throw new BadRequestAlertException("A new pagamento cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Pagamento result = pagamentoService.save(pagamento);
        return ResponseEntity
            .created(new URI("/api/pagamentos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /pagamentos/:id} : Updates an existing pagamento.
     *
     * @param id the id of the pagamento to save.
     * @param pagamento the pagamento to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pagamento,
     * or with status {@code 400 (Bad Request)} if the pagamento is not valid,
     * or with status {@code 500 (Internal Server Error)} if the pagamento couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/pagamentos/{id}")
    public ResponseEntity<Pagamento> updatePagamento(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Pagamento pagamento
    ) throws URISyntaxException {
        log.debug("REST request to update Pagamento : {}, {}", id, pagamento);
        if (pagamento.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, pagamento.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!pagamentoRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Pagamento result = pagamentoService.save(pagamento);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, pagamento.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /pagamentos/:id} : Partial updates given fields of an existing pagamento, field will ignore if it is null
     *
     * @param id the id of the pagamento to save.
     * @param pagamento the pagamento to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pagamento,
     * or with status {@code 400 (Bad Request)} if the pagamento is not valid,
     * or with status {@code 404 (Not Found)} if the pagamento is not found,
     * or with status {@code 500 (Internal Server Error)} if the pagamento couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/pagamentos/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<Pagamento> partialUpdatePagamento(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Pagamento pagamento
    ) throws URISyntaxException {
        log.debug("REST request to partial update Pagamento partially : {}, {}", id, pagamento);
        if (pagamento.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, pagamento.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!pagamentoRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Pagamento> result = pagamentoService.partialUpdate(pagamento);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, pagamento.getId().toString())
        );
    }

    /**
     * {@code GET  /pagamentos} : get all the pagamentos.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pagamentos in body.
     */
    @GetMapping("/pagamentos")
    public ResponseEntity<List<Pagamento>> getAllPagamentos(PagamentoCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Pagamentos by criteria: {}", criteria);
        Page<Pagamento> page = pagamentoQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /pagamentos/count} : count all the pagamentos.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/pagamentos/count")
    public ResponseEntity<Long> countPagamentos(PagamentoCriteria criteria) {
        log.debug("REST request to count Pagamentos by criteria: {}", criteria);
        return ResponseEntity.ok().body(pagamentoQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /pagamentos/:id} : get the "id" pagamento.
     *
     * @param id the id of the pagamento to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pagamento, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pagamentos/{id}")
    public ResponseEntity<Pagamento> getPagamento(@PathVariable Long id) {
        log.debug("REST request to get Pagamento : {}", id);
        Optional<Pagamento> pagamento = pagamentoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pagamento);
    }

    /**
     * {@code DELETE  /pagamentos/:id} : delete the "id" pagamento.
     *
     * @param id the id of the pagamento to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/pagamentos/{id}")
    public ResponseEntity<Void> deletePagamento(@PathVariable Long id) {
        log.debug("REST request to delete Pagamento : {}", id);
        pagamentoService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
