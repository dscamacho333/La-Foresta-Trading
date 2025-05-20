package co.edu.unbosque.LaForestaTrading.service.external.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.AccountDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountResponseDTO;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import co.edu.unbosque.LaForestaTrading.service.external.interfaces.IAlpacaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

@Service
public class AlpacaServiceImpl implements IAlpacaService {

    private final RestTemplate restTemplate;

    @Value("${alpaca.api.key}")
    private String apiKey;

    @Value("${alpaca.api.secret}")
    private String apiSecret;

    private final String baseUrl = "https://broker-api.sandbox.alpaca.markets/v1";

    public AlpacaServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public AccountResponseDTO createAccount(AccountDTO dto) {

        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setBasicAuth(apiKey, apiSecret);
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<AccountDTO> request = new HttpEntity<>(dto, headers);

            ResponseEntity<AccountResponseDTO> response = restTemplate
                    .exchange(
                            baseUrl + "/accounts",
                            HttpMethod.POST,
                            request,
                            AccountResponseDTO.class
                    );
            return response
                    .getBody();
        }
        catch (RestClientException e) {
            throw new UserException("Error al registrarse: El correo que trata de usar ya está registrado en el sistema");
        }
    }

    @Override
    public AccountResponseDTO getAnAccountById(String accountId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(apiKey, apiSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<AccountResponseDTO> response = restTemplate
                .exchange(
                        baseUrl + "/accounts/" + accountId,
                        HttpMethod.GET,
                        request,
                        AccountResponseDTO.class
                );
        return response
                .getBody();
    }

}
