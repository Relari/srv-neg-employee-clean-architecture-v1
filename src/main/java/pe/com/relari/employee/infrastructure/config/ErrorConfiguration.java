package pe.com.relari.employee.infrastructure.config;

import pe.com.relari.employee.domain.exceptionhandler.ApiException;
import pe.com.relari.employee.domain.exceptionhandler.model.ErrorDetail;
import pe.com.relari.employee.domain.exceptionhandler.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * <b>Class:</b> ErrorConfiguration.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Slf4j
@ControllerAdvice
public class ErrorConfiguration {


  @Value("${spring.application.name}")
  String applicationName;

  @Autowired
  ErrorProperties errorProperties;

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ErrorResponse> apiException(
          ApiException apiException) {

    ErrorDetail errorDetail = errorProperties.getErrors().getValue(apiException.getCatalog());

    return ResponseEntity.status(errorDetail.getStatus().getStatusCode())
            .body(new ErrorResponse(
                    errorDetail.getStatus(), errorDetail.mutate().component(applicationName).build()
            ));
  }

}
