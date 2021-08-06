package com.example.authservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data @AllArgsConstructor @NoArgsConstructor
public class Role implements GrantedAuthority {

    public static final String ADMIN = "ADMIN";
    public static final String TEACHER = "TEACHER";
    public static final String OTHER_STAFF = "OTHER_STAFF";
    public static final String STUDENT = "STUDENT";

    private String authority;

}
