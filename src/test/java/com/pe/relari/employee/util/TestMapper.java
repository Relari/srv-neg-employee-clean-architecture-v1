//package com.pe.relari.employee.util;
//
//import com.pe.relari.domain.model.Employee;
//import com.pe.relari.infrastructure.adapter.out.db.model.entity.EmployeeEntity;
//import lombok.AccessLevel;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//public class TestMapper {
//
//  public static EmployeeRequest employeeRequest() {
//
//    PersonModel personModel = PersonModel.builder()
//            .firstName(TestConstant.nombre)
//            .fatherLastName(TestConstant.apellidoPaterno)
//            .motherLastName(TestConstant.apellidoMaterno)
//            .sex(TestConstant.sexo)
//            .build();
//
//    DetailModel detailModel = new DetailModel(
//            TestConstant.cargo, TestConstant.salario);
//
//    return new EmployeeRequest(personModel, detailModel);
//  }
//
//  public static Employee employee() {
//    return Employee.builder()
//        .idEmployee(TestConstant.idEmployee)
//        .firstName(TestConstant.nombre)
//        .fatherLastName(TestConstant.apellidoPaterno)
//        .motherLastName(TestConstant.apellidoMaterno)
//        .sex(TestConstant.sexo)
//        .position(TestConstant.cargo)
//        .salary(TestConstant.salario)
//        .isActive(TestConstant.isActive)
//        .build();
//  }
//
//  public static EmployeeEntity employeeEntity() {
//    return EmployeeEntity.builder()
//        .id(TestConstant.idEmployee)
//        .firstName(TestConstant.nombre)
//        .fatherLastName(TestConstant.apellidoPaterno)
//        .motherLastName(TestConstant.apellidoMaterno)
//        .sex(TestConstant.sexo)
//        .position(TestConstant.cargo)
//        .salary(TestConstant.salario)
//        .isActive(TestConstant.isActive)
//        .build();
//  }
//}
