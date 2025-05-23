package co.edu.unbosque.LaForestaTrading.service.external.implementation;

import co.edu.unbosque.LaForestaTrading.dto.quote.request.GlobalQuoteDTO;
import co.edu.unbosque.LaForestaTrading.dto.quote.response.GlobalQuoteResponseDTO;
import co.edu.unbosque.LaForestaTrading.exception.QuoteException;
import co.edu.unbosque.LaForestaTrading.service.external.interfaces.IAlphaVantageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphaVantageServiceImpl implements IAlphaVantageService {

    private final RestTemplate restTemplate;

    @Value("${alpha.vantage.api.key}")
    private String apiKey;

    private String baseUrl = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&";

    public AlphaVantageServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public GlobalQuoteDTO getFullQuote(String symbol) {
        try{
            String endpoint = baseUrl + "symbol=" + symbol + "&apikey=" + apiKey;
            GlobalQuoteResponseDTO response = restTemplate.getForObject(endpoint, GlobalQuoteResponseDTO.class);
            if (response == null || response.getGlobalQuote() == null) {
                throw new QuoteException("No quote data received for symbol: " + symbol);
            }

            return response.getGlobalQuote();
        }
        catch(RestClientException e){
            throw new QuoteException("No quote data received for symbol: " + symbol);
        }
    }

}
