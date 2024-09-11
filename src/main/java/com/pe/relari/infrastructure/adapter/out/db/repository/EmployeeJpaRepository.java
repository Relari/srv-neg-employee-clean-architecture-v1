package com.pe.relari.infrastructure.adapter.out.db.repository;

import com.pe.relari.infrastructure.adapter.out.db.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <b>Interface:</b> EmployeeJpaRepository.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Repository
public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Integer> {

}
