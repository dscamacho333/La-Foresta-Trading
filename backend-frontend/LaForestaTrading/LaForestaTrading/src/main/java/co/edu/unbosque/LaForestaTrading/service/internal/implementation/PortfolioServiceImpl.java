package co.edu.unbosque.LaForestaTrading.service.internal.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.PortfolioHistoryDTO;
import co.edu.unbosque.LaForestaTrading.dto.position.PositionDTO;
import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.entity.Order;
import co.edu.unbosque.LaForestaTrading.entity.User;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import co.edu.unbosque.LaForestaTrading.repository.IOrderRepository;
import co.edu.unbosque.LaForestaTrading.repository.IUserRepository;
import co.edu.unbosque.LaForestaTrading.service.external.interfaces.IAlpacaService;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.IPortfolioService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PortfolioServiceImpl implements IPortfolioService {

    private final IAlpacaService alpacaService;
    private final IUserRepository userRepository;
    private final IOrderRepository orderRepository;

    public PortfolioServiceImpl(IAlpacaService alpacaService, IUserRepository userRepository, IOrderRepository orderRepository) {
        this.alpacaService = alpacaService;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public PortfolioHistoryDTO getPortfolioHistory(Long userId) {
        Investor investor = (Investor) userRepository.findById(userId).orElseThrow(() -> new UserException(""));
        return alpacaService.getPortfolioHistory(investor.getAlpacaId());
    }

    @Override
    public List<PositionDTO> getNetPositions() {
        List<Order> filledOrders = orderRepository.findByStatusNotIgnoreCase("accepted");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (Investor) auth.getPrincipal();

        Map<String, Integer> symbolQuantities = new HashMap<>();



        for (Order order : filledOrders) {

            if(order.getInvestor().getEmail().equalsIgnoreCase(user.getEmail())){
                String symbol = order.getSymbol();
                int quantity = Integer.valueOf(order.getQty());
                if ("BUY".equalsIgnoreCase(order.getSide())) {
                    symbolQuantities.merge(symbol, quantity, Integer::sum);
                } else if ("SELL".equalsIgnoreCase(order.getSide())) {
                    symbolQuantities.merge(symbol, -quantity, Integer::sum);
                }
            }
        }

        return symbolQuantities.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(entry -> new PositionDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
