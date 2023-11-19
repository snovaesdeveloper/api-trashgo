package com.hackaton.hackaton2023.service;

import com.hackaton.hackaton2023.domain.RelacaoLocalColeta;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link RelacaoLocalColeta}.
 */
public interface RelacaoLocalColetaService {
    /**
     * Save a relacaoLocalColeta.
     *
     * @param relacaoLocalColeta the entity to save.
     * @return the persisted entity.
     */
    RelacaoLocalColeta save(RelacaoLocalColeta relacaoLocalColeta);

    /**
     * Partially updates a relacaoLocalColeta.
     *
     * @param relacaoLocalColeta the entity to update partially.
     * @return the persisted entity.
     */
    Optional<RelacaoLocalColeta> partialUpdate(RelacaoLocalColeta relacaoLocalColeta);

    /**
     * Get all the relacaoLocalColetas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<RelacaoLocalColeta> findAll(Pageable pageable);

    /**
     * Get the "id" relacaoLocalColeta.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RelacaoLocalColeta> findOne(Long id);

    /**
     * Delete the "id" relacaoLocalColeta.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
