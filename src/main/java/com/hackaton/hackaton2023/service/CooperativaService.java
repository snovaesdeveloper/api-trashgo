package com.hackaton.hackaton2023.service;

import com.hackaton.hackaton2023.domain.Cooperativa;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Cooperativa}.
 */
public interface CooperativaService {
    /**
     * Save a cooperativa.
     *
     * @param cooperativa the entity to save.
     * @return the persisted entity.
     */
    Cooperativa save(Cooperativa cooperativa);

    /**
     * Partially updates a cooperativa.
     *
     * @param cooperativa the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Cooperativa> partialUpdate(Cooperativa cooperativa);

    /**
     * Get all the cooperativas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Cooperativa> findAll(Pageable pageable);

    /**
     * Get the "id" cooperativa.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Cooperativa> findOne(Long id);

    /**
     * Delete the "id" cooperativa.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
