package com.hackaton.hackaton2023.service;

import com.hackaton.hackaton2023.domain.*; // for static metamodels
import com.hackaton.hackaton2023.domain.Endereco;
import com.hackaton.hackaton2023.repository.EnderecoRepository;
import com.hackaton.hackaton2023.service.criteria.EnderecoCriteria;
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
 * Service for executing complex queries for {@link Endereco} entities in the database.
 * The main input is a {@link EnderecoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Endereco} or a {@link Page} of {@link Endereco} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class EnderecoQueryService extends QueryService<Endereco> {

    private final Logger log = LoggerFactory.getLogger(EnderecoQueryService.class);

    private final EnderecoRepository enderecoRepository;

    public EnderecoQueryService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    /**
     * Return a {@link List} of {@link Endereco} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Endereco> findByCriteria(EnderecoCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Endereco> specification = createSpecification(criteria);
        return enderecoRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Endereco} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Endereco> findByCriteria(EnderecoCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Endereco> specification = createSpecification(criteria);
        return enderecoRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(EnderecoCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Endereco> specification = createSpecification(criteria);
        return enderecoRepository.count(specification);
    }

    /**
     * Function to convert {@link EnderecoCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Endereco> createSpecification(EnderecoCriteria criteria) {
        Specification<Endereco> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Endereco_.id));
            }
            if (criteria.getCep() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCep(), Endereco_.cep));
            }
            if (criteria.getUf() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUf(), Endereco_.uf));
            }
            if (criteria.getCidade() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCidade(), Endereco_.cidade));
            }
            if (criteria.getBairro() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBairro(), Endereco_.bairro));
            }
            if (criteria.getLogradouro() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLogradouro(), Endereco_.logradouro));
            }
            if (criteria.getNumero() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNumero(), Endereco_.numero));
            }
            if (criteria.getComplemento() != null) {
                specification = specification.and(buildStringSpecification(criteria.getComplemento(), Endereco_.complemento));
            }
            if (criteria.getLatitude() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLatitude(), Endereco_.latitude));
            }
            if (criteria.getLongitude() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLongitude(), Endereco_.longitude));
            }
            if (criteria.getLocalId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getLocalId(), root -> root.join(Endereco_.local, JoinType.LEFT).get(Local_.id))
                    );
            }
        }
        return specification;
    }
}
