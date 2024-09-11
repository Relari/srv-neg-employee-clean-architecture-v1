package com.pe.relari.infrastructure.adapter.in.controller.model.out;

import com.pe.relari.domain.model.Credential;
import com.pe.relari.domain.model.JobTitleCategory;
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
