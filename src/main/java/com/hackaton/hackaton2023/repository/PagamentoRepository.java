package com.hackaton.hackaton2023.repository;

import com.hackaton.hackaton2023.domain.Pagamento;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Pagamento entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>, JpaSpecificationExecutor<Pagamento> {}
