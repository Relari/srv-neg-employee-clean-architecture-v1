package pe.com.relari.employee.infrastructure.adapter.in.controller.mapper;

import pe.com.relari.employee.domain.model.Company;
import pe.com.relari.employee.domain.model.Contact;
import pe.com.relari.employee.domain.model.Employee;
import pe.com.relari.employee.domain.model.GenderCategory;
import pe.com.relari.employee.domain.util.Utility;
import pe.com.relari.employee.infrastructure.adapter.in.controller.model.out.CompanyResponse;
import pe.com.relari.employee.infrastructure.adapter.in.controller.model.out.ContactResponse;
import pe.com.relari.employee.infrastructure.adapter.in.controller.model.in.EmployeeRequest;
import pe.com.relari.employee.infrastructure.adapter.in.controller.model.out.EmployeeResponse;
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
