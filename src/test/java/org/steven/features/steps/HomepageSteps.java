package org.steven.features.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import lombok.extern.slf4j.Slf4j;
import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Objects;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class HomepageSteps extends FluentTest implements En {

    private WebDriver driver;

    @Before
    public void before(Scenario scenario) {
        log.info("{}", scenario);
        setupFluentlenium(scenario);
    }

    @After
    public void after(Scenario scenario) {
        teardownFluentlenium(scenario);
    }

    @When("^I visit the homepage$")
    public void i_visit_the_homepage() {
        goTo("http://google.com");
    }

    @Then("^I should see the welcome page$")
    public void i_should_see_the_welcome_page() {
        assertThat(find("body").getText(), containsString("Google"));
    }

    @Override
    public WebDriver getDefaultDriver() {
        if (Objects.isNull(driver)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            driver = new PhantomJSDriver(capabilities);
            driver.manage().window().setSize(new Dimension(1280, 1920));
        }
        return driver;
    }

    protected void setupFluentlenium(Scenario scenario) {
        this.initFluent(getDefaultDriver());
        this.initTest();
    }

    protected void teardownFluentlenium(Scenario scenario) {
        this.quit();
    }
}
