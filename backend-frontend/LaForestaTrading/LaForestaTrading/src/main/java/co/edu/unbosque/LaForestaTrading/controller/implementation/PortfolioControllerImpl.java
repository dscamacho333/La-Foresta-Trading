package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.controller.interfaces.IPortfolioController;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.PortfolioHistoryDTO;
import co.edu.unbosque.LaForestaTrading.dto.position.PositionDTO;
import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.entity.User;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.IPortfolioService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class PortfolioControllerImpl implements IPortfolioController {


    private final IPortfolioService portfolioService;

    public PortfolioControllerImpl(IPortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @Override
    public String showPortafolioPage(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (Investor) auth.getPrincipal();

        PortfolioHistoryDTO history = portfolioService.getPortfolioHistory(user.getId());
        model.addAttribute("history", history);
        List<PositionDTO> positions= portfolioService.getNetPositions();
        model.addAttribute("positions", positions);
        return "portfolio-chart";
    }

}
