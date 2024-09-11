package com.pe.relari.application.in.impl;

import com.pe.relari.application.in.SearchEmployeeUseCase;
import com.pe.relari.application.out.EmployeePersistence;
import com.pe.relari.domain.model.Employee;
import io.reactivex.Single;
import lombok.AllArgsConstructor;

/**
 * <b>Class:</b> CreateEmployeeUseCaseImpl.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
public class SearchEmployeeUseCaseImpl implements SearchEmployeeUseCase {

  private final EmployeePersistence employeePersistence;

  @Override
  public Single<Employee> searchEmployee(Integer id) {
    return employeePersistence.searchEmployee(id);
  }
  
}
