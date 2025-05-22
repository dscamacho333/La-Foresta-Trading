package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.OrderDTO;
import co.edu.unbosque.LaForestaTrading.entity.User;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.ITradingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderHistoryControllerTest {

    private ITradingService tradingService;
    private OrderHistoryController controller;

    @BeforeEach
    void setUp() {
        tradingService = mock(ITradingService.class);
        controller = new OrderHistoryController(tradingService);
    }

    @Test
    void testShowOrderHistoryPage_ReturnsCorrectViewAndModel() {
        // Arrange
        Long userId = 10L;
        User mockUser = new User();
        mockUser.setId(userId);

        Authentication auth = mock(Authentication.class);
        when(auth.getPrincipal()).thenReturn(mockUser);

        Model model = mock(Model.class);
        List<OrderDTO> mockOrders = Collections.singletonList(new OrderDTO());
        when(tradingService.listOrderdByInvestorId(userId)).thenReturn(mockOrders);

        var mockSecurityContext = mock(org.springframework.security.core.context.SecurityContext.class);

        try (MockedStatic<SecurityContextHolder> mockedStatic = mockStatic(SecurityContextHolder.class)) {

            mockedStatic.when(SecurityContextHolder::getContext).thenReturn(mockSecurityContext);
            when(mockSecurityContext.getAuthentication()).thenReturn(auth);

            // Act
            String viewName = controller.showOrderHistoryPage(model);

            // Assert
            assertEquals("order-history", viewName);
            verify(tradingService).listOrderdByInvestorId(userId);
            verify(model).addAttribute("orders", mockOrders);
        }
    }

}
