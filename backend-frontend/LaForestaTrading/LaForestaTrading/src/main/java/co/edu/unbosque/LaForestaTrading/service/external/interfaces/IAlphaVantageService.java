package co.edu.unbosque.LaForestaTrading.service.external.interfaces;

import co.edu.unbosque.LaForestaTrading.dto.quote.request.GlobalQuoteDTO;

public interface IAlphaVantageService {

    GlobalQuoteDTO getFullQuote(String symbol);

}
