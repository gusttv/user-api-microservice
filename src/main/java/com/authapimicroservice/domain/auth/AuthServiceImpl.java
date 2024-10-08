package com.authapimicroservice.domain.auth;

import com.authapimicroservice.domain.user.User;
import com.authapimicroservice.dto.LoginRequestDTO;
import com.authapimicroservice.dto.RegisterRequestDTO;
import com.authapimicroservice.dto.ResponseDTO;
import com.authapimicroservice.infrastructure.config.TokenService;
import com.authapimicroservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    public ResponseDTO login(LoginRequestDTO loginRequest) {
        // Verifica se o usuário existe pelo email
        User user = userRepository.findByEmail(loginRequest.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Verifica se a senha é válida
        if (passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            // Gera um token JWT
            String token = tokenService.generateToken(user);
            return new ResponseDTO(user.getName(), token);
        }

        // Retorna null ou lança exceção para indicar falha na autenticação
        throw new RuntimeException("Invalid credentials");
    }

    public ResponseDTO register(RegisterRequestDTO registerRequest) {
        // Verifica se o email já está em uso
        Optional<User> existingUser = userRepository.findByEmail(registerRequest.email());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        // Cria um novo usuário
        User newUser = new User();
        newUser.setName(registerRequest.name());
        newUser.setEmail(registerRequest.email());
        newUser.setPassword(passwordEncoder.encode(registerRequest.password()));

        // Salva o novo usuário no banco de dados
        userRepository.save(newUser);

        // Gera um token JWT para o novo usuário
        String token = tokenService.generateToken(newUser);
        return new ResponseDTO(newUser.getName(), token);
    }
}
