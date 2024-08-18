package com.nextech.step_definitions;

import com.github.javafaker.Faker;
import com.nextech.pages.ScheduleDemoPage;
import com.nextech.utilities.ConfigurationReader;
import com.nextech.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScheduleDemo_StepDefs {

    ScheduleDemoPage scheduleDemoPage;
    Faker faker;
    Select selectSpecialty;
    Select selectState;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));

    @Given("the user is on the Schedule a Demo page")
    public void the_user_is_on_the_schedule_a_demo_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        //Assert.assertEquals(Driver.getDriver().getTitle(), ("EMR Software Demo | Practice Management Software Demo | Nextech"));
    }
    @When("the user enters random test data for the form missing a field")
    public void the_user_enters_random_test_data_for_the_form_missing_a_field() {

        scheduleDemoPage = new ScheduleDemoPage();
        selectSpecialty = new Select(scheduleDemoPage.specialtyDropdown);
        selectState = new Select(scheduleDemoPage.locationDropdown);

        faker = new Faker();

        wait.until(ExpectedConditions.elementToBeClickable(scheduleDemoPage.fNameField));
        scheduleDemoPage.fNameField.sendKeys(faker.name().firstName());

        wait.until(ExpectedConditions.elementToBeClickable(scheduleDemoPage.lNameField));
        scheduleDemoPage.lNameField.sendKeys(faker.name().lastName());

//        wait.until(ExpectedConditions.elementToBeClickable(scheduleDemoPage.practiceNameField));
//        scheduleDemoPage.practiceNameField.sendKeys(faker.company().name());

        wait.until(ExpectedConditions.elementToBeClickable(scheduleDemoPage.emailField));
        scheduleDemoPage.emailField.sendKeys(faker.internet().emailAddress());

        wait.until(ExpectedConditions.elementToBeClickable(scheduleDemoPage.phoneField));
        scheduleDemoPage.phoneField.sendKeys(faker.phoneNumber().cellPhone());

        wait.until(ExpectedConditions.elementToBeClickable(scheduleDemoPage.specialtyDropdown));
        selectSpecialty.selectByValue("Dermatology");

        wait.until(ExpectedConditions.elementToBeClickable(scheduleDemoPage.locationDropdown));
        selectState.selectByValue("Illinois");

    }
    @When("the user presses the {string} button")
    public void the_user_presses_the_button(String string) {
        wait.until(ExpectedConditions.elementToBeClickable(scheduleDemoPage.scheduleDemoButton));
        //request.requestDemoButton.click();
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", scheduleDemoPage.scheduleDemoButton);
    }
    @Then("the user should see missing field highlighted")
    public void the_user_should_see_missing_field_highlighted() {
        Assert.assertTrue(scheduleDemoPage.error.isDisplayed());
        Driver.closeDriver();
    }
}
