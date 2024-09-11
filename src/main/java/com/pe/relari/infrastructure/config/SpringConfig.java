package com.pe.relari.infrastructure.config;

import com.pe.relari.application.in.CreateEmployeeUseCase;
import com.pe.relari.application.in.GetAllEmployeeUseCase;
import com.pe.relari.application.in.SearchEmployeeUseCase;
import com.pe.relari.application.in.impl.CreateEmployeeUseCaseImpl;
import com.pe.relari.application.in.impl.GetAllEmployeeUseCaseImpl;
import com.pe.relari.application.in.impl.SearchEmployeeUseCaseImpl;
import com.pe.relari.application.out.EmployeePersistence;
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
