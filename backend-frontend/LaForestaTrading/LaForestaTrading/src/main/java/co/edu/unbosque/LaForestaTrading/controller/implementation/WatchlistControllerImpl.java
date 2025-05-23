package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.controller.interfaces.IWatchlistController;
import org.springframework.stereotype.Controller;

@Controller
public class WatchlistControllerImpl implements IWatchlistController {
    @Override
    public String showWatchlistPage() {
        return "watchlist";
    }
}
