package com.hackaton.hackaton2023.service;

import com.hackaton.hackaton2023.domain.Coleta;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Coleta}.
 */
public interface ColetaService {
    /**
     * Save a coleta.
     *
     * @param coleta the entity to save.
     * @return the persisted entity.
     */
    Coleta save(Coleta coleta);

    /**
     * Partially updates a coleta.
     *
     * @param coleta the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Coleta> partialUpdate(Coleta coleta);

    /**
     * Get all the coletas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Coleta> findAll(Pageable pageable);

    /**
     * Get the "id" coleta.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Coleta> findOne(Long id);

    /**
     * Delete the "id" coleta.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
