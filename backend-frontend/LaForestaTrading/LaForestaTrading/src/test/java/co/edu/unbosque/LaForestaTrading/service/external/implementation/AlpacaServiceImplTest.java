package co.edu.unbosque.LaForestaTrading.service.external.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.AccountDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.OrderDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountResponseDTO;
import co.edu.unbosque.LaForestaTrading.exception.OrderException;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AlpacaServiceImplTest {

    @InjectMocks
    private AlpacaServiceImpl alpacaService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        alpacaService = new AlpacaServiceImpl(restTemplate);
        setPrivateField(alpacaService, "apiKey", "test-key");
        setPrivateField(alpacaService, "apiSecret", "test-secret");
    }

    private void setPrivateField(Object target, String name, String value) {
        try {
            var field = target.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCreateAccountSuccess() {
        AccountDTO accountDTO = mock(AccountDTO.class);
        AccountResponseDTO responseDTO = new AccountResponseDTO();
        ResponseEntity<AccountResponseDTO> responseEntity = new ResponseEntity<>(responseDTO, HttpStatus.OK);

        when(restTemplate.exchange(
                eq("https://broker-api.sandbox.alpaca.markets/v1/accounts"),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(AccountResponseDTO.class)
        )).thenReturn(responseEntity);

        AccountResponseDTO result = alpacaService.createAccount(accountDTO);

        assertNotNull(result);
        assertEquals(responseDTO, result);
    }

    @Test
    public void testCreateAccountFailureThrowsUserException() {
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(AccountResponseDTO.class)
        )).thenThrow(new RestClientException("Conflict"));

        assertThrows(UserException.class, () -> alpacaService.createAccount(new AccountDTO()));
    }

    @Test
    public void testGetAnAccountByIdSuccess() {
        String accountId = "abc123";
        AccountResponseDTO mockResponse = new AccountResponseDTO();
        ResponseEntity<AccountResponseDTO> responseEntity = new ResponseEntity<>(mockResponse, HttpStatus.OK);

        when(restTemplate.exchange(
                eq("https://broker-api.sandbox.alpaca.markets/v1/accounts/" + accountId),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(AccountResponseDTO.class)
        )).thenReturn(responseEntity);

        AccountResponseDTO result = alpacaService.getAnAccountById(accountId);

        assertNotNull(result);
        assertEquals(mockResponse, result);
    }

    @Test
    public void testCreateAnOrderForAnAccountSuccess() {
        String accountId = "account123";
        OrderDTO orderDTO = new OrderDTO();
        OrderDTO responseDTO = new OrderDTO();
        ResponseEntity<OrderDTO> responseEntity = new ResponseEntity<>(responseDTO, HttpStatus.OK);

        when(restTemplate.exchange(
                eq("https://broker-api.sandbox.alpaca.markets/v1/trading/accounts/" + accountId + "/orders"),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(OrderDTO.class)
        )).thenReturn(responseEntity);

        OrderDTO result = alpacaService.createAnOrderForAnAccount(orderDTO, accountId);

        assertNotNull(result);
        assertEquals(responseDTO, result);
    }

    @Test
    public void testCreateAnOrderForAnAccountThrowsOrderException() {
        String accountId = "account123";
        OrderDTO orderDTO = new OrderDTO();

        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(OrderDTO.class)
        )).thenThrow(new RestClientException("Bad Request"));

        assertThrows(OrderException.class, () -> alpacaService.createAnOrderForAnAccount(orderDTO, accountId));
    }

    @Test
    public void testRetrieveAnOrderByItsIdSuccess() {
        String accountId = "acc123";
        String orderId = "order456";
        OrderDTO mockOrder = new OrderDTO();
        mockOrder.setSymbol("AAPL");
        mockOrder.setStatus("filled");

        ResponseEntity<OrderDTO> responseEntity = new ResponseEntity<>(mockOrder, HttpStatus.OK);

        when(restTemplate.exchange(
                eq("https://broker-api.sandbox.alpaca.markets/v1/trading/accounts/" + accountId + "/orders/" + orderId),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(OrderDTO.class)
        )).thenReturn(responseEntity);

        OrderDTO result = alpacaService.retrieveAnOrderByItsId(accountId, orderId);

        assertNotNull(result);
        assertEquals("AAPL", result.getSymbol());
        assertEquals("filled", result.getStatus());
    }

}
