package com.pe.relari.infrastructure.adapter.in.controller;

import com.pe.relari.application.in.GetAllEmployeeUseCase;
import com.pe.relari.infrastructure.adapter.in.controller.mapper.RequestToEmployeeMapper;
import com.pe.relari.infrastructure.adapter.in.controller.model.out.EmployeeResponse;
import io.reactivex.Observable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>Class:</b> GetEmployeesController.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Tag(name = "Employee", description = "Employee Controller")
@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
class GetEmployeesController {

  private final GetAllEmployeeUseCase employeeService;

  @Operation(
          summary = "Listado de Empleados",
          method = "GET",
          responses  = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Retorna todos los Empleados",
                          content = @Content(
                                  array = @ArraySchema(
                                          schema = @Schema(implementation = EmployeeResponse.class)),
                                  mediaType = MediaType.APPLICATION_JSON_VALUE
                          )
                  )
          })
  @GetMapping
  public Observable<EmployeeResponse> listOfEmployees() {
    return this.employeeService.getEmployees()
            .map(RequestToEmployeeMapper::mapPersonResponse);
  }

}
