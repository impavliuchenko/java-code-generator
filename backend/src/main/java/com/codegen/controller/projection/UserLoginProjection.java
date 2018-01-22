package com.codegen.controller.projection;

import lombok.Data;

@Data
public class UserLoginProjection {
    private String email;
    private String password;
}
