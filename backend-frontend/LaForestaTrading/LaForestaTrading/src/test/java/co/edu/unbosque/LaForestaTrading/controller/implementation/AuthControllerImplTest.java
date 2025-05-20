package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.dto.auth.LoginRequestDTO;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.IAuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AuthControllerImplTest {

    private IAuthService authService;
    private AuthControllerImpl authController;

    @BeforeEach
    void setUp() {
        authService = mock(IAuthService.class);
        authController = new AuthControllerImpl(authService);
    }

    @Test
    void loginPageShouldAddLoginRequestDTOToModelAndReturnLoginView() {
        // Arrange
        Model model = mock(Model.class);
        ArgumentCaptor<LoginRequestDTO> captor = ArgumentCaptor.forClass(LoginRequestDTO.class);

        // Act
        String viewName = authController.loginPage(model);

        // Assert
        verify(model).addAttribute(eq("loginRequestDTO"), captor.capture());
        assertEquals("login", viewName);
        assertEquals(LoginRequestDTO.class, captor.getValue().getClass());
    }

    @Test
    void dashboardShouldReturnDashboardView() {
        // Act
        String viewName = authController.dashboard();

        // Assert
        assertEquals("dashboard", viewName);
        verifyNoInteractions(authService); // opcional pero garantiza que no se llama nada en el service
    }
}
