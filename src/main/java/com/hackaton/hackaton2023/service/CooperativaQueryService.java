package com.hackaton.hackaton2023.service;

import com.hackaton.hackaton2023.domain.*; // for static metamodels
import com.hackaton.hackaton2023.domain.Cooperativa;
import com.hackaton.hackaton2023.repository.CooperativaRepository;
import com.hackaton.hackaton2023.service.criteria.CooperativaCriteria;
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
 * Service for executing complex queries for {@link Cooperativa} entities in the database.
 * The main input is a {@link CooperativaCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Cooperativa} or a {@link Page} of {@link Cooperativa} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CooperativaQueryService extends QueryService<Cooperativa> {

    private final Logger log = LoggerFactory.getLogger(CooperativaQueryService.class);

    private final CooperativaRepository cooperativaRepository;

    public CooperativaQueryService(CooperativaRepository cooperativaRepository) {
        this.cooperativaRepository = cooperativaRepository;
    }

    /**
     * Return a {@link List} of {@link Cooperativa} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Cooperativa> findByCriteria(CooperativaCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Cooperativa> specification = createSpecification(criteria);
        return cooperativaRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Cooperativa} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Cooperativa> findByCriteria(CooperativaCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Cooperativa> specification = createSpecification(criteria);
        return cooperativaRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CooperativaCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Cooperativa> specification = createSpecification(criteria);
        return cooperativaRepository.count(specification);
    }

    /**
     * Function to convert {@link CooperativaCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Cooperativa> createSpecification(CooperativaCriteria criteria) {
        Specification<Cooperativa> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Cooperativa_.id));
            }
            if (criteria.getNome() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNome(), Cooperativa_.nome));
            }
            if (criteria.getUsuarioId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getUsuarioId(), root -> root.join(Cooperativa_.usuario, JoinType.LEFT).get(Usuario_.id))
                    );
            }
            if (criteria.getColetaId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getColetaId(), root -> root.join(Cooperativa_.coletas, JoinType.LEFT).get(Coleta_.id))
                    );
            }
        }
        return specification;
    }
}
