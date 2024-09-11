package com.pe.relari.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <b>Class:</b> EmployeeDto.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class Employee {

  private Integer idEmployee;
  private String fatherLastName;
  private String motherLastName;
  private String firstName;
  private GenderCategory gender;
  private LocalDate birthdate;

  private Contact contact;

  private Credential credential;

  private Company company;

  private LocalDateTime creationDate;
  private Boolean isActive;

}
