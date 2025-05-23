package co.edu.unbosque.LaForestaTrading.service.internal.interfaces;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.PortfolioHistoryDTO;
import co.edu.unbosque.LaForestaTrading.dto.position.PositionDTO;

import java.util.List;

public interface IPortfolioService {
    PortfolioHistoryDTO getPortfolioHistory(Long userId);
    List<PositionDTO> getNetPositions();
}
