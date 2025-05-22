package co.edu.unbosque.LaForestaTrading.service.internal.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.*;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountResponseDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountTradingDetailDTO;
import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.entity.Order;
import co.edu.unbosque.LaForestaTrading.exception.OrderException;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import co.edu.unbosque.LaForestaTrading.repository.IOrderRepository;
import co.edu.unbosque.LaForestaTrading.repository.IUserRepository;
import co.edu.unbosque.LaForestaTrading.service.external.interfaces.IAlpacaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TradingServiceImplTest {

    private IUserRepository userRepo;
    private IOrderRepository orderRepo;
    private IAlpacaService alpacaService;
    private PasswordEncoder passwordEncoder;
    private TradingServiceImpl service;
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        userRepo = mock(IUserRepository.class);
        orderRepo = mock(IOrderRepository.class);
        alpacaService = mock(IAlpacaService.class);
        passwordEncoder = mock(PasswordEncoder.class);
        modelMapper = new ModelMapper();
        service = new TradingServiceImpl(userRepo, orderRepo, modelMapper, alpacaService, passwordEncoder);
    }

    @Test
    public void testRegisterSuccess() {
        AccountDTO dto = buildDummyAccountDTO();
        when(userRepo.findByTaxId(anyString())).thenReturn(null);
        when(alpacaService.createAccount(any(AccountDTO.class)))
                .thenReturn(buildDummyAccountResponseDTO());
        when(userRepo.save(any(Investor.class))).thenReturn(new Investor());
        when(passwordEncoder.encode(anyString())).thenReturn("hashed");

        boolean result = service.register(dto, "password123");

        assertTrue(result);
        verify(userRepo).save(any(Investor.class));
    }

    @Test
    public void testRegisterThrowsWhenTaxIdExists() {
        when(userRepo.findByTaxId(anyString())).thenReturn(new Investor());

        UserException ex = assertThrows(UserException.class, () ->
                service.register(buildDummyAccountDTO(), "pwd"));
        assertEquals("Número de identificación duplicado", ex.getMessage());
    }

    @Test
    public void testRegisterThrowsWhenDuplicateEmailOrTax() {
        when(userRepo.findByTaxId(anyString())).thenReturn(null);
        when(alpacaService.createAccount(any())).thenReturn(buildDummyAccountResponseDTO());
        when(passwordEncoder.encode(anyString())).thenReturn("hash");

        doThrow(DataIntegrityViolationException.class).when(userRepo).save(any());

        assertThrows(UserException.class, () ->
                service.register(buildDummyAccountDTO(), "pwd"));
    }

    @Test
    public void testVerificarCuentasPendientesUpdatesAccount() {
        Investor investor = new Investor();
        investor.setAlpacaId("acc123");
        investor.setPasswordHash("hash");
        investor.setTaxId("123");
        investor.setEmail("test@mail.com");

        AccountResponseDTO active = buildDummyAccountResponseDTO();
        active.setStatus("ACTIVE");

        when(userRepo.findByAlpacaStatus("SUBMITTED")).thenReturn(List.of(investor));
        when(alpacaService.getAnAccountById("acc123")).thenReturn(active);

        service.verificarCuentasPendientes();

        verify(userRepo).save(any(Investor.class));
    }

    @Test
    public void testVerificarCuentasPendientesSkipsIfNotActive() {
        Investor investor = new Investor();
        investor.setAlpacaId("acc123");
        investor.setPasswordHash("hash");
        investor.setTaxId("123");

        AccountResponseDTO response = buildDummyAccountResponseDTO();
        response.setStatus("SUBMITTED");

        when(userRepo.findByAlpacaStatus("SUBMITTED")).thenReturn(List.of(investor));
        when(alpacaService.getAnAccountById("acc123")).thenReturn(response);

        service.verificarCuentasPendientes();

        verify(userRepo, never()).save(any());
    }

    @Test
    public void testExecuteOrderSuccess() {
        Long investorId = 1L;
        Investor investor = new Investor();
        investor.setAlpacaId("acc-001");
        OrderDTO dto = new OrderDTO();
        dto.setSymbol("AAPL");

        Order savedOrder = new Order();
        savedOrder.setAlpacaOrderId("1");
        savedOrder.setSymbol("AAPL");
        savedOrder.setQty("1");

        when(userRepo.findById(investorId)).thenReturn(Optional.of(investor));
        when(alpacaService.createAnOrderForAnAccount(any(OrderDTO.class), anyString())).thenReturn(dto);
        when(orderRepo.save(any(Order.class))).thenReturn(savedOrder);

        OrderDTO result = service.executeOrder(dto, investorId);

        assertNotNull(result);
        assertEquals("AAPL", result.getSymbol());
    }

    @Test
    public void testExecuteOrderThrowsWhenInvestorNotFound() {
        when(userRepo.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(OrderException.class, () ->
                service.executeOrder(new OrderDTO(), 999L));
    }

    @Test
    public void testListOrdersByInvestorIdReturnsMappedDTOs() {
        Long investorId = 1L;

        Order order = new Order();
        order.setSymbol("AAPL");
        order.setQty("10");
        order.setType("market");

        when(orderRepo.findByInvestorId(investorId)).thenReturn(List.of(order));

        List<OrderDTO> result = service.listOrderdByInvestorId(investorId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("AAPL", result.get(0).getSymbol());
        assertEquals("10", result.get(0).getQty());
    }

    @Test
    public void testListOrdersByInvestorIdReturnsEmptyListWhenNoneFound() {
        Long investorId = 2L;

        when(orderRepo.findByInvestorId(investorId)).thenReturn(Collections.emptyList());

        List<OrderDTO> result = service.listOrderdByInvestorId(investorId);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testVerificarOrdenesPendientes_UpdatesFilledOrders() {
        // Arrange
        Investor investor = new Investor();
        investor.setAlpacaId("acc123");
        investor.setBuyingPower(new BigDecimal("0")); // inicial

        Order order = new Order();
        order.setAlpacaOrderId("ord001");
        order.setStatus("pending");
        order.setInvestor(investor);

        OrderDTO updated = new OrderDTO();
        updated.setStatus("filled");
        updated.setFilledAt("2025-05-22T08:00:00Z");
        updated.setFilledQty("1");
        updated.setFilledAvgPrice("189.25");

        AccountTradingDetailDTO detailDTO = new AccountTradingDetailDTO();
        detailDTO.setBuyingPower("13419.14");

        when(orderRepo.findByStatusNotIgnoreCase("filled")).thenReturn(List.of(order));
        when(alpacaService.retrieveAnOrderByItsId("acc123", "ord001")).thenReturn(updated);
        when(alpacaService.retriieveTradingDetailsForAnAccount("acc123")).thenReturn(detailDTO);

        // Act
        service.verificarOrdenesPendientes();

        // Assert
        assertEquals("filled", order.getStatus());
        assertEquals("1", order.getFilledQty());
        assertEquals("189.25", order.getFilledAvgPrice());
        assertEquals("2025-05-22T08:00:00Z", order.getFilledAt());
        assertEquals(new BigDecimal("13419.14"), investor.getBuyingPower());

        verify(orderRepo).save(order);
        verify(userRepo).save(investor);
    }


    @Test
    public void testGetInvestorBuyingPowerReturnsCorrectValue() {
        Long userId = 123L;
        Investor investor = new Investor();
        BigDecimal expectedBuyingPower = new BigDecimal("9876.54");
        investor.setBuyingPower(expectedBuyingPower);

        when(userRepo.findById(userId)).thenReturn(Optional.of(investor));

        BigDecimal result = service.getInvestorBuyingPower(userId);

        assertEquals(expectedBuyingPower, result);
        verify(userRepo).findById(userId);
    }

    @Test
    public void testGetInvestorBuyingPowerThrowsExceptionIfInvestorNotFound() {
        Long userId = 999L;

        when(userRepo.findById(userId)).thenReturn(Optional.empty());

        UserException ex = assertThrows(UserException.class, () -> {
            service.getInvestorBuyingPower(userId);
        });

        assertEquals("No hay plata!", ex.getMessage());
        verify(userRepo).findById(userId);
    }


    // Utils
    private AccountDTO buildDummyAccountDTO() {
        ContactDTO contact = new ContactDTO("mail@test.com", "123", List.of("Street"), "City", "State", "12345");
        IdentityDTO identity = new IdentityDTO("John", "Doe", "1990-01-01", "CO", "CO", "person", "123", "id", "CO", List.of("saving"));
        DisclosureDTO disc = new DisclosureDTO(false, false, false, false, false, false);
        AgreementDTO agree = new AgreementDTO("agreement", "2024-01-01T00:00:00Z", "127.0.0.1");
        return new AccountDTO(contact, identity, disc, List.of(agree));
    }

    private AccountResponseDTO buildDummyAccountResponseDTO() {
        ContactDTO contact = new ContactDTO("mail@test.com", "123", List.of("Street"), "City", "State", "12345");
        IdentityDTO identity = new IdentityDTO("John", "Doe", "1990-01-01", "CO", "CO", "person", "123", "id", "CO", List.of("saving"));
        DisclosureDTO disc = new DisclosureDTO(false, false, false, false, false, false);
        return new AccountResponseDTO("alp-id", "acc-num", "ACTIVE", "status", "USD", "1000", "2024-01-01T00:00:00Z",
                contact, identity, disc, List.of(), "trading", "margin", null, List.of("equity"));
    }
}
