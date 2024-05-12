package com.jpa.mapping.jpamapping.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserStoreRequest {

    @NotBlank
    private String name;

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String district;

    private String fullAddress;

}
