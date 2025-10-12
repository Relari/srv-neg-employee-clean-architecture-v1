package pe.com.relari.employee.application.in.impl;

import pe.com.relari.employee.application.in.SearchEmployeeUseCase;
import pe.com.relari.employee.application.out.EmployeePersistence;
import pe.com.relari.employee.domain.model.Employee;
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
