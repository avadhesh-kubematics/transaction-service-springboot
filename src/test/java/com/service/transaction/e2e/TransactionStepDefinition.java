package com.service.transaction.e2e;

import com.service.transaction.helper.SpringIntegration;
import com.service.transaction.helper.TestContextInterface;
import com.service.transaction.model.TransactionVO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.nl.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.lang.annotation.Annotation;

import static com.service.transaction.helper.TestData.getCreditTransaction;

public class TransactionStepDefinition extends SpringIntegration implements En, TestContextInterface {

    @Autowired
    KafkaTemplate testKafkaTemplate;

    @Given("Cashier produces an Credit Transaction event")
    public void cashier_produces_an_Credit_Transaction_event() {
        TransactionVO creditTransaction = getCreditTransaction();
        startService();
//        stubBalanceService();
        testContext().setPayload(getCreditTransaction());
    }

    @When("Transaction service consumes the Credit Transaction event")
    public void transaction_service_consumes_the_Credit_Transaction_event() throws InterruptedException {
        testKafkaTemplate.send("transaction", testContext().getPayload(TransactionVO.class));
        Thread.sleep(1000);
    }

    @Then("The API should return status {int}")
    public void the_API_should_return_status(Integer statusCode) {
        stopService();
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
