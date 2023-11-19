package com.hackaton.hackaton2023.service;

import com.hackaton.hackaton2023.domain.*; // for static metamodels
import com.hackaton.hackaton2023.domain.Pagamento;
import com.hackaton.hackaton2023.repository.PagamentoRepository;
import com.hackaton.hackaton2023.service.criteria.PagamentoCriteria;
import java.util.List;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Pagamento} entities in the database.
 * The main input is a {@link PagamentoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Pagamento} or a {@link Page} of {@link Pagamento} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PagamentoQueryService extends QueryService<Pagamento> {

    private final Logger log = LoggerFactory.getLogger(PagamentoQueryService.class);

    private final PagamentoRepository pagamentoRepository;

    public PagamentoQueryService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    /**
     * Return a {@link List} of {@link Pagamento} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Pagamento> findByCriteria(PagamentoCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Pagamento> specification = createSpecification(criteria);
        return pagamentoRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Pagamento} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Pagamento> findByCriteria(PagamentoCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Pagamento> specification = createSpecification(criteria);
        return pagamentoRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PagamentoCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Pagamento> specification = createSpecification(criteria);
        return pagamentoRepository.count(specification);
    }

    /**
     * Function to convert {@link PagamentoCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Pagamento> createSpecification(PagamentoCriteria criteria) {
        Specification<Pagamento> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Pagamento_.id));
            }
            if (criteria.getData() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getData(), Pagamento_.data));
            }
            if (criteria.getValor() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getValor(), Pagamento_.valor));
            }
            if (criteria.getTaxa() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTaxa(), Pagamento_.taxa));
            }
        }
        return specification;
    }
}
