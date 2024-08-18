package com.nextech.pages;

import com.nextech.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}