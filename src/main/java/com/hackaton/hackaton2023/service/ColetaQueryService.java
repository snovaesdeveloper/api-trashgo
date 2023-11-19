package com.hackaton.hackaton2023.service;

import com.hackaton.hackaton2023.domain.*; // for static metamodels
import com.hackaton.hackaton2023.domain.Coleta;
import com.hackaton.hackaton2023.repository.ColetaRepository;
import com.hackaton.hackaton2023.service.criteria.ColetaCriteria;
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
 * Service for executing complex queries for {@link Coleta} entities in the database.
 * The main input is a {@link ColetaCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Coleta} or a {@link Page} of {@link Coleta} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ColetaQueryService extends QueryService<Coleta> {

    private final Logger log = LoggerFactory.getLogger(ColetaQueryService.class);

    private final ColetaRepository coletaRepository;

    public ColetaQueryService(ColetaRepository coletaRepository) {
        this.coletaRepository = coletaRepository;
    }

    /**
     * Return a {@link List} of {@link Coleta} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Coleta> findByCriteria(ColetaCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Coleta> specification = createSpecification(criteria);
        return coletaRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Coleta} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Coleta> findByCriteria(ColetaCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Coleta> specification = createSpecification(criteria);
        return coletaRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ColetaCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Coleta> specification = createSpecification(criteria);
        return coletaRepository.count(specification);
    }

    /**
     * Function to convert {@link ColetaCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Coleta> createSpecification(ColetaCriteria criteria) {
        Specification<Coleta> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Coleta_.id));
            }
            if (criteria.getData() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getData(), Coleta_.data));
            }
            if (criteria.getPontosColeta() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPontosColeta(), Coleta_.pontosColeta));
            }
            if (criteria.getStatus() != null) {
                specification = specification.and(buildSpecification(criteria.getStatus(), Coleta_.status));
            }
            if (criteria.getCooperativaId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getCooperativaId(),
                            root -> root.join(Coleta_.cooperativa, JoinType.LEFT).get(Cooperativa_.id)
                        )
                    );
            }
            if (criteria.getPontosColetaId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getPontosColetaId(),
                            root -> root.join(Coleta_.pontosColetas, JoinType.LEFT).get(RelacaoLocalColeta_.id)
                        )
                    );
            }
        }
        return specification;
    }
}
