package com.hackaton.hackaton2023.repository;

import com.hackaton.hackaton2023.domain.Local;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Local entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LocalRepository extends JpaRepository<Local, Long>, JpaSpecificationExecutor<Local> {}
