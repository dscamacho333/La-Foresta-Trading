package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.controller.interfaces.IAuthController;
import co.edu.unbosque.LaForestaTrading.dto.auth.LoginRequestDTO;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.IAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AuthControllerImpl implements IAuthController {

    private final IAuthService authService;

    public AuthControllerImpl(IAuthService authService) {
        this.authService = authService;
    }

    @Override
    public String loginPage(Model model) {
        model.addAttribute("loginRequestDTO", new LoginRequestDTO());
        return "login";
    }

    @Override
    public String dashboard() {
        return "dashboard";
    }


}
