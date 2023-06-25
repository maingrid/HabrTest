package com.example.habrtest.pages;

import com.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class RUVDSPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));
    WebDriver driver;

    @FindBy(xpath = "//div[@class='tm-company-profile-card']//div[@class='tm-company-card__info']/a")
    private WebElement titleCompanyRUVDS;
    @FindBy(xpath = "//div[@class='tm-articles-list']/article[1]")
    private WebElement articleCompanyRUVDS;
    @FindBy(xpath = "//div[contains(@class,'tm-tabs_page-header')]//a[@href='/ru/companies/ruvds/profile/']")
    private WebElement ProfileCompanyRUVDS;
    @FindBy(xpath = "//div[contains(@class,'tm-tabs_page-header')]//a[@href='/ru/companies/ruvds/workers/all/rating/']")
    private WebElement staffsCompanyRUVDS;
    @FindBy(xpath = "//div[contains(@class,'tm-tabs_page-header')]//a[@href='/ru/companies/ruvds/news/']")
    private WebElement NewsCompanyRUVDS;

    public Boolean displayedTitleCompany(){
        LOG.info("проверка отображения заголовка компании");
        return titleCompanyRUVDS.isDisplayed();
    }
    public Boolean displayedArticlesCompanyRUVDS(){
        LOG.info("проверка отображения статьи на странице компании");
        return articleCompanyRUVDS.isDisplayed();
    }
    public void goToTheProfileCompanyRUVDS(){
        LOG.info("переход в профиль компании");
        ProfileCompanyRUVDS.click();
    }
    public void goToTheStaffsCompanyRUVDS(){
        LOG.info("переход на страницу с сотрудниками");
        staffsCompanyRUVDS.click();
    }
    public void goToTheNewsCompanyRUVDS(){
        LOG.info("переход на страницу с новостями компании");
        NewsCompanyRUVDS.click();
    }




    public RUVDSPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
