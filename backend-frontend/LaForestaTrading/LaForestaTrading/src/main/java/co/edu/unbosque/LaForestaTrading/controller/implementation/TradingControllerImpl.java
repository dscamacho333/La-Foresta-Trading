package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.controller.interfaces.ITradingController;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.OrderDTO;
import co.edu.unbosque.LaForestaTrading.entity.User;
import co.edu.unbosque.LaForestaTrading.exception.OrderException;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.ITradingService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class TradingControllerImpl implements ITradingController {

    private final ITradingService tradingService;

    public TradingControllerImpl(ITradingService tradingService) {
        this.tradingService = tradingService;
    }

    @Override
    public String showTradingPage(Model model) {
        model.addAttribute("orderDTO", new OrderDTO());
        return "trading";
    }

    @Override
    public String executeOrder(OrderDTO orderDTO, Model model) {
        try {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = (User) auth.getPrincipal();

            tradingService.executeOrder(orderDTO, user.getId());

            model.addAttribute("success", "¡Orden ejecutada correctamente!");
        } catch (OrderException e) {
            model.addAttribute("error", e.getMessage());
        }

        model.addAttribute("orderDTO", new OrderDTO());
        return "trading";
    }


}
