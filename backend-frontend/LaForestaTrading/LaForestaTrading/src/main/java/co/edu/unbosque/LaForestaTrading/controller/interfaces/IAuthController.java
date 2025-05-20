package co.edu.unbosque.LaForestaTrading.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface IAuthController {

    @GetMapping("/login")
    String loginPage(Model model);

    @GetMapping("/dashboard")
    String dashboard();


}
