package co.edu.unbosque.LaForestaTrading.service.internal.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.AccountDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.ContactDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.DisclosureDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.IdentityDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountResponseDTO;
import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.entity.enums.UserStatus;
import co.edu.unbosque.LaForestaTrading.entity.enums.UserType;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import co.edu.unbosque.LaForestaTrading.mapper.InvestorMapper;
import co.edu.unbosque.LaForestaTrading.repository.IUserRepository;
import co.edu.unbosque.LaForestaTrading.service.internal.interfaces.ITradingService;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TradingServiceImpl implements ITradingService {

    private final IUserRepository repo;
    private final ModelMapper modelMapper;


    public TradingServiceImpl(IUserRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(AccountDTO dto, String password) {

        try{
            AccountResponseDTO accountResponseDTO = new AccountResponseDTO(
                    "xxxxxxxxxxxxyyyyyyyy",
                    "xxxxxxyyyyyy",
                    "SUBMITTED",
                    "INACTIVE",
                    "USD",
                    "0.00",
                    "2025-05-19T00:01:14.14068Z",

                    new ContactDTO(
                            dto.getContactDTO().getEmailAddress(),
                            dto.getContactDTO().getPhoneNumber(),
                            dto.getContactDTO().getStreetAddress(),
                            dto.getContactDTO().getCity(),
                            dto.getContactDTO().getState(),
                            dto.getContactDTO().getPostalCode()
                    ),

                    new IdentityDTO(
                            dto.getIdentityDTO().getGivenName(),
                            dto.getIdentityDTO().getFamilyName(),
                            dto.getIdentityDTO().getDateOfBirth(),
                            dto.getIdentityDTO().getCountryOfCitizenship(),
                            dto.getIdentityDTO().getCountryOfBirth(),
                            dto.getIdentityDTO().getPartyType(),
                            dto.getIdentityDTO().getTaxId(),
                            dto.getIdentityDTO().getTaxIdType(),
                            dto.getIdentityDTO().getCountryOfTaxResidence(),
                            dto.getIdentityDTO().getFundingSource()
                    ),

                    new DisclosureDTO(
                            dto.getDisclosureDTO().isControlPerson(),
                            dto.getDisclosureDTO().isAffiliatedExchangeOrFinra(),
                            dto.getDisclosureDTO().isAffiliatedExchangeOrIiroc(),
                            dto.getDisclosureDTO().isPoliticallyExposed(),
                            dto.getDisclosureDTO().isImmediateFamilyExposed(),
                            dto.getDisclosureDTO().isDiscretionary()
                    ),

                    dto.getAgreementsDTO(),

                    "trading",
                    "margin",
                    null,
                    List.of("us_equity")
            );

            Investor investor = new Investor();


            investor = InvestorMapper.fromAccountResponseDTO(accountResponseDTO, investor, password);


            investor.setFirstName(accountResponseDTO.getIdentityDTO().getGivenName());
            investor.setLastName(accountResponseDTO.getIdentityDTO().getFamilyName());
            investor.setEmail(accountResponseDTO.getContactDTO().getEmailAddress());
            investor.setPasswordHash(password);
            investor.setStatus(UserStatus.ACTIVE);
            investor.setUserType(UserType.INVESTOR);
            investor.setRegistrationDate(LocalDateTime.now());

            repo.save(investor);
        }
        catch(DataIntegrityViolationException e){
            throw new UserException("Los siguientes campos deben ser unicos: Correo electronico y número de identificación");
        }
        catch(UserException e){
            throw new UserException(e.getMessage());
        }

        return true;
    }

}
