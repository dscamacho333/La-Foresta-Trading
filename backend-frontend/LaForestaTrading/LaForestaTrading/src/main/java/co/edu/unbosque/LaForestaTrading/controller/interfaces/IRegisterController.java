package co.edu.unbosque.LaForestaTrading.controller.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/register")
public interface IRegisterController {

    @GetMapping
    String showRegisterPage();

    @PostMapping
    String registerAccount(
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            @RequestParam String street,
            @RequestParam String city,
            @RequestParam String state,
            @RequestParam String postalCode,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String birthDate,
            @RequestParam String idNumber,
            @RequestParam(required = false) boolean isControlPerson,
            @RequestParam(required = false) boolean isAffiliatedExchangeOrFinra,
            @RequestParam(required = false) boolean isAffiliatedExchangeOrIiroc,
            @RequestParam(required = false) boolean isPoliticallyExposed,
            @RequestParam(required = false) boolean immediateFamilyExposed,
            @RequestParam(required = false) boolean isDiscretionary,
            @RequestParam(required = false) boolean agreedToTerms,
            HttpServletRequest request,
            Model model
    );

}
