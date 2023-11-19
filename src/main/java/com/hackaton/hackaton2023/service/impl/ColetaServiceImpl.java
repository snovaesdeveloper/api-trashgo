package com.hackaton.hackaton2023.service.impl;

import com.hackaton.hackaton2023.domain.Coleta;
import com.hackaton.hackaton2023.repository.ColetaRepository;
import com.hackaton.hackaton2023.service.ColetaService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Coleta}.
 */
@Service
@Transactional
public class ColetaServiceImpl implements ColetaService {

    private final Logger log = LoggerFactory.getLogger(ColetaServiceImpl.class);

    private final ColetaRepository coletaRepository;

    public ColetaServiceImpl(ColetaRepository coletaRepository) {
        this.coletaRepository = coletaRepository;
    }

    @Override
    public Coleta save(Coleta coleta) {
        log.debug("Request to save Coleta : {}", coleta);
        return coletaRepository.save(coleta);
    }

    @Override
    public Optional<Coleta> partialUpdate(Coleta coleta) {
        log.debug("Request to partially update Coleta : {}", coleta);

        return coletaRepository
            .findById(coleta.getId())
            .map(
                existingColeta -> {
                    if (coleta.getData() != null) {
                        existingColeta.setData(coleta.getData());
                    }
                    if (coleta.getPontosColeta() != null) {
                        existingColeta.setPontosColeta(coleta.getPontosColeta());
                    }
                    if (coleta.getStatus() != null) {
                        existingColeta.setStatus(coleta.getStatus());
                    }

                    return existingColeta;
                }
            )
            .map(coletaRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Coleta> findAll(Pageable pageable) {
        log.debug("Request to get all Coletas");
        return coletaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Coleta> findOne(Long id) {
        log.debug("Request to get Coleta : {}", id);
        return coletaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Coleta : {}", id);
        coletaRepository.deleteById(id);
    }
}
