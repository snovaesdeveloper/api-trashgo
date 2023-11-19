package com.hackaton.hackaton2023.service.impl;

import com.hackaton.hackaton2023.domain.RelacaoLocalColeta;
import com.hackaton.hackaton2023.repository.RelacaoLocalColetaRepository;
import com.hackaton.hackaton2023.service.RelacaoLocalColetaService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link RelacaoLocalColeta}.
 */
@Service
@Transactional
public class RelacaoLocalColetaServiceImpl implements RelacaoLocalColetaService {

    private final Logger log = LoggerFactory.getLogger(RelacaoLocalColetaServiceImpl.class);

    private final RelacaoLocalColetaRepository relacaoLocalColetaRepository;

    public RelacaoLocalColetaServiceImpl(RelacaoLocalColetaRepository relacaoLocalColetaRepository) {
        this.relacaoLocalColetaRepository = relacaoLocalColetaRepository;
    }

    @Override
    public RelacaoLocalColeta save(RelacaoLocalColeta relacaoLocalColeta) {
        log.debug("Request to save RelacaoLocalColeta : {}", relacaoLocalColeta);
        return relacaoLocalColetaRepository.save(relacaoLocalColeta);
    }

    @Override
    public Optional<RelacaoLocalColeta> partialUpdate(RelacaoLocalColeta relacaoLocalColeta) {
        log.debug("Request to partially update RelacaoLocalColeta : {}", relacaoLocalColeta);

        return relacaoLocalColetaRepository
            .findById(relacaoLocalColeta.getId())
            .map(
                existingRelacaoLocalColeta -> {
                    return existingRelacaoLocalColeta;
                }
            )
            .map(relacaoLocalColetaRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RelacaoLocalColeta> findAll(Pageable pageable) {
        log.debug("Request to get all RelacaoLocalColetas");
        return relacaoLocalColetaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RelacaoLocalColeta> findOne(Long id) {
        log.debug("Request to get RelacaoLocalColeta : {}", id);
        return relacaoLocalColetaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RelacaoLocalColeta : {}", id);
        relacaoLocalColetaRepository.deleteById(id);
    }
}
