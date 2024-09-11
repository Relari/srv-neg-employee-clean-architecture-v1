package com.pe.relari.infrastructure.adapter.out.db;

import com.pe.relari.infrastructure.adapter.out.db.mapper.EmployeeToEntityMapper;
import com.pe.relari.infrastructure.adapter.out.db.entity.EmployeeEntity;
import com.pe.relari.infrastructure.adapter.out.db.repository.EmployeeJpaRepository;
import com.pe.relari.application.out.EmployeePersistence;
import com.pe.relari.domain.exceptionhandler.ApiException;
import com.pe.relari.domain.exceptionhandler.ErrorCategory;
import com.pe.relari.domain.model.Employee;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <b>Class:</b> EmployeeRepository.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Slf4j
@Component
@AllArgsConstructor
public class EmployeeRepository implements EmployeePersistence {

  private final EmployeeJpaRepository employeeJpaRepository;
  private final EmployeeToEntityMapper employeeToEntityMapper;

  @Override
  public Observable<Employee> getEmployees() {
    return Observable.fromCallable(employeeJpaRepository::findAll)
        .subscribeOn(Schedulers.io())
        .flatMapIterable(employeeEntities -> employeeEntities)
        .map(employeeToEntityMapper::mapEmployee)
        .doOnNext(employee -> log.trace(employee.toString()))
        .doOnSubscribe(disposable -> log.debug("Starting to list the employees."))
        .doOnComplete(() -> log.info("The list of employees is completely ready."));
  }

  @Override
  public Completable saveEmployee(Employee employee) {
    return Single.fromCallable(() -> employeeToEntityMapper.mapEmployeeEntity(employee))
        .map(employeeJpaRepository::save)
        .subscribeOn(Schedulers.io())
        .onErrorResumeNext(throwable ->
                Single.error(
                        ApiException.of(
                                ErrorCategory.EMPLOYEE_NOT_SAVE, throwable
                        )
                )
        )
        .doOnSubscribe(disposable ->
                log.debug("Starting to save the employee.")
        )
        .doOnError(throwable ->
                log.error("An error occurred while saving the employee.", throwable)
        )
        .ignoreElement()
        .doOnComplete(() ->
                log.info("The employee was successfully saved.")
        );
  }

  @Override
  public Single<Employee> searchEmployee(Integer id) {

    return Single.fromCallable(() -> findBy(id))
        .subscribeOn(Schedulers.io())
        .map(employeeToEntityMapper::mapEmployee)
        .doOnSubscribe(disposable ->
                log.debug("Consulting the employee with [id={}]", id)
        )
        .doOnError(throwable ->
                log.error("Employee not found - [id={}]", id, throwable)
        )
        .doOnSuccess(employee ->
                log.info("The employee was found with the [id={}]", id)
        );
  }

  private EmployeeEntity findBy(Integer id) {
    return employeeJpaRepository.findById(id)
           .orElseThrow(() ->
                   ApiException.of(
                           ErrorCategory.EMPLOYEE_NOT_FOUND
                   )
           );
  }

}
