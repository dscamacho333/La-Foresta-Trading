package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.PortfolioHistoryDTO;
import co.edu.unbosque.LaForestaTrading.dto.position.PositionDTO;
import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.IPortfolioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PortfolioControllerImplTest {

    private IPortfolioService portfolioService;
    private Model model;
    private PortfolioControllerImpl controller;

    @BeforeEach
    void setUp() {
        portfolioService = mock(IPortfolioService.class);
        model = mock(Model.class);
        controller = new PortfolioControllerImpl(portfolioService);
    }

    @Test
    void testShowPortafolioPage() {
        // Arrange
        Investor investor = new Investor();
        investor.setId(1L);

        PortfolioHistoryDTO fakeHistory = new PortfolioHistoryDTO();
        List<PositionDTO> fakePositions = List.of(new PositionDTO("AAPL", 3));

        // Mock seguridad
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(investor);
        SecurityContextHolder.setContext(securityContext);

        when(portfolioService.getPortfolioHistory(1L)).thenReturn(fakeHistory);
        when(portfolioService.getNetPositions()).thenReturn(fakePositions);

        // Act
        String viewName = controller.showPortafolioPage(model);

        // Assert
        assertEquals("portfolio-chart", viewName);
        verify(portfolioService).getPortfolioHistory(1L);
        verify(portfolioService).getNetPositions();
        verify(model).addAttribute("history", fakeHistory);
        verify(model).addAttribute("positions", fakePositions);
    }
}
