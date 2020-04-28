package com.service.transaction.e2e;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        plugin = {
                "pretty", "html:build/reports/cucumber", "json:build/reports/cucumber/cucumber.json"
        })
public class CucumberTest {
}
