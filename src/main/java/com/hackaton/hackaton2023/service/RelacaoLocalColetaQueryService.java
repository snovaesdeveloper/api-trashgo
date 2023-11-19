package com.hackaton.hackaton2023.service;

import com.hackaton.hackaton2023.domain.*; // for static metamodels
import com.hackaton.hackaton2023.domain.RelacaoLocalColeta;
import com.hackaton.hackaton2023.repository.RelacaoLocalColetaRepository;
import com.hackaton.hackaton2023.service.criteria.RelacaoLocalColetaCriteria;
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
 * Service for executing complex queries for {@link RelacaoLocalColeta} entities in the database.
 * The main input is a {@link RelacaoLocalColetaCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link RelacaoLocalColeta} or a {@link Page} of {@link RelacaoLocalColeta} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class RelacaoLocalColetaQueryService extends QueryService<RelacaoLocalColeta> {

    private final Logger log = LoggerFactory.getLogger(RelacaoLocalColetaQueryService.class);

    private final RelacaoLocalColetaRepository relacaoLocalColetaRepository;

    public RelacaoLocalColetaQueryService(RelacaoLocalColetaRepository relacaoLocalColetaRepository) {
        this.relacaoLocalColetaRepository = relacaoLocalColetaRepository;
    }

    /**
     * Return a {@link List} of {@link RelacaoLocalColeta} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<RelacaoLocalColeta> findByCriteria(RelacaoLocalColetaCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<RelacaoLocalColeta> specification = createSpecification(criteria);
        return relacaoLocalColetaRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link RelacaoLocalColeta} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<RelacaoLocalColeta> findByCriteria(RelacaoLocalColetaCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<RelacaoLocalColeta> specification = createSpecification(criteria);
        return relacaoLocalColetaRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(RelacaoLocalColetaCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<RelacaoLocalColeta> specification = createSpecification(criteria);
        return relacaoLocalColetaRepository.count(specification);
    }

    /**
     * Function to convert {@link RelacaoLocalColetaCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<RelacaoLocalColeta> createSpecification(RelacaoLocalColetaCriteria criteria) {
        Specification<RelacaoLocalColeta> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), RelacaoLocalColeta_.id));
            }
            if (criteria.getLocalId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getLocalId(),
                            root -> root.join(RelacaoLocalColeta_.local, JoinType.LEFT).get(Local_.id)
                        )
                    );
            }
            if (criteria.getColetaId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getColetaId(),
                            root -> root.join(RelacaoLocalColeta_.coleta, JoinType.LEFT).get(Coleta_.id)
                        )
                    );
            }
        }
        return specification;
    }
}
