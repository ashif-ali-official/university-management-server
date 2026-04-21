package com.whoisashif.universitymanagementserver.auth.dto;

import com.whoisashif.universitymanagementserver.auth.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    String username;
    String name;
    String email;
    String password;
    Role role;

}
