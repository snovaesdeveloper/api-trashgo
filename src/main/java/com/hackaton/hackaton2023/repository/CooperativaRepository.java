package com.hackaton.hackaton2023.repository;

import com.hackaton.hackaton2023.domain.Cooperativa;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Cooperativa entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CooperativaRepository extends JpaRepository<Cooperativa, Long>, JpaSpecificationExecutor<Cooperativa> {}
