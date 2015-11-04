package org.steven.features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"org.steven.features", "cucumber.api.spring"}, plugin = {"pretty", "html:build/reports/cucumber"}, strict = true)
public class RunCukesTest {
}
