package co.edu.unbosque.LaForestaTrading.service.internal.interfaces;

import co.edu.unbosque.LaForestaTrading.dto.quote.request.GlobalQuoteDTO;

public interface IQuoteService {

    GlobalQuoteDTO getFullQuote(String symbol);

}
