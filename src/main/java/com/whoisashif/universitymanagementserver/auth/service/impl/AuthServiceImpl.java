package com.whoisashif.universitymanagementserver.auth.service.impl;

import com.whoisashif.universitymanagementserver.auth.config.SecurityConfig;
import com.whoisashif.universitymanagementserver.auth.dto.AuthResponse;
import com.whoisashif.universitymanagementserver.auth.dto.LoginRequest;
import com.whoisashif.universitymanagementserver.auth.dto.RegisterRequest;
import com.whoisashif.universitymanagementserver.auth.entity.User;
import com.whoisashif.universitymanagementserver.auth.repository.UserRepository;
import com.whoisashif.universitymanagementserver.auth.service.AuthService;
import com.whoisashif.universitymanagementserver.auth.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthResponse login(LoginRequest request) {

        // Fetch User
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow( () -> new RuntimeException("User not found!"));

        // Validate Password
        if(!passwordEncoder.matches(user.getPassword(), request.getPassword())) {
            throw new RuntimeException("Invalid Credential!");
        }

        // Generate token
        String token = jwtService.generateToken(user);

        return new AuthResponse(token);
    }

    @Override
    public void register(RegisterRequest request) {

        // Check if user exists
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("User already exists!");
        }

        // Create User now
        User user = mapUserFromRegisterRequest(request);
        userRepository.save(user);
    }

    // Helper method to map User from RegisterRequest
    private User mapUserFromRegisterRequest(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setRole(request.getRole());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return user;
    }

}
