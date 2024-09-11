package com.pe.relari.application.out;

import com.pe.relari.domain.model.Employee;

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
