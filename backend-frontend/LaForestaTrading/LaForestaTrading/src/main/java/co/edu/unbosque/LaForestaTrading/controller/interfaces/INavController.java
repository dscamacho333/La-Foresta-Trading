package co.edu.unbosque.LaForestaTrading.controller.interfaces;

import org.springframework.web.bind.annotation.GetMapping;

public interface INavController {

    @GetMapping("/")
    String showIndex();

}
