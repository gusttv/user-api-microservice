package com.usermicroservice.domain.auth;

import com.usermicroservice.dto.LoginRequestDTO;
import com.usermicroservice.dto.RegisterRequestDTO;
import com.usermicroservice.dto.RegisterResponseDTO;
import com.usermicroservice.dto.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO loginRequest);
    RegisterResponseDTO register(RegisterRequestDTO registerRequest);
}
