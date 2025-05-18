package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.controller.interfaces.INavController;
import org.springframework.stereotype.Controller;

@Controller
public class NavControllerImpl implements INavController {

    @Override
    public String showIndex() {
        return "index";
    }
}
