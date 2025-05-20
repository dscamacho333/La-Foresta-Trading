package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.exception.UserException;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.ITradingService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RegisterControllerImplTest {

    private RegisterControllerImpl controller;
    private ITradingService tradingService;

    @BeforeEach
    public void setUp() {
        tradingService = mock(ITradingService.class);
        controller = new RegisterControllerImpl(tradingService);
    }

    @Test
    public void testShowRegisterPage() {
        assertEquals("register", controller.showRegisterPage());
    }

    @Test
    public void testRegisterAccountTermsNotAccepted() {
        Model model = mock(Model.class);
        HttpServletRequest request = mock(HttpServletRequest.class);

        String result = controller.registerAccount(
                "test@test.com", "123456", "pass", "pass",
                "Street", "City", "State", "12345",
                "John", "Doe", "2000-01-01", "123456789",
                false, false, false, false, false, false,
                false, request, model);

        verify(model).addAttribute("error", "Debes aceptar los términos y condiciones");
        assertEquals("register", result);
    }

    @Test
    public void testRegisterAccountPasswordMismatch() {
        Model model = mock(Model.class);
        HttpServletRequest request = mock(HttpServletRequest.class);

        String result = controller.registerAccount(
                "test@test.com", "123456", "pass", "fail",
                "Street", "City", "State", "12345",
                "John", "Doe", "2000-01-01", "123456789",
                false, false, false, false, false, false,
                true, request, model);

        verify(model).addAttribute("error", "Las contraseñas no coinciden");
        assertEquals("register", result);
    }

    @Test
    public void testRegisterAccountSuccess() {
        Model model = mock(Model.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRemoteAddr()).thenReturn("127.0.0.1");

        String result = controller.registerAccount(
                "test@test.com", "1234567890", "password", "password",
                "Street 1", "City", "State", "12345",
                "John", "Doe", "2000-01-01", "123456789",
                false, false, false, false, false, false,
                true, request, model
        );

        verify(tradingService).register(any(), eq("password"));
        verify(model).addAttribute("success", "Cuenta registrada exitosamente");
        assertEquals("register", result);
    }

    @Test
    public void testRegisterAccountThrowsUserException() {
        Model model = mock(Model.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRemoteAddr()).thenReturn("127.0.0.1");

        doThrow(new UserException("Correo ya registrado")).when(tradingService)
                .register(any(), eq("password"));

        String result = controller.registerAccount(
                "test@test.com", "1234567890", "password", "password",
                "Street 1", "City", "State", "12345",
                "John", "Doe", "2000-01-01", "123456789",
                false, false, false, false, false, false,
                true, request, model
        );

        verify(model).addAttribute("error", "Correo ya registrado");
        assertEquals("register", result);
    }
}
