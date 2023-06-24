package com.example.habrtest.pages;

import com.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class MainPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/ru/flows/develop/']")
    private WebElement DevelopmentPage;

    public void goToDevelopmentPage(){
        LOG.info("переход на страницу 'разработка'");
        DevelopmentPage.click();
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
