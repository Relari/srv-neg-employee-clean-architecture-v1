package com.pe.relari.infrastructure.adapter.in.controller.mapper;

import com.pe.relari.domain.model.Company;
import com.pe.relari.domain.model.Contact;
import com.pe.relari.domain.model.Employee;
import com.pe.relari.domain.model.GenderCategory;
import com.pe.relari.domain.util.Utility;
import com.pe.relari.infrastructure.adapter.in.controller.model.out.CompanyResponse;
import com.pe.relari.infrastructure.adapter.in.controller.model.out.ContactResponse;
import com.pe.relari.infrastructure.adapter.in.controller.model.in.EmployeeRequest;
import com.pe.relari.infrastructure.adapter.in.controller.model.out.EmployeeResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.lang.Boolean.TRUE;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestToEmployeeMapper {

  public static Employee mapEmployee(EmployeeRequest employeeRequest) {
    return Employee.builder()
            .firstName(employeeRequest.getFirstName())
            .fatherLastName(employeeRequest.getFatherLastName())
            .motherLastName(employeeRequest.getMotherLastName())
            .gender(GenderCategory.valueOf(employeeRequest.getGender()))
            .birthdate(Utility.mapLocalDate(employeeRequest.getBirthdate()))
            .contact(new Contact(employeeRequest.getContactInfo()))
            .company(new Company(employeeRequest.getCompany()))
            .isActive(TRUE)
            .build();
  }
  public static EmployeeResponse mapPersonResponse(Employee employee) {
    return EmployeeResponse.builder()
            .firstName(employee.getFirstName())
            .fatherLastName(employee.getFatherLastName())
            .motherLastName(employee.getMotherLastName())
            .gender(employee.getGender().name())
            .birthdate(Utility.formatDate(employee.getBirthdate()))
            .contact(new ContactResponse(employee.getContact()))
            .company(new CompanyResponse(employee.getCompany()))
            .build();
  }

}
