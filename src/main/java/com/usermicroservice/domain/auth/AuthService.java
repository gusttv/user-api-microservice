package com.usermicroservice.domain.auth;

import com.usermicroservice.dto.LoginRequestDTO;
import com.usermicroservice.dto.RegisterRequestDTO;
import com.usermicroservice.dto.ResponseDTO;

public interface AuthService {
    ResponseDTO login(LoginRequestDTO loginRequest);
    ResponseDTO register(RegisterRequestDTO registerRequest);
}
