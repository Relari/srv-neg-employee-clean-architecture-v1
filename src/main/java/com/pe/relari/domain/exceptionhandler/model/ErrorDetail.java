package com.pe.relari.domain.exceptionhandler.model;

import com.pe.relari.domain.exceptionhandler.StatusCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {

    @Schema(
            description = "Representa el nombre del componente.",
            name = "component",
            implementation = String.class,
            example = "business-api-employee")
    private String component;

    @Schema(
            description = "Representa la descripcion del error programado.",
            name = "description",
            implementation = String.class,
            example = "Error al guardar al empleado.")
    private String description;
    private StatusCategory status;

    public ErrorDetailBuilder mutate() {
        return builder()
                .component(component)
                .description(description)
                .status(status);
    }
}
