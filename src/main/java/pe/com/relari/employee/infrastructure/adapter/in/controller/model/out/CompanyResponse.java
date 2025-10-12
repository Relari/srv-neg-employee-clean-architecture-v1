package pe.com.relari.employee.infrastructure.adapter.in.controller.model.out;

import pe.com.relari.employee.domain.model.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CompanyResponse {

    private String jobTitle;
    private Double salary;

    public CompanyResponse(Company company) {
        this.jobTitle = company.getJobTitle().name();
        this.salary = company.getSalary();
    }

}
