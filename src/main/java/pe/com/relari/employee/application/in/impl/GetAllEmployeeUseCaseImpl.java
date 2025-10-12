package pe.com.relari.employee.application.in.impl;

import pe.com.relari.employee.application.in.GetAllEmployeeUseCase;
import pe.com.relari.employee.application.out.EmployeePersistence;
import pe.com.relari.employee.domain.model.Employee;
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
