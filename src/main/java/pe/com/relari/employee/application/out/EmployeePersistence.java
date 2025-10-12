package pe.com.relari.employee.application.out;

import pe.com.relari.employee.domain.model.Employee;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * <b>Interface:</b> EmployeePersistence.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

public interface EmployeePersistence {

  Observable<Employee> getEmployees();

  Completable saveEmployee(Employee employee);

  Single<Employee> searchEmployee(Integer id);

}
