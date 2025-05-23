package co.edu.unbosque.LaForestaTrading.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/portafolio")
public interface IPortfolioController {

    @GetMapping
    String showPortafolioPage(Model model);

}
