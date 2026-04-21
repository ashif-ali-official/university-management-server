package com.whoisashif.universitymanagementserver.auth.service;

import com.whoisashif.universitymanagementserver.auth.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {

    public String generateToken(User user);
    public boolean isTokenValid(String token, String email);
    public String extractUsername(String token);

}
