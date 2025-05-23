package co.edu.unbosque.LaForestaTrading.controller.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/watchlist")
public interface IWatchlistController {

    @GetMapping
    String showWatchlistPage();

}
