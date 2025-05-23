package co.edu.unbosque.LaForestaTrading.dto.quote.response;

import co.edu.unbosque.LaForestaTrading.dto.quote.request.GlobalQuoteDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GlobalQuoteResponseDTO {

    @JsonProperty("Global Quote")
    private GlobalQuoteDTO globalQuote;

    public GlobalQuoteResponseDTO() {
    }

    public GlobalQuoteResponseDTO(GlobalQuoteDTO globalQuote) {
        this.globalQuote = globalQuote;
    }

    public GlobalQuoteDTO getGlobalQuote() {
        return globalQuote;
    }

    public void setGlobalQuote(GlobalQuoteDTO globalQuote) {
        this.globalQuote = globalQuote;
    }

}
