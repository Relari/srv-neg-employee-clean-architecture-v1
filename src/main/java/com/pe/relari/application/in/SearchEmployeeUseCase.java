package com.pe.relari.application.in;

import com.pe.relari.domain.model.Employee;
import io.reactivex.Single;

/**
 * <b>Interface:</b> CreateEmployeeUseCaseImpl.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

public interface SearchEmployeeUseCase {

  Single<Employee> searchEmployee(Integer id);

}
