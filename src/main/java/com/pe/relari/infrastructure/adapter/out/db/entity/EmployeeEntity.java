package com.pe.relari.infrastructure.adapter.out.db.entity;

import javax.persistence.*;

import com.pe.relari.domain.model.GenderCategory;
import com.pe.relari.domain.model.JobTitleCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <b>Class:</b> EmployeeEntity.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Entity
@Table(name = "EMPLOYEE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "fatherLastName", length = 50, nullable = false)
  private String fatherLastName;

  @Column(name = "motherLastName", length = 50, nullable = false)
  private String motherLastName;

  @Column(name = "firstName", length = 50, nullable = false)
  private String firstName;

  @Enumerated(EnumType.STRING)
  @Column(name = "gender", length = 1, nullable = false)
  private GenderCategory gender;

  @Column(name = "birthdate", nullable = false, columnDefinition = "DATE")
  private LocalDate birthdate;

  @Column(name = "isActive", nullable = false)
  private Boolean isActive;

  @Column(name = "creationDate", nullable = false, columnDefinition = "TIMESTAMP")
  private LocalDateTime creationDate;

  /**
   * Datos del contacto.
   */
  @Column(name = "email", length = 50, nullable = false)
  private String email;

  @Column(name = "phoneNumber", length = 9, nullable = false)
  private String phoneNumber;

  /**
   * Datos del cargo y sueldo del empleado.
   */
  @Enumerated(EnumType.STRING)
  @Column(name = "jobTitle", length = 50, nullable = false)
  private JobTitleCategory jobTitle;

  @Column(name = "salary", nullable = false)
  private Double salary;

  /**
   * Datos de las credenciales del empleado.
   */
  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;
}
