package com.service.transaction.messagingevents;

class BalanceConnectorTest {

//    private RestTemplate mockRestTemplate;
//    private BalanceConnector balanceConnector;
//    private String GET_ACCOUNT_ENDPOINT = "http://localhost:8082/account/search/{accountNumber}";
//    private ResponseEntity mockResponseEntity;
//    private int accountNumber = 1111;
//
//    @BeforeEach
//    void setUp() {
//        mockRestTemplate = mock(RestTemplate.class);
//        mockResponseEntity = mock(ResponseEntity.class);
//        balanceConnector = new BalanceConnector(GET_ACCOUNT_ENDPOINT, mockRestTemplate);
//    }
//
//    @Test
//    void invokeAccountService_whenValidAccountNumberIsPassed_shouldCallRestTemplateGETWithSameCustomerId() {
//        when(mockRestTemplate.getForEntity(GET_ACCOUNT_ENDPOINT, Object.class, accountNumber))
//                .thenReturn(mockResponseEntity);
//
//        balanceConnector.invokeAccountService(accountNumber);
//
//        verify(mockRestTemplate, times(1))
//                .getForEntity(GET_ACCOUNT_ENDPOINT, Object.class, accountNumber);
//    }
}