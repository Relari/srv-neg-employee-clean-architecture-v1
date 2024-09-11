package com.pe.relari.application.in.impl;

import com.pe.relari.application.in.CreateEmployeeUseCase;
import com.pe.relari.application.out.EmployeePersistence;
import com.pe.relari.domain.model.Employee;
import io.reactivex.Completable;
import lombok.AllArgsConstructor;

/**
 * <b>Class:</b> CreateEmployeeUseCaseImpl.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
public class CreateEmployeeUseCaseImpl implements CreateEmployeeUseCase {

  private final EmployeePersistence employeePersistence;

  @Override
  public Completable saveEmployee(Employee employee) {
    return employeePersistence.saveEmployee(employee);
  }

}
