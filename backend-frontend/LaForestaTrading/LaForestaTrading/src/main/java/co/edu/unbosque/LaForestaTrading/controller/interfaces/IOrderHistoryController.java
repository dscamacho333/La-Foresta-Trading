package co.edu.unbosque.LaForestaTrading.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order-histoy")
public interface IOrderHistoryController {

    @GetMapping
    String showOrderHistoryPage(Model model);


}
