package co.edu.unbosque.LaForestaTrading.controller.interfaces;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.OrderDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/trading")
public interface ITradingController {

    @GetMapping
    String showTradingPage(Model model);

    @PostMapping("/order")
    String executeOrder(@ModelAttribute OrderDTO orderDTO, Model model);

}
