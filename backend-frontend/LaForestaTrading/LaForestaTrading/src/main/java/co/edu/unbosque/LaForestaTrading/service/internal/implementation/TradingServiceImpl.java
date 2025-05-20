package co.edu.unbosque.LaForestaTrading.service.internal.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.AccountDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountResponseDTO;
import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.entity.enums.UserStatus;
import co.edu.unbosque.LaForestaTrading.entity.enums.UserType;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import co.edu.unbosque.LaForestaTrading.mapper.InvestorMapper;
import co.edu.unbosque.LaForestaTrading.repository.IUserRepository;
import co.edu.unbosque.LaForestaTrading.service.external.interfaces.IAlpacaService;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.ITradingService;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TradingServiceImpl implements ITradingService {

    private final IUserRepository repo;
    private final ModelMapper modelMapper;
    private final IAlpacaService alpacaService;
    private final PasswordEncoder passwordEncoder;


    public TradingServiceImpl(IUserRepository repo, ModelMapper modelMapper, IAlpacaService alpacaService, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.modelMapper = modelMapper;
        this.alpacaService = alpacaService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(AccountDTO dto, String password) {

        try {

            Investor investor = repo.findByTaxId(dto.getIdentityDTO().getTaxId());

            if(investor != null){
                throw new UserException("Número de identificación duplicado");
            }

            investor = new Investor();

            AccountResponseDTO accountResponseDTO;
            accountResponseDTO = alpacaService.createAccount(dto);

            investor = InvestorMapper.fromAccountResponseDTO(accountResponseDTO, investor, password, dto.getIdentityDTO().getTaxId());


            investor.setFirstName(accountResponseDTO.getIdentityDTO().getGivenName());
            investor.setLastName(accountResponseDTO.getIdentityDTO().getFamilyName());
            investor.setEmail(accountResponseDTO.getContactDTO().getEmailAddress());
            investor.setPasswordHash(passwordEncoder.encode(password));
            investor.setStatus(UserStatus.ACTIVE);
            investor.setUserType(UserType.INVESTOR);
            investor.setRegistrationDate(LocalDateTime.now());

            repo.save(investor);

        } catch (DataIntegrityViolationException e) {
            throw new UserException("Los siguientes campos deben ser unicos: Correo electronico y número de identificación");
        } catch (UserException e) {
            throw new UserException(e.getMessage());
        }

        return true;
    }

    @Scheduled(fixedDelay = 60000)
    @Override
    public void verificarCuentasPendientes() {
        List<Investor> pendientes = repo.findByAlpacaStatus("SUBMITTED");

        for (Investor investor : pendientes) {
            try {
                AccountResponseDTO response = alpacaService.getAnAccountById(investor.getAlpacaId());
                if ("ACTIVE".equalsIgnoreCase(response.getStatus())) {
                    investor = InvestorMapper.fromAccountResponseDTO(response,investor, investor.getPasswordHash(), investor.getTaxId());
                    repo.save(investor);
                }
            } catch (Exception e) {
                System.err.println("Error al verificar cuenta de " + investor.getEmail() + ": " + e.getMessage());
            }
        }
    }

}
