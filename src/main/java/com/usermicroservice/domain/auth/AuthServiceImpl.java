package com.usermicroservice.domain.auth;

import com.usermicroservice.domain.user.model.User;
import com.usermicroservice.dto.LoginRequestDTO;
import com.usermicroservice.dto.RegisterRequestDTO;
import com.usermicroservice.dto.RegisterResponseDTO;
import com.usermicroservice.dto.LoginResponseDTO;
import com.usermicroservice.infrastructure.config.TokenService;
import com.usermicroservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

   private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        logger.info("Processing login for email: {}", loginRequest.email());
        User user = userRepository.findByEmail(loginRequest.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            // Gera um token JWT
            String token = tokenService.generateToken(user);
            logger.info("Token generated for user: {}", user.getEmail());
            return new LoginResponseDTO(user.getName(), token);
        }
        logger.warn("Invalid login attempt for email: {}", loginRequest.email());
        throw new RuntimeException("Invalid credentials");
    }

    public RegisterResponseDTO register(RegisterRequestDTO registerRequest) {

        logger.info("Processing registration for email: {}", registerRequest.email());
        Optional<User> existingUser = userRepository.findByEmail(registerRequest.email());
        if (existingUser.isPresent()) {
            logger.warn("Email already in use: {}", registerRequest.email());
            throw new RuntimeException("Email already in use");
        }

        User newUser = new User();
        newUser.setName(registerRequest.name());
        newUser.setEmail(registerRequest.email());
        newUser.setPassword(passwordEncoder.encode(registerRequest.password()));

        logger.info("User registered successfully with email: {}", newUser.getEmail());
        userRepository.save(newUser);

        return new RegisterResponseDTO(newUser.getId(), newUser.getName(), newUser.getEmail());
    }
}
