package pe.com.relari.employee.application.in.impl;

import pe.com.relari.employee.application.in.CreateEmployeeUseCase;
import pe.com.relari.employee.application.out.EmployeePersistence;
import pe.com.relari.employee.domain.model.Employee;
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
