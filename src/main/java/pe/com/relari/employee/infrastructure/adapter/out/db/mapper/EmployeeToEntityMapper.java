package pe.com.relari.employee.infrastructure.adapter.out.db.mapper;

import pe.com.relari.employee.domain.model.Company;
import pe.com.relari.employee.domain.model.Contact;
import pe.com.relari.employee.domain.model.Credential;
import pe.com.relari.employee.domain.model.Employee;
import pe.com.relari.employee.domain.util.Utility;
import pe.com.relari.employee.infrastructure.adapter.out.db.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

@Component
@AllArgsConstructor
public class EmployeeToEntityMapper {

//    PasswordEncoder passwordEncoder;

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
            .password(//passwordEncoder.encode(
                    Base64.getEncoder().encodeToString(
                            Utility.buildPassword(username, employee.getGender().name()).getBytes(StandardCharsets.UTF_8)
                    )
            )
            .build();
  }

}
