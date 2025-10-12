//package com.pe.relari.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import com.pe.relari.adapter.controller.EmployeeMapper;
//import com.pe.relari.employee.model.api.EmployeeRequest;
//import com.pe.relari.employee.model.api.PersonResponse;
//import com.pe.relari.domain.model.Employee;
//import com.pe.relari.employee.util.TestMapper;
//
//import org.junit.jupiter.api.Test;
//
//class EmployeeMapperTest {
//
//  @Test
//  void mapEmployee() {
//
//    EmployeeRequest employeeRequest = TestMapper.employeeRequest();
//
//    Employee employee = EmployeeMapper.mapEmployee(employeeRequest);
//
//    assertEquals(employeeRequest.getPerson().getFirstName(), employee.getFirstName());
//
//  }
//
//  @Test
//  void mapPersonResponse() {
//
//    Employee employee = TestMapper.employee();
//    PersonResponse personResponse = EmployeeMapper.mapPersonResponse(employee);
//
//    assertEquals(employee.getFirstName(), personResponse.getFirstName());
//  }
//
//}
