package pe.com.relari.employee.infrastructure.config;

import pe.com.relari.employee.application.in.CreateEmployeeUseCase;
import pe.com.relari.employee.application.in.GetAllEmployeeUseCase;
import pe.com.relari.employee.application.in.SearchEmployeeUseCase;
import pe.com.relari.employee.application.in.impl.CreateEmployeeUseCaseImpl;
import pe.com.relari.employee.application.in.impl.GetAllEmployeeUseCaseImpl;
import pe.com.relari.employee.application.in.impl.SearchEmployeeUseCaseImpl;
import pe.com.relari.employee.application.out.EmployeePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class SpringConfig {

    @Bean
    public CreateEmployeeUseCase saveEmployee(EmployeePersistence employeePersistence) {
        return new CreateEmployeeUseCaseImpl(employeePersistence);
    }

    @Bean
    public SearchEmployeeUseCase searchEmployee(EmployeePersistence employeePersistence) {
        return new SearchEmployeeUseCaseImpl(employeePersistence);
    }

    @Bean
    public GetAllEmployeeUseCase getEmployees(EmployeePersistence employeePersistence) {
        return new GetAllEmployeeUseCaseImpl(employeePersistence);
    }

}
