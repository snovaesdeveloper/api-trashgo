package com.hackaton.hackaton2023.service;

import com.hackaton.hackaton2023.domain.Endereco;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Endereco}.
 */
public interface EnderecoService {
    /**
     * Save a endereco.
     *
     * @param endereco the entity to save.
     * @return the persisted entity.
     */
    Endereco save(Endereco endereco);

    /**
     * Partially updates a endereco.
     *
     * @param endereco the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Endereco> partialUpdate(Endereco endereco);

    /**
     * Get all the enderecos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Endereco> findAll(Pageable pageable);
    /**
     * Get all the Endereco where Local is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<Endereco> findAllWhereLocalIsNull();

    /**
     * Get the "id" endereco.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Endereco> findOne(Long id);

    /**
     * Delete the "id" endereco.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
