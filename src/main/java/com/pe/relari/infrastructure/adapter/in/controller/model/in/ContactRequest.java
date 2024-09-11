package com.pe.relari.infrastructure.adapter.in.controller.model.in;

import com.pe.relari.domain.util.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {

    @Schema(
            description = "Representa el correo electronico del empleado",
            name = "email",
            implementation = String.class,
            example = "contact@email.com",
            required = true)
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Schema(
            description = "Representa el numero telefonico del empleado",
            name = "phoneNumber",
            implementation = String.class,
            example = "987654321",
            required = true)
    @NotNull
    @NotBlank
    @Pattern(regexp = Constants.REGEXP_PHONE_NUMBER)
    private String phoneNumber;

}
