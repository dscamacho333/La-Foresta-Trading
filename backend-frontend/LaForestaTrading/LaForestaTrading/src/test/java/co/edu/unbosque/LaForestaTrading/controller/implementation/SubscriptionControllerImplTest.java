package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.service.external.interfaces.IStripeSubscriptionService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.view.RedirectView;
import com.stripe.exception.ApiException;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SubscriptionControllerImplTest {

    private IStripeSubscriptionService stripeSubscriptionService;
    private SubscriptionControllerImpl controller;

    @BeforeEach
    void setUp() {
        stripeSubscriptionService = mock(IStripeSubscriptionService.class);
        controller = new SubscriptionControllerImpl(stripeSubscriptionService);
    }

    @Test
    void testShowSubscriptionPage() {
        String viewName = controller.showSubscriptionPage();
        assertEquals("subscription", viewName);
    }

    @Test
    void testShowSuccessPage() {
        String viewName = controller.showSuccessPage();
        assertEquals("stripe-success", viewName);
    }

    @Test
    void testShowErrorPage() {
        String viewName = controller.showErrorPage();
        assertEquals("stripe-error", viewName);
    }

    @Test
    void testCreateCheckoutSessionSuccess() throws StripeException {
        Long userId = 1L;
        String email = "test@example.com";
        String plan = "mensual";

        Session mockSession = mock(Session.class);
        when(mockSession.getUrl()).thenReturn("https://stripe.com/checkout/session/abc123");
        when(stripeSubscriptionService.createCheckoutSession(userId, email, plan)).thenReturn(mockSession);

        RedirectView result = controller.createCheckoutSession(userId, email, plan);

        assertNotNull(result);
        assertEquals("https://stripe.com/checkout/session/abc123", result.getUrl());
    }


    @Test
    void testCreateCheckoutSessionFailure() throws StripeException {
        Long userId = 1L;
        String email = "test@example.com";
        String plan = "mensual";

        // Usar ApiException en lugar de StripeException directamente
        when(stripeSubscriptionService.createCheckoutSession(userId, email, plan))
                .thenThrow(new ApiException("Stripe error", null, null, 500, null));

        RedirectView result = controller.createCheckoutSession(userId, email, plan);

        assertNotNull(result);
        assertEquals("/suscription/error", result.getUrl());
    }

}
