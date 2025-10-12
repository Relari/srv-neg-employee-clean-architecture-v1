package pe.com.relari.employee.application.in;

import pe.com.relari.employee.domain.model.Employee;
import io.reactivex.Completable;

/**
 * <b>Interface:</b> CreateEmployeeUseCaseImpl.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

public interface CreateEmployeeUseCase {

  Completable saveEmployee(Employee employee);

}
