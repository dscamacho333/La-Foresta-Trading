package co.edu.unbosque.LaForestaTrading.service.external.implementation;

import co.edu.unbosque.LaForestaTrading.service.external.interfaces.IStripeSubscriptionService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeSubscriptionServiceImpl implements IStripeSubscriptionService {

    @Value("${stripe.api.secret}")
    String stripeSecretKey;

    @Value("${stripe.price.id.monthly}")
    String monthlyPriceId;

    @Value("${stripe.price.id.annual}")
    String annualPriceId;

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeSecretKey;
    }

    @Override
    public Session createCheckoutSession(Long userId, String email, String plan) throws StripeException {
        String priceId = "mensual".equalsIgnoreCase(plan) ? monthlyPriceId : annualPriceId;

        SessionCreateParams params = SessionCreateParams.builder()
                .setCustomerEmail(email)
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
                .setSuccessUrl("http://localhost:8080/subscription/success")
                .setCancelUrl("http://localhost:8080/subscription/cancel")
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setPrice(priceId)
                        .setQuantity(1L)
                        .build())
                .putMetadata("userId", String.valueOf(userId))
                .putMetadata("plan", plan)
                .build();

        return Session.create(params);
    }


}
