package co.edu.unbosque.LaForestaTrading.service.internal.implementation;

import co.edu.unbosque.LaForestaTrading.dto.quote.request.GlobalQuoteDTO;
import co.edu.unbosque.LaForestaTrading.service.external.interfaces.IAlphaVantageService;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.IQuoteService;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements IQuoteService {

    private final IAlphaVantageService alphaVantageService;

    public QuoteServiceImpl(IAlphaVantageService alphaVantageService) {
        this.alphaVantageService = alphaVantageService;
    }

    @Override
    public GlobalQuoteDTO getFullQuote(String symbol) {
        return alphaVantageService.getFullQuote(symbol);
    }
}
