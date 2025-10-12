//package com.pe.relari.controller;
//
//import com.pe.relari.adapter.controller.EmployeeController;
//import com.pe.relari.employee.model.api.PersonResponse;
//import com.pe.relari.usecase.CreateEmployeeUseCaseImpl;
//import com.pe.relari.employee.util.TestConstant;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.pe.relari.employee.util.TestMapper;
//
//import io.reactivex.Completable;
//import io.reactivex.Observable;
//import io.reactivex.Single;
//import io.reactivex.observers.TestObserver;
//
//@ExtendWith(MockitoExtension.class)
//class EmployeeControllerTest {
//
//  @Mock
//  private CreateEmployeeUseCaseImpl saveEmployee;
//
//  @InjectMocks
//  private EmployeeController employeeController;
//
//  @Test
//  void whenFindAllThenReturnListEmployees() {
//
//    Mockito.when(saveEmployee.findAll())
//        .thenReturn(Observable.just(TestMapper.employee()));
//
//    TestObserver<PersonResponse> testObserver = employeeController.listOfEmployees().test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors()
//        .assertValue(personResponse -> personResponse.getFirstName().equals(TestConstant.nombre))
//        .assertValue(personResponse -> personResponse.getFatherLastName().equals(TestConstant.apellidoPaterno))
//        .assertValue(personResponse -> personResponse.getMotherLastName().equals(TestConstant.apellidoMaterno))
//        .assertValue(personResponse -> personResponse.getSex().equals(TestConstant.sexo));
//
//  }
//
//  @Test
//  void whenSaveEmployeeThenReturnSuccessful() {
//    Mockito.when(saveEmployee.save(Mockito.any()))
//        .thenReturn(Completable.complete());
//
//    TestObserver<Void> testObserver =
//        employeeController.save(TestMapper.employeeRequest()).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors();
//
//  }
//
//  @Test
//  void whenFindByIdThenReturnEmployee() {
//    Mockito.when(saveEmployee.findById(Mockito.anyInt()))
//        .thenReturn(Single.just(TestMapper.employee()));
//
//    TestObserver<PersonResponse> testObserver = employeeController.findEmployeeById(1).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors()
//        .assertValue(personResponse -> personResponse.getFirstName().equals(TestConstant.nombre))
//        .assertValue(personResponse -> personResponse.getFatherLastName().equals(TestConstant.apellidoPaterno))
//        .assertValue(personResponse -> personResponse.getMotherLastName().equals(TestConstant.apellidoMaterno));
//
//  }
//
//}
