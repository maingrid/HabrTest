package com.example.habrtest.pages;

import com.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class MainPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/ru/flows/develop/']")
    private WebElement DevelopmentPage;
    @FindBy(xpath = "//div[@class='tm-block__body tm-block__body']/div[@class='tm-companies-rating']/a[@href='/ru/companies/ruvds/articles/']")
    private WebElement RUVDSPage;

    public void goToDevelopmentPage(){
        LOG.info("переход на страницу 'разработка'");
        DevelopmentPage.click();
    }
    public void goToRUVDSPage(){
        LOG.info("нажатие на ссылку для перехода на страницу ");
        RUVDSPage.click();
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
