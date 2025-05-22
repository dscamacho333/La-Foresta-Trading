package co.edu.unbosque.LaForestaTrading.service.internal.interfaces;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.AccountDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.OrderDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ITradingService {

    boolean register(AccountDTO dto, String password);

    void verificarCuentasPendientes();

    OrderDTO executeOrder(OrderDTO orderDTO, Long investorId);

    List<OrderDTO> listOrderdByInvestorId(Long investorId);

    void verificarOrdenesPendientes();

    BigDecimal getInvestorBuyingPower(Long userId);

}
