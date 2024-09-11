package com.pe.relari.application.in.impl;

import com.pe.relari.application.in.GetAllEmployeeUseCase;
import com.pe.relari.application.out.EmployeePersistence;
import com.pe.relari.domain.model.Employee;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;

/**
 * <b>Class:</b> GetAllEmployeeUseCaseImpl.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
public class GetAllEmployeeUseCaseImpl implements GetAllEmployeeUseCase {

  private final EmployeePersistence employeePersistence;

  @Override
  public Observable<Employee> getEmployees() {
    return employeePersistence.getEmployees();
  }

}
