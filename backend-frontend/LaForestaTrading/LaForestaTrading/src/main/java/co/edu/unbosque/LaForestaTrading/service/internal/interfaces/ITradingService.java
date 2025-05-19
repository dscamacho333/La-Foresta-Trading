package co.edu.unbosque.LaForestaTrading.service.internal.interfaces;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.AccountDTO;

public interface ITradingService {

    boolean register(AccountDTO dto, String password);

}
