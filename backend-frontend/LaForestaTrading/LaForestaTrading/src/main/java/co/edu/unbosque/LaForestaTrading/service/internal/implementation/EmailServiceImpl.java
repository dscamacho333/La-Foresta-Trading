package co.edu.unbosque.LaForestaTrading.service.internal.implementation;

import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.entity.Order;
import co.edu.unbosque.LaForestaTrading.exception.EmailException;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.IEmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService {

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String topic, String body) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(to);
        mensaje.setSubject(topic);
        mensaje.setText(body);
        mailSender.send(mensaje);
    }

    @Override
    public void sendConfirmationEmail(Order order, Investor investor) {


        if (order == null || investor == null || investor.getEmail() == null) {
            throw new EmailException("Error al enviar el correo!");
        }

        String to = investor.getEmail();
        String subject = "Confirmación de Orden de Trading";

        String body = "Hola, nos alegramos de que nos escojas a nosotros para realizar operaciones de trading.\n\n"
                + "Aquí tienes un resumen de tu orden en espera de ser confirmada:\n\n"
                + "🆔 Estado: " + safe(order.getStatus()) + "\n"
                + "📈 Acción: " + ("buy".equalsIgnoreCase(order.getSide()) ? "Compra" : "Venta") + "\n"
                + "💼 Tipo: " + safe(order.getType()) + "\n"
                + "🔖 Símbolo: " + safe(order.getSymbol()) + "\n"
                + "💰 Precio estimado: " + safe(order.getFilledAvgPrice()) + " USD\n"
                + "🕓 Fecha de ejecución local: " + (order.getLocalCreationDate() != null ? order.getLocalCreationDate().toString() : "Desconocida") + "\n\n"
                + "Gracias por confiar en La Foresta Trading.\n"
                + "Este correo es automático, no responda.";

        sendEmail(to, subject, body);
    }

    @Override
    public void sendConfirmationForExcutedOrder(Order order, Investor investor) {
        if (order == null || investor == null || investor.getEmail() == null) {
            throw new EmailException("Error al enviar el correo!");
        }

        String to = investor.getEmail();
        String subject = "Tu orden ha sido procesada exitosamente!";

        String body = "Hola, nos alegramos de que nos escojas a nosotros para realizar operaciones de trading.\n\n"
                + "Aquí tienes un resumen de tu orden completada:\n\n"
                + "🆔 Estado: " + safe(order.getStatus()) + "\n"
                + "📈 Acción: " + ("buy".equalsIgnoreCase(order.getSide()) ? "Compra" : "Venta") + "\n"
                + "💼 Tipo: " + safe(order.getType()) + "\n"
                + "🔖 Símbolo: " + safe(order.getSymbol()) + "\n"
                + "💰 Precio estimado: " + safe(order.getFilledAvgPrice()) + " USD\n"
                + "🕓 Fecha de ejecución local: " + (order.getLocalCreationDate() != null ? order.getLocalCreationDate().toString() : "Desconocida") + "\n\n"
                + "Gracias por confiar en La Foresta Trading.\n"
                + "Este correo es automático, no responda.";

        sendEmail(to, subject, body);
    }

    private String safe(String value) {
        return value != null ? value : "N/A";
    }
}
