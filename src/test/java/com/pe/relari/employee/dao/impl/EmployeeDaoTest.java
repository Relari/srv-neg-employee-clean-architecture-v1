//package com.pe.relari.employee.dao.impl;
//
//import com.pe.relari.employee.util.TestMapper;
//import com.pe.relari.employee.dao.repository.EmployeeJpaRepository;
//import com.pe.relari.employee.exceptionhandler.ErrorCategory;
//import com.pe.relari.employee.exceptionhandler.ErrorConfiguration;
//import com.pe.relari.domain.model.Employee;
//import io.reactivex.observers.TestObserver;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Collections;
//import java.util.Optional;
//
//@ExtendWith(MockitoExtension.class)
//class EmployeeDaoTest {
//
//  @Mock
//  private EmployeeJpaRepository employeeRepository;
//
//  @Mock
//  private ErrorConfiguration errorFactory;
//
//  @InjectMocks
//  private EmployeeRepository employeeDao;
//
//  @Test
//  void whenFindAllThenReturnListEmployees() {
//
//    Mockito.when(employeeRepository.findAll())
//        .thenReturn(Collections.singletonList(TestMapper.employeeEntity()));
//
//    TestObserver<Employee> testObserver = employeeDao.findAll().test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors();
//
//  }
//
//  @Test
//  void whenFindByIdThenReturnEmployee() {
//
//    Mockito.when(employeeRepository.findById(Mockito.anyInt()))
//        .thenReturn(Optional.of(TestMapper.employeeEntity()));
//
//    TestObserver<Employee> testObserver = employeeDao.findById(1).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors();
//
//  }
//
//  @Test
//  void whenSaveEmployeeThenReturnEmployee() {
//
//    Mockito.when(employeeRepository.save(Mockito.any()))
//        .thenReturn(TestMapper.employeeEntity());
//
//    TestObserver<Void> testObserver = employeeDao.save(TestMapper.employee()).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors();
//
//  }
//
//  @Test
//  void whenFindByIdThenReturnEmpty() {
//
//    Mockito.when(employeeRepository.findById(Mockito.anyInt()))
//            .thenReturn(Optional.empty());
//
//    TestObserver<Employee> testObserver = employeeDao.findById(1).test();
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
//    Mockito.when(errorFactory.buildException(Mockito.any(), Mockito.any()))
//            .thenReturn(new RuntimeException());
//
//    Mockito.when(employeeRepository.save(Mockito.any()))
//            .thenReturn(new Throwable());
//
//    TestObserver<Void> testObserver = employeeDao.save(TestMapper.employee()).test();
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
