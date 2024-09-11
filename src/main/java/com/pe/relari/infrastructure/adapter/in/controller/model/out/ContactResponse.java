package com.pe.relari.infrastructure.adapter.in.controller.model.out;

import com.pe.relari.domain.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContactResponse {

    private String email;
    private String phoneNumber;

    public ContactResponse(Contact contact) {
        this.email = contact.getEmail();
        this.phoneNumber = contact.getPhoneNumber();
    }

}
