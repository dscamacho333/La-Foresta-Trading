package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.controller.interfaces.ISubscriptionController;
import co.edu.unbosque.LaForestaTrading.service.external.interfaces.IStripeSubscriptionService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SubscriptionControllerImpl implements ISubscriptionController {

    private final IStripeSubscriptionService stripeSubscriptionService;

    public SubscriptionControllerImpl(IStripeSubscriptionService stripeSubscriptionService) {
        this.stripeSubscriptionService = stripeSubscriptionService;
    }

    @Override
    public String showSubscriptionPage() {
        return "subscription";
    }

    @Override
    public String showSuccessPage() {
        return "stripe-success";
    }

    @Override
    public String showErrorPage() {
        return "stripe-error";
    }

    @Override
    public RedirectView createCheckoutSession(Long userId, String email, String plan) {
        try {
            Session session = stripeSubscriptionService.createCheckoutSession(userId, email, plan);
            return new RedirectView(session.getUrl());
        } catch (StripeException e) {
            return new RedirectView("/suscription/error");
        }
    }

}
