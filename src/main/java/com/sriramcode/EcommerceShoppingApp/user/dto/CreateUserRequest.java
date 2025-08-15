package com.sriramcode.EcommerceShoppingApp.user.dto;

import com.sriramcode.EcommerceShoppingApp.user.models.Role;
import lombok.Data;

import java.util.Collection;

@Data
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Collection<Role> userRole;
}

