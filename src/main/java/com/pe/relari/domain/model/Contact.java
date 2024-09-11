package com.pe.relari.domain.model;

import com.pe.relari.infrastructure.adapter.in.controller.model.in.ContactRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Contact {

    private String email;
    private String phoneNumber;

    public Contact(ContactRequest request) {
        this.email = request.getEmail();
        this.phoneNumber = request.getPhoneNumber();
    }
}
