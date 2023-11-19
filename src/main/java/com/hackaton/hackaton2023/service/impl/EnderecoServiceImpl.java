package com.hackaton.hackaton2023.service.impl;

import com.hackaton.hackaton2023.domain.Endereco;
import com.hackaton.hackaton2023.repository.EnderecoRepository;
import com.hackaton.hackaton2023.service.EnderecoService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Endereco}.
 */
@Service
@Transactional
public class EnderecoServiceImpl implements EnderecoService {

    private final Logger log = LoggerFactory.getLogger(EnderecoServiceImpl.class);

    private final EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco save(Endereco endereco) {
        log.debug("Request to save Endereco : {}", endereco);
        return enderecoRepository.save(endereco);
    }

    @Override
    public Optional<Endereco> partialUpdate(Endereco endereco) {
        log.debug("Request to partially update Endereco : {}", endereco);

        return enderecoRepository
            .findById(endereco.getId())
            .map(
                existingEndereco -> {
                    if (endereco.getCep() != null) {
                        existingEndereco.setCep(endereco.getCep());
                    }
                    if (endereco.getUf() != null) {
                        existingEndereco.setUf(endereco.getUf());
                    }
                    if (endereco.getCidade() != null) {
                        existingEndereco.setCidade(endereco.getCidade());
                    }
                    if (endereco.getBairro() != null) {
                        existingEndereco.setBairro(endereco.getBairro());
                    }
                    if (endereco.getLogradouro() != null) {
                        existingEndereco.setLogradouro(endereco.getLogradouro());
                    }
                    if (endereco.getNumero() != null) {
                        existingEndereco.setNumero(endereco.getNumero());
                    }
                    if (endereco.getComplemento() != null) {
                        existingEndereco.setComplemento(endereco.getComplemento());
                    }
                    if (endereco.getLatitude() != null) {
                        existingEndereco.setLatitude(endereco.getLatitude());
                    }
                    if (endereco.getLongitude() != null) {
                        existingEndereco.setLongitude(endereco.getLongitude());
                    }

                    return existingEndereco;
                }
            )
            .map(enderecoRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Endereco> findAll(Pageable pageable) {
        log.debug("Request to get all Enderecos");
        return enderecoRepository.findAll(pageable);
    }

    /**
     *  Get all the enderecos where Local is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Endereco> findAllWhereLocalIsNull() {
        log.debug("Request to get all enderecos where Local is null");
        return StreamSupport
            .stream(enderecoRepository.findAll().spliterator(), false)
            .filter(endereco -> endereco.getLocal() == null)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Endereco> findOne(Long id) {
        log.debug("Request to get Endereco : {}", id);
        return enderecoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Endereco : {}", id);
        enderecoRepository.deleteById(id);
    }
}
