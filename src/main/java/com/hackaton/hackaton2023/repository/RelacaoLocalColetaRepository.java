package com.hackaton.hackaton2023.repository;

import com.hackaton.hackaton2023.domain.RelacaoLocalColeta;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the RelacaoLocalColeta entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RelacaoLocalColetaRepository
    extends JpaRepository<RelacaoLocalColeta, Long>, JpaSpecificationExecutor<RelacaoLocalColeta> {}
