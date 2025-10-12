package pe.com.relari.employee.infrastructure.adapter.in.controller.model.in;

import pe.com.relari.employee.domain.util.JobTitle;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CompanyRequest {

    @NotNull
    @NotBlank
//    @Pattern(regexp = Constants.REGEXP_JOBS_TITLES)
    @JobTitle
    @Size(min = 1, max = 50)
    @Schema(
            description = "Representa el cargo o posición del empleado en la empresa",
            name = "jobTitle",
            implementation = String.class,
            example = "Asistente",
            required = true)
    private String jobTitle;

    @NotNull
    @Schema(
            description = "Representa el salario o sueldo del empleado",
            name = "salary",
            implementation = Double.class,
            example = "1500",
            required = true)
    private Double salary;

}
