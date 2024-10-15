package com.usermicroservice.domain.auth;

import com.usermicroservice.domain.user.User;
import com.usermicroservice.dto.LoginRequestDTO;
import com.usermicroservice.dto.RegisterRequestDTO;
import com.usermicroservice.dto.RegisterResponseDTO;
import com.usermicroservice.dto.ResponseDTO;

public interface AuthService {
    ResponseDTO login(LoginRequestDTO loginRequest);
    RegisterResponseDTO register(RegisterRequestDTO registerRequest);
}
