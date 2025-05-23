package co.edu.unbosque.LaForestaTrading.controller.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/subscription")
public interface ISubscriptionController {

    @GetMapping
    String showSubscriptionPage();

    @GetMapping("/success")
    String showSuccessPage();

    @GetMapping("/error")
    String showErrorPage();

    @PostMapping("/api/stripe/create-checkout-session")
    RedirectView createCheckoutSession(
            @RequestParam("userId") Long userId,
            @RequestParam("email") String email,
            @RequestParam("plan") String plan
    );


}
