package pe.com.relari.employee.infrastructure.adapter.in.controller.model.out;

import pe.com.relari.employee.domain.model.Credential;
import pe.com.relari.employee.domain.model.JobTitleCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CredentialResponse {

    private String username;
    private String password;
    private String role;

    public CredentialResponse(Credential credential, JobTitleCategory jobTitle) {
        this.username = credential.getUsername();
        this.password = credential.getPassword();
        this.role = jobTitle.name();
    }

}
