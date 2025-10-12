package pe.com.relari.employee.domain.model;

import pe.com.relari.employee.infrastructure.adapter.in.controller.model.in.CompanyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Company {

    private JobTitleCategory jobTitle;
    private Double salary;

    public Company(CompanyRequest companyRequest) {
        this.jobTitle = JobTitleCategory.valueOf(companyRequest.getJobTitle());
        this.salary = companyRequest.getSalary();
    }

}
