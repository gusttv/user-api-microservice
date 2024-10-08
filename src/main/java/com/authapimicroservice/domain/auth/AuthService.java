package com.authapimicroservice.domain.auth;

import com.authapimicroservice.dto.LoginRequestDTO;
import com.authapimicroservice.dto.RegisterRequestDTO;
import com.authapimicroservice.dto.ResponseDTO;

public interface AuthService {
    ResponseDTO login(LoginRequestDTO loginRequest);
    ResponseDTO register(RegisterRequestDTO registerRequest);
}
