package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.controller.interfaces.IOrderHistoryController;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.OrderDTO;
import co.edu.unbosque.LaForestaTrading.entity.User;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.ITradingService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class OrderHistoryController implements IOrderHistoryController {

    private final ITradingService tradingService;

    public OrderHistoryController(ITradingService tradingService) {
        this.tradingService = tradingService;
    }

    @Override
    public String showOrderHistoryPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        List<OrderDTO> orders = tradingService.listOrderdByInvestorId(user.getId());
        model.addAttribute("orders", orders);

        return "order-history";
    }
}
