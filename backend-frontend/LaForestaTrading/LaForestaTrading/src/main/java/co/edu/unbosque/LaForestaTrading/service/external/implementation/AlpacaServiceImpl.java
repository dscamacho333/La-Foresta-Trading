package co.edu.unbosque.LaForestaTrading.service.external.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.AccountDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.OrderDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountResponseDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountTradingDetailDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.PortfolioHistoryDTO;
import co.edu.unbosque.LaForestaTrading.exception.OrderException;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import co.edu.unbosque.LaForestaTrading.service.external.interfaces.IAlpacaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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

    @Override
    public OrderDTO createAnOrderForAnAccount(OrderDTO dto, String accountId) {
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setBasicAuth(apiKey, apiSecret);
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<OrderDTO> request = new HttpEntity<>(dto, headers);

            ResponseEntity<OrderDTO> response = restTemplate
                    .exchange(
                            baseUrl + "/trading/accounts/" + accountId + "/orders",
                            HttpMethod.POST,
                            request,
                            OrderDTO.class
                    );

            return response
                    .getBody();
        }
        catch (RestClientException e) {
            throw new OrderException("Error al crear una orden, verifique lo siguiente: " + "\n" +
                                     "1) Posee fondos suficientes." + "\n" +
                                     "2) Simbolo de la acción es correcto" + "\n" +
                                     "Nota: Algunos patrones de compra/venta no están permitidos!");
        }
    }

    @Override
    public OrderDTO retrieveAnOrderByItsId(String accountId, String orderId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(apiKey, apiSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<OrderDTO> response = restTemplate
                .exchange(
                        baseUrl + "/trading/accounts/" + accountId + "/orders/" + orderId,
                        HttpMethod.GET,
                        request,
                        OrderDTO.class
                );
        return response
                .getBody();
    }

    @Override
    public AccountTradingDetailDTO retriieveTradingDetailsForAnAccount(String accountId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(apiKey, apiSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<AccountTradingDetailDTO> response = restTemplate
                .exchange(
                        baseUrl + "/trading/accounts/" + accountId + "/account",
                        HttpMethod.GET,
                        request,
                        AccountTradingDetailDTO.class
                );
        return response
                .getBody();
    }

    @Override
    public PortfolioHistoryDTO getPortfolioHistory(String accountId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(apiKey, apiSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        String url = UriComponentsBuilder
                .fromHttpUrl(baseUrl + "/trading/accounts/" + accountId + "/account/portfolio/history")
                .queryParam("timeframe", "1D")
                .queryParam("start", "2025-03-22T18:38:01Z")
                .queryParam("end", "2025-05-22T18:38:01Z")
                .queryParam("pnl_reset", "per_day")
                .queryParam("force_engine_version", "v2")
                .build()
                .toUriString();

        ResponseEntity<PortfolioHistoryDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                PortfolioHistoryDTO.class
        );

        return response.getBody();
    }

}
