//package com.pe.relari.employee.dao.impl;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import com.pe.relari.employee.util.TestMapper;
//import com.pe.relari.domain.model.Employee;
//import com.pe.relari.employee.model.entity.EmployeeEntity;
//import org.junit.jupiter.api.Test;
//
//class EmployeeMapperTest {
//
//  @Test
//  void mapEmployee() {
//
//    EmployeeEntity employeeEntity = TestMapper.employeeEntity();
//
//    Employee employee = EmployeeMapper.mapEmployee(employeeEntity);
//
//    assertEquals(employeeEntity.getFirstName(), employee.getFirstName());
//
//  }
//
//  @Test
//  void mapPersonResponse() {
//
//    Employee employee = TestMapper.employee();
//    EmployeeEntity employeeEntity = EmployeeMapper.mapEmployeeEntity(employee);
//
//    assertEquals(employee.getFirstName(), employeeEntity.getFirstName());
//  }
//
//}
