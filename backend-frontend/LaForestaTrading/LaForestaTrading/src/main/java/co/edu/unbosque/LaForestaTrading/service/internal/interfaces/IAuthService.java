package co.edu.unbosque.LaForestaTrading.service.internal.interfaces;

import co.edu.unbosque.LaForestaTrading.dto.auth.LoginRequestDTO;
import co.edu.unbosque.LaForestaTrading.entity.User;

public interface IAuthService {

    User authenticate(LoginRequestDTO dto);

}
