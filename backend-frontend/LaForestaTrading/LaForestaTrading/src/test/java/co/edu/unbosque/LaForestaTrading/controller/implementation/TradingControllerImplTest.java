package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.OrderDTO;
import co.edu.unbosque.LaForestaTrading.entity.User;
import co.edu.unbosque.LaForestaTrading.exception.OrderException;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.ITradingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TradingControllerImplTest {

    private ITradingService tradingService;
    private TradingControllerImpl controller;
    private Model model;

    @BeforeEach
    void setUp() {
        tradingService = mock(ITradingService.class);
        controller = new TradingControllerImpl(tradingService);
        model = mock(Model.class);
    }

    @Test
    void testShowTradingPage() {
        String viewName = controller.showTradingPage(model);

        verify(model).addAttribute(eq("orderDTO"), any(OrderDTO.class));
        assertEquals("trading", viewName);
    }

    @Test
    void testExecuteOrderSuccess() {
        OrderDTO orderDTO = new OrderDTO();
        User user = new User();
        user.setId(42L);

        // Mock security context
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(authentication.getPrincipal()).thenReturn(user);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        try (MockedStatic<SecurityContextHolder> mockedStatic = mockStatic(SecurityContextHolder.class)) {
            mockedStatic.when(SecurityContextHolder::getContext).thenReturn(securityContext);

            String viewName = controller.executeOrder(orderDTO, model);

            verify(tradingService).executeOrder(orderDTO, 42L);
            verify(model).addAttribute("success", "¡Orden ejecutada correctamente!");
            verify(model).addAttribute(eq("orderDTO"), any(OrderDTO.class));

            assertEquals("trading", viewName);
        }
    }

    @Test
    void testExecuteOrderThrowsOrderException() {
        OrderDTO orderDTO = new OrderDTO();
        User user = new User();
        user.setId(99L);

        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(authentication.getPrincipal()).thenReturn(user);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        doThrow(new OrderException("Fallo al ejecutar orden")).when(tradingService).executeOrder(orderDTO, 99L);

        try (MockedStatic<SecurityContextHolder> mockedStatic = mockStatic(SecurityContextHolder.class)) {
            mockedStatic.when(SecurityContextHolder::getContext).thenReturn(securityContext);

            String viewName = controller.executeOrder(orderDTO, model);

            verify(tradingService).executeOrder(orderDTO, 99L);
            verify(model).addAttribute("error", "Fallo al ejecutar orden");
            verify(model).addAttribute(eq("orderDTO"), any(OrderDTO.class));

            assertEquals("trading", viewName);
        }
    }
}
