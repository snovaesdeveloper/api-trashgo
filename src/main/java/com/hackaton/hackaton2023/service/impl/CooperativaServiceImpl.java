package com.hackaton.hackaton2023.service.impl;

import com.hackaton.hackaton2023.domain.Cooperativa;
import com.hackaton.hackaton2023.repository.CooperativaRepository;
import com.hackaton.hackaton2023.service.CooperativaService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Cooperativa}.
 */
@Service
@Transactional
public class CooperativaServiceImpl implements CooperativaService {

    private final Logger log = LoggerFactory.getLogger(CooperativaServiceImpl.class);

    private final CooperativaRepository cooperativaRepository;

    public CooperativaServiceImpl(CooperativaRepository cooperativaRepository) {
        this.cooperativaRepository = cooperativaRepository;
    }

    @Override
    public Cooperativa save(Cooperativa cooperativa) {
        log.debug("Request to save Cooperativa : {}", cooperativa);
        return cooperativaRepository.save(cooperativa);
    }

    @Override
    public Optional<Cooperativa> partialUpdate(Cooperativa cooperativa) {
        log.debug("Request to partially update Cooperativa : {}", cooperativa);

        return cooperativaRepository
            .findById(cooperativa.getId())
            .map(
                existingCooperativa -> {
                    if (cooperativa.getNome() != null) {
                        existingCooperativa.setNome(cooperativa.getNome());
                    }

                    return existingCooperativa;
                }
            )
            .map(cooperativaRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cooperativa> findAll(Pageable pageable) {
        log.debug("Request to get all Cooperativas");
        return cooperativaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cooperativa> findOne(Long id) {
        log.debug("Request to get Cooperativa : {}", id);
        return cooperativaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Cooperativa : {}", id);
        cooperativaRepository.deleteById(id);
    }
}
