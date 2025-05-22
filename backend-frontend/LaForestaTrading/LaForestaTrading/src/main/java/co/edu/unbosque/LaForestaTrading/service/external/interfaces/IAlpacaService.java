package co.edu.unbosque.LaForestaTrading.service.external.interfaces;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.AccountDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.OrderDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountResponseDTO;

public interface IAlpacaService {

    AccountResponseDTO createAccount(AccountDTO dto);

    AccountResponseDTO getAnAccountById(String accountId);

    OrderDTO createAnOrderForAnAccount(OrderDTO dto, String accountId);

    OrderDTO retrieveAnOrderByItsId(String accountId, String orderId);

}
