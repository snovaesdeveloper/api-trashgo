package com.hackaton.hackaton2023.service;

import com.hackaton.hackaton2023.domain.*; // for static metamodels
import com.hackaton.hackaton2023.domain.Local;
import com.hackaton.hackaton2023.repository.LocalRepository;
import com.hackaton.hackaton2023.service.criteria.LocalCriteria;
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
 * Service for executing complex queries for {@link Local} entities in the database.
 * The main input is a {@link LocalCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Local} or a {@link Page} of {@link Local} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class LocalQueryService extends QueryService<Local> {

    private final Logger log = LoggerFactory.getLogger(LocalQueryService.class);

    private final LocalRepository localRepository;

    public LocalQueryService(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    /**
     * Return a {@link List} of {@link Local} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Local> findByCriteria(LocalCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Local> specification = createSpecification(criteria);
        return localRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Local} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Local> findByCriteria(LocalCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Local> specification = createSpecification(criteria);
        return localRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(LocalCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Local> specification = createSpecification(criteria);
        return localRepository.count(specification);
    }

    /**
     * Function to convert {@link LocalCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Local> createSpecification(LocalCriteria criteria) {
        Specification<Local> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Local_.id));
            }
            if (criteria.getNome() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNome(), Local_.nome));
            }
            if (criteria.getTipo() != null) {
                specification = specification.and(buildSpecification(criteria.getTipo(), Local_.tipo));
            }
            if (criteria.getEnderecoId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getEnderecoId(), root -> root.join(Local_.endereco, JoinType.LEFT).get(Endereco_.id))
                    );
            }
            if (criteria.getUsuarioId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getUsuarioId(), root -> root.join(Local_.usuario, JoinType.LEFT).get(Usuario_.id))
                    );
            }
            if (criteria.getRelacaoLocalColetaId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getRelacaoLocalColetaId(),
                            root -> root.join(Local_.relacaoLocalColetas, JoinType.LEFT).get(RelacaoLocalColeta_.id)
                        )
                    );
            }
        }
        return specification;
    }
}
