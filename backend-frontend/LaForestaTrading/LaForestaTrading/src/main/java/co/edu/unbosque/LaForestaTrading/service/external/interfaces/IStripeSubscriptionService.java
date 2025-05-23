package co.edu.unbosque.LaForestaTrading.service.external.interfaces;

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

public interface IStripeSubscriptionService {
    Session createCheckoutSession(Long userId, String email, String plan) throws StripeException;
}
