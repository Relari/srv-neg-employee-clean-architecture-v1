package com.pe.relari.infrastructure.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b>Class:</b> EmployeeApplication.<br/>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@SpringBootApplication(scanBasePackages = "com.pe.relari.infrastructure")
public class EmployeeApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmployeeApplication.class);
  }

}
