package co.edu.unbosque.LaForestaTrading.service.internal.implementation;

import co.edu.unbosque.LaForestaTrading.dto.auth.LoginRequestDTO;
import co.edu.unbosque.LaForestaTrading.entity.User;
import co.edu.unbosque.LaForestaTrading.entity.enums.UserStatus;
import co.edu.unbosque.LaForestaTrading.entity.enums.UserType;
import co.edu.unbosque.LaForestaTrading.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthServiceImplTest {

    private IUserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthServiceImpl authService;

    @BeforeEach
    void setUp() {
        userRepository = mock(IUserRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        authService = new AuthServiceImpl(userRepository, passwordEncoder);
    }

    @Test
    void authenticateSuccessfulLoginReturnsUser() {
        // Arrange
        String email = "user@test.com";
        String rawPassword = "123456";
        String encodedPassword = "encodedPass";

        LoginRequestDTO loginRequest = new LoginRequestDTO();
        loginRequest.setUsername(email);
        loginRequest.setPassword(rawPassword);

        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(encodedPassword);
        user.setFirstName("Test");
        user.setLastName("User");
        user.setStatus(UserStatus.ACTIVE);
        user.setUserType(UserType.INVESTOR);
        user.setRegistrationDate(LocalDateTime.now());

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(rawPassword, encodedPassword)).thenReturn(true);

        // Act
        User result = authService.authenticate(loginRequest);

        // Assert
        assertNotNull(result);
        assertEquals(email, result.getEmail());
        verify(userRepository).findByEmail(email);
        verify(passwordEncoder).matches(rawPassword, encodedPassword);
    }

    @Test
    void authenticateUserNotFoundThrowsException() {
        // Arrange
        LoginRequestDTO loginRequest = new LoginRequestDTO();
        loginRequest.setUsername("missing@test.com");
        loginRequest.setPassword("anyPass");

        when(userRepository.findByEmail(loginRequest.getUsername())).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> authService.authenticate(loginRequest));
        assertEquals("Credenciales inválidas", exception.getMessage());
    }

    @Test
    void authenticatePasswordMismatchThrowsException() {
        // Arrange
        String email = "user@test.com";

        LoginRequestDTO loginRequest = new LoginRequestDTO();
        loginRequest.setUsername(email);
        loginRequest.setPassword("wrongPass");

        User user = new User();
        user.setEmail(email);
        user.setPasswordHash("encodedPassword");

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrongPass", "encodedPassword")).thenReturn(false);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> authService.authenticate(loginRequest));
        assertEquals("Credenciales inválidas", exception.getMessage());
    }
}

