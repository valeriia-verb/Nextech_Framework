package com.nextech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScheduleDemoPage extends MainPage{

    @FindBy(name = "firstname")
    public WebElement fNameField;

    @FindBy(name = "lastname")
    public WebElement lNameField;

    @FindBy(name = "company")
    public WebElement practiceNameField;

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name = "phone")
    public WebElement phoneField;

    @FindBy(name = "specialty")
    public WebElement specialtyDropdown;

    @FindBy(name = "state")
    public WebElement locationDropdown;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement scheduleDemoButton;

    @FindBy(css = ".hs-input.invalid.error")
    public WebElement error;

}
