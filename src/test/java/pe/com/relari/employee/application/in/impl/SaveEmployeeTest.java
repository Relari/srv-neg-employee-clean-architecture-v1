//package com.pe.relari.usecase.impl;
//
//import com.pe.relari.usecase.port.EmployeePersistence;
//import com.pe.relari.employee.exceptionhandler.ErrorCategory;
//import com.pe.relari.employee.exceptionhandler.ErrorConfiguration;
//import com.pe.relari.domain.model.Employee;
//import com.pe.relari.employee.util.TestConstant;
//import com.pe.relari.employee.util.TestMapper;
//import io.reactivex.Completable;
//import io.reactivex.Observable;
//import io.reactivex.Single;
//import io.reactivex.observers.TestObserver;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class SaveEmployeeTest {
//
//  @Mock
//  private EmployeePersistence employeeDao;
//
//  @Mock
//  private ErrorConfiguration errorFactory;
//
//  @InjectMocks
//  private CreateEmployeeUseCaseImpl employeeService;
//
//  @Test
//  void whenFindAllThenReturnListEmployees() {
//
//    Mockito.when(employeeDao.findAll())
//        .thenReturn(Observable.just(TestMapper.employee()));
//
//    TestObserver<Employee> testObserver = employeeService.findAll().test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors();
//
//  }
//
//  @Test
//  void whenSaveEmployeeThenReturnSuccessful() {
//
//    Mockito.when(employeeDao.save(Mockito.any()))
//        .thenReturn(Completable.complete());
//
//    TestObserver<Void> testObserver =
//        employeeService.save(TestMapper.employee()).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors();
//
//  }
//
//  @Test
//  void whenFindByIdThenReturnEmployee() {
//    Mockito.when(employeeDao.findById(Mockito.anyInt()))
//        .thenReturn(Single.just(TestMapper.employee()));
//
//    TestObserver<Employee> testObserver = employeeService.findById(1).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors()
//        .assertValue(employeeDto -> employeeDto.getIdEmployee().equals(TestConstant.idEmployee))
//        .assertValue(employeeDto -> employeeDto.getFirstName().equals(TestConstant.nombre))
//        .assertValue(employeeDto -> employeeDto.getFatherLastName().equals(TestConstant.apellidoPaterno))
//        .assertValue(employeeDto -> employeeDto.getMotherLastName().equals(TestConstant.apellidoMaterno))
//        .assertValue(employeeDto -> employeeDto.getSex().equals(TestConstant.sexo))
//        .assertValue(employeeDto -> employeeDto.getPosition().equals(TestConstant.cargo))
//        .assertValue(employeeDto -> employeeDto.getSalary().equals(TestConstant.salario))
//        .assertValue(employeeDto -> employeeDto.getIsActive().equals(TestConstant.isActive));
//
//  }
//
//  @Test
//  void whenFindByIdThenReturnError() {
//
//    Mockito.when(employeeDao.findById(Mockito.anyInt()))
//        .thenReturn(Single.error(this::employeeException));
//
//    TestObserver<Employee> testObserver = employeeService.findById(1).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertNotComplete().assertNoValues();
//
//  }
//
//  @Test
//  void whenSaveEmployeeThenReturnError() {
//
//    Mockito.when(employeeDao.save(Mockito.any()))
//        .thenReturn(Completable.error(this::employeeException));
//
//    TestObserver<Void> testObserver = employeeService.save(TestMapper.employee()).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertNotComplete().assertNoValues();
//
//  }
//
//  private RuntimeException employeeException() {
//    return errorFactory.buildException(ErrorCategory.EMPLOYEE_NOT_SAVE, null);
//  }
//
//}
