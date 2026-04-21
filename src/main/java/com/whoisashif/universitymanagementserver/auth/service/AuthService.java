package com.whoisashif.universitymanagementserver.auth.service;

import com.whoisashif.universitymanagementserver.auth.dto.AuthResponse;
import com.whoisashif.universitymanagementserver.auth.dto.LoginRequest;
import com.whoisashif.universitymanagementserver.auth.dto.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    public AuthResponse login(LoginRequest request);
    public void register(RegisterRequest request);

}
