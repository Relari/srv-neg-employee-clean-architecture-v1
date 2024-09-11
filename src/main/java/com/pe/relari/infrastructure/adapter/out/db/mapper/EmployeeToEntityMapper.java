package com.pe.relari.infrastructure.adapter.out.db.mapper;

import com.pe.relari.domain.model.Company;
import com.pe.relari.domain.model.Contact;
import com.pe.relari.domain.model.Credential;
import com.pe.relari.domain.model.Employee;
import com.pe.relari.domain.util.Utility;
import com.pe.relari.infrastructure.adapter.out.db.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class EmployeeToEntityMapper {

    PasswordEncoder passwordEncoder;

    /**
     * Mapea la entidad al empleado.
     * @param employeeEntity {@link EmployeeEntity}
     * @return {@link Employee}
     */
  public Employee mapEmployee(EmployeeEntity employeeEntity) {
    return Employee.builder()
            .idEmployee(employeeEntity.getId())
            .firstName(employeeEntity.getFirstName())
            .fatherLastName(employeeEntity.getFatherLastName())
            .motherLastName(employeeEntity.getMotherLastName())
            .gender(employeeEntity.getGender())
            .birthdate(employeeEntity.getBirthdate())
            .credential(new Credential(
                    employeeEntity.getUsername(),
                    employeeEntity.getPassword()
            ))
            .company(new Company(
                    employeeEntity.getJobTitle(),
                    employeeEntity.getSalary()
            ))
            .contact(new Contact(
                    employeeEntity.getEmail(),
                    employeeEntity.getPhoneNumber()
            ))
            .creationDate(employeeEntity.getCreationDate())
            .isActive(employeeEntity.getIsActive())
            .build();
  }

    /**
     * Mapea el empleado a la entidad para crear al usuario.
     * @param employee {@link Employee}
     * @return {@link EmployeeEntity}
     */
  public EmployeeEntity mapEmployeeEntity(Employee employee) {
    var username = Utility.buildUsername(
            employee.getFirstName(),
            employee.getFatherLastName()
    );
    return EmployeeEntity.builder()
            .id(employee.getIdEmployee())
            .firstName(employee.getFirstName())
            .fatherLastName(employee.getFatherLastName())
            .motherLastName(employee.getMotherLastName())
            .gender(employee.getGender())
            .birthdate(employee.getBirthdate())
            .isActive(employee.getIsActive())
            .creationDate(LocalDateTime.now())

            .email(employee.getContact().getEmail())
            .phoneNumber(employee.getContact().getPhoneNumber())

            .jobTitle(employee.getCompany().getJobTitle())
            .salary(employee.getCompany().getSalary())

            .username(username)
            .password(passwordEncoder.encode(
                    Utility.buildPassword(username, employee.getGender().name())
            ))

            .build();
  }

}
