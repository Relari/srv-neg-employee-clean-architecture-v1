package pe.com.relari.employee.infrastructure.config;

import pe.com.relari.employee.infrastructure.adapter.out.db.entity.EmployeeEntity;
import pe.com.relari.employee.infrastructure.adapter.out.db.repository.EmployeeJpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Lazy
@Configuration
@EnableJpaRepositories(basePackageClasses = EmployeeJpaRepository.class)
@EntityScan(basePackageClasses = EmployeeEntity.class)
public class DatabaseConfig {
}
