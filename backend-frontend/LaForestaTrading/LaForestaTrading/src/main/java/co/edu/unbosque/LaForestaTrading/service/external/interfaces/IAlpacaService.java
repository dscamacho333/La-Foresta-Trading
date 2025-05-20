package co.edu.unbosque.LaForestaTrading.service.external.interfaces;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.AccountDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountResponseDTO;

public interface IAlpacaService {

    AccountResponseDTO createAccount(AccountDTO dto);

    AccountResponseDTO getAnAccountById(String accountId);

}
