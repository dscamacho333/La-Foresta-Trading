package co.edu.unbosque.LaForestaTrading.service.internal.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.PortfolioHistoryDTO;
import co.edu.unbosque.LaForestaTrading.dto.position.PositionDTO;
import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.entity.Order;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import co.edu.unbosque.LaForestaTrading.repository.IOrderRepository;
import co.edu.unbosque.LaForestaTrading.repository.IUserRepository;
import co.edu.unbosque.LaForestaTrading.service.external.interfaces.IAlpacaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PortfolioServiceImplTest {

    private IAlpacaService alpacaService;
    private IUserRepository userRepository;
    private IOrderRepository orderRepository;
    private PortfolioServiceImpl service;

    @BeforeEach
    void setUp() {
        alpacaService = mock(IAlpacaService.class);
        userRepository = mock(IUserRepository.class);
        orderRepository = mock(IOrderRepository.class);
        service = new PortfolioServiceImpl(alpacaService, userRepository, orderRepository);
    }

    @Test
    void testGetPortfolioHistorySuccess() {
        Investor investor = new Investor();
        investor.setAlpacaId("alpaca-id");
        investor.setId(1L);

        PortfolioHistoryDTO mockHistory = new PortfolioHistoryDTO();

        when(userRepository.findById(1L)).thenReturn(Optional.of(investor));
        when(alpacaService.getPortfolioHistory("alpaca-id")).thenReturn(mockHistory);

        PortfolioHistoryDTO result = service.getPortfolioHistory(1L);

        assertNotNull(result);
        verify(userRepository).findById(1L);
        verify(alpacaService).getPortfolioHistory("alpaca-id");
    }

    @Test
    void testGetPortfolioHistoryUserNotFound() {
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(UserException.class, () -> service.getPortfolioHistory(999L));
    }

    @Test
    void testGetNetPositions() {
        Order o1 = new Order();
        o1.setSymbol("AAPL");
        o1.setSide("BUY");
        o1.setQty("5");
        o1.setStatus("FILLED");

        Order o2 = new Order();
        o2.setSymbol("AAPL");
        o2.setSide("SELL");
        o2.setQty("2");
        o2.setStatus("FILLED");

        Order o3 = new Order();
        o3.setSymbol("GOOG");
        o3.setSide("BUY");
        o3.setQty("3");
        o3.setStatus("FILLED");

        Order o4 = new Order();
        o4.setSymbol("GOOG");
        o4.setSide("SELL");
        o4.setQty("2");
        o4.setStatus("FILLED");

        Order o5 = new Order();
        o5.setSymbol("TSLA");
        o5.setSide("BUY");
        o5.setQty("1");
        o5.setStatus("FILLED");

        Order o6 = new Order();
        o6.setSymbol("TSLA");
        o6.setSide("SELL");
        o6.setQty("1");
        o6.setStatus("FILLED");

        when(orderRepository.findByStatusNotIgnoreCase("accepted"))
                .thenReturn(List.of(o1, o2, o3, o4, o5, o6));

        List<PositionDTO> positions = service.getNetPositions();

        assertEquals(2, positions.size());
        assertTrue(positions.stream().anyMatch(p -> p.getSymbol().equals("AAPL") && p.getQuantity() == 3));
        assertTrue(positions.stream().anyMatch(p -> p.getSymbol().equals("GOOG") && p.getQuantity() == 1));
        assertFalse(positions.stream().anyMatch(p -> p.getSymbol().equals("TSLA")));
    }
}
