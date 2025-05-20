package co.edu.unbosque.LaForestaTrading.service.internal.implementation;

import co.edu.unbosque.LaForestaTrading.entity.User;
import co.edu.unbosque.LaForestaTrading.entity.enums.UserStatus;
import co.edu.unbosque.LaForestaTrading.entity.enums.UserType;
import co.edu.unbosque.LaForestaTrading.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserDetailsServiceImplTest {

    private IUserRepository userRepository;
    private UserDetailsServiceImpl userDetailsService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(IUserRepository.class);
        userDetailsService = new UserDetailsServiceImpl(userRepository);
    }

    @Test
    void loadUserByUsernameUserFoundReturnsUser() {
        // Arrange
        String email = "test@example.com";
        User user = new User();
        user.setId(1L);
        user.setEmail(email);
        user.setFirstName("Test");
        user.setLastName("User");
        user.setPasswordHash("encodedPassword");
        user.setStatus(UserStatus.ACTIVE);
        user.setUserType(UserType.INVESTOR);
        user.setRegistrationDate(LocalDateTime.now());

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        // Act
        User result = userDetailsService.loadUserByUsername(email);

        // Assert
        assertNotNull(result);
        assertEquals(email, result.getEmail());
        verify(userRepository, times(1)).findByEmail(email);
    }

    @Test
    void loadUserByUsernameUserNotFoundThrowsException() {
        // Arrange
        String email = "notfound@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Act & Assert
        UsernameNotFoundException exception = assertThrows(
                UsernameNotFoundException.class,
                () -> userDetailsService.loadUserByUsername(email)
        );

        assertEquals("Usuario no encontrado: " + email, exception.getMessage());
        verify(userRepository, times(1)).findByEmail(email);
    }
}
