package com.hackaton.hackaton2023.repository;

import com.hackaton.hackaton2023.domain.Coleta;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Coleta entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ColetaRepository extends JpaRepository<Coleta, Long>, JpaSpecificationExecutor<Coleta> {}
