package com.hackaton.hackaton2023.service.impl;

import com.hackaton.hackaton2023.domain.Pagamento;
import com.hackaton.hackaton2023.repository.PagamentoRepository;
import com.hackaton.hackaton2023.service.PagamentoService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Pagamento}.
 */
@Service
@Transactional
public class PagamentoServiceImpl implements PagamentoService {

    private final Logger log = LoggerFactory.getLogger(PagamentoServiceImpl.class);

    private final PagamentoRepository pagamentoRepository;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public Pagamento save(Pagamento pagamento) {
        log.debug("Request to save Pagamento : {}", pagamento);
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public Optional<Pagamento> partialUpdate(Pagamento pagamento) {
        log.debug("Request to partially update Pagamento : {}", pagamento);

        return pagamentoRepository
            .findById(pagamento.getId())
            .map(
                existingPagamento -> {
                    if (pagamento.getData() != null) {
                        existingPagamento.setData(pagamento.getData());
                    }
                    if (pagamento.getValor() != null) {
                        existingPagamento.setValor(pagamento.getValor());
                    }
                    if (pagamento.getTaxa() != null) {
                        existingPagamento.setTaxa(pagamento.getTaxa());
                    }

                    return existingPagamento;
                }
            )
            .map(pagamentoRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Pagamento> findAll(Pageable pageable) {
        log.debug("Request to get all Pagamentos");
        return pagamentoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pagamento> findOne(Long id) {
        log.debug("Request to get Pagamento : {}", id);
        return pagamentoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Pagamento : {}", id);
        pagamentoRepository.deleteById(id);
    }
}
