package dev.fabrix.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.fabrix.user_service.controller.LoginRequest;
import dev.fabrix.user_service.controller.RegisterRequest;
import dev.fabrix.user_service.controller.TokenResponse;
import dev.fabrix.user_service.model.Token;
import dev.fabrix.user_service.model.User;
import dev.fabrix.user_service.repository.TokenRepository;
import dev.fabrix.user_service.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Autowired
    public AuthService(
            TokenRepository tokenRepository,
            PasswordEncoder passwordEncoder,
            UserRepository userRepository,
            JwtService jwtService) {
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public TokenResponse register(RegisterRequest request) {
        User user = new User.Builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return new TokenResponse(jwtToken, refreshToken);
    }

    public TokenResponse login(LoginRequest request) {
        // return userRepository.findByUsername(username)
        // .filter(user -> passwordEncoder.matches(password, user.getPassword())); //
        // Verify password
        return null;
    }

    public TokenResponse refreshToken(final String authHeader) {
        return null;
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = new Token.Builder().user(user).token(jwtToken).tokenType(Token.TokenType.BEARER).expired(false)
                .revoked(false).build();
        tokenRepository.save(token);
    }
}
