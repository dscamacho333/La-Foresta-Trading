package co.edu.unbosque.LaForestaTrading.service.external.implementation;

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;

class StripeSubscriptionServiceImplTest {

    private StripeSubscriptionServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new StripeSubscriptionServiceImpl();
        service.stripeSecretKey = "sk_test_123";
        service.monthlyPriceId = "price_monthly_123";
        service.annualPriceId = "price_annual_123";

        service.init(); // set Stripe.apiKey
    }

    @Test
    void testCreateCheckoutSession_MonthlyPlan_Success() throws StripeException {
        Long userId = 1L;
        String email = "test@example.com";
        String plan = "mensual";

        Session fakeSession = new Session();
        fakeSession.setUrl("https://checkout.stripe.com/session/test");

        try (MockedStatic<Session> mockedStatic = Mockito.mockStatic(Session.class)) {
            mockedStatic.when(() -> Session.create(any(SessionCreateParams.class))).thenReturn(fakeSession);

            Session result = service.createCheckoutSession(userId, email, plan);

            assertNotNull(result);
            assertEquals("https://checkout.stripe.com/session/test", result.getUrl());
        }
    }

    @Test
    void testCreateCheckoutSession_AnnualPlan_Success() throws StripeException {
        Long userId = 2L;
        String email = "annual@test.com";
        String plan = "anual";

        Session fakeSession = new Session();
        fakeSession.setUrl("https://checkout.stripe.com/session/annual");

        try (MockedStatic<Session> mockedStatic = Mockito.mockStatic(Session.class)) {
            mockedStatic.when(() -> Session.create(any(SessionCreateParams.class))).thenReturn(fakeSession);

            Session result = service.createCheckoutSession(userId, email, plan);

            assertNotNull(result);
            assertEquals("https://checkout.stripe.com/session/annual", result.getUrl());
        }
    }

    @Test
    void testCreateCheckoutSession_StripeThrowsException() {
        Long userId = 3L;
        String email = "fail@test.com";
        String plan = "mensual";

        try (MockedStatic<Session> mockedStatic = Mockito.mockStatic(Session.class)) {
            mockedStatic.when(() -> Session.create(any(SessionCreateParams.class)))
                    .thenThrow(new com.stripe.exception.ApiException("Error", null, null, 500, null));

            assertThrows(StripeException.class, () -> {
                service.createCheckoutSession(userId, email, plan);
            });
        }
    }
}
