package co.edu.unbosque.LaForestaTrading.controller.implementation;

import co.edu.unbosque.LaForestaTrading.controller.interfaces.IRegisterController;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.*;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.ITradingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class RegisterControllerImpl implements IRegisterController {

    private final ITradingService tradingService;

    public RegisterControllerImpl(ITradingService tradingService) {
        this.tradingService = tradingService;
    }

    @Override
    public String showRegisterPage() {
        return "register";
    }

    @Override
    public String registerAccount(String email, String phone, String password, String confirmPassword, String street, String city, String state, String postalCode, String firstName, String lastName, String birthDate, String idNumber, boolean isControlPerson, boolean isAffiliatedExchangeOrFinra, boolean isAffiliatedExchangeOrIiroc, boolean isPoliticallyExposed, boolean immediateFamilyExposed, boolean isDiscretionary, boolean agreedToTerms, HttpServletRequest request, Model model) {


        if (!agreedToTerms) {
            model.addAttribute("error", "Debes aceptar los términos y condiciones");
            return "register";
        }

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden");
            return "register";
        }

        ContactDTO contactDTO = new ContactDTO(
                email,
                phone,
                List.of(street),
                city,
                state,
                postalCode
        );

        IdentityDTO identityDTO = new IdentityDTO();
        identityDTO.setGivenName(firstName);
        identityDTO.setFamilyName(lastName);
        identityDTO.setDateOfBirth(birthDate);
        identityDTO.setTaxId(idNumber);

        DisclosureDTO disclosureDTO = new DisclosureDTO(
                isControlPerson,
                isAffiliatedExchangeOrFinra,
                isAffiliatedExchangeOrIiroc,
                isPoliticallyExposed,
                immediateFamilyExposed,
                isDiscretionary
        );

        String signedAt = DateTimeFormatter.ISO_INSTANT.format(Instant.now());
        String ip = request.getRemoteAddr();
        AgreementDTO agreementDTO = new AgreementDTO("customer_agreement", signedAt, ip);

        AccountDTO accountDTO = new AccountDTO(
                contactDTO,
                identityDTO,
                disclosureDTO,
                List.of(agreementDTO)
        );

        try {
            tradingService.register(accountDTO, password);
            model.addAttribute("success", "Cuenta registrada exitosamente");
        }
        catch(UserException e){
            model.addAttribute("error", e.getMessage());
        }
        return "register";
    }
}
