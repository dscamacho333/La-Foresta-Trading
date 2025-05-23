package co.edu.unbosque.LaForestaTrading.service.internal.interfaces;

import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.entity.Order;

public interface IEmailService {

    void sendEmail(String to, String topic, String body);

    void sendConfirmationEmail(Order order, Investor investor);

    void sendConfirmationForExcutedOrder(Order order, Investor investor);

}
