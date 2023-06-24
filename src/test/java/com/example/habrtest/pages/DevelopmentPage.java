package com.example.habrtest.pages;

import com.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class DevelopmentPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));
    WebDriver driver;

    @FindBy(xpath = "//div[@class='tm-section-name']/h1[@class='tm-section-name__text']")
    private WebElement titleDevelopmentPage;

    //articles Elements
    @FindBy(xpath = "//div[@class='tm-articles-list']/article[1]")
    private WebElement articleDevelopmentPage;
    @FindBy(xpath = "//div[@class='tm-articles-list']/article[1]//span[contains(@class,\"author\")]")
    private WebElement authorArticleDevelopmentPage;
    @FindBy(xpath = "//div[@class='tm-articles-list']/article[1]//a[@class='tm-title__link']")
    private WebElement titleArticleDevelopmentPage;
    @FindBy(xpath = "//div[@class='tm-articles-list']//article[1]//span[@class='tm-article-complexity__label']")
    private WebElement levelComplexityArticle;
    @FindBy(xpath = "//div[@class='tm-articles-list']/article[1]//div[contains(@class, 'tm-votes-meter')]")
    private WebElement ratingArticle;
    //articles Elements

    //filter Elements
    @FindBy(xpath = "//div[@class='tm-navigation-filters-spoiler__wrapper']/button[contains(@class,'tm-navigation-filters')]")
    private WebElement buttonFiltersDevelopmentPage;
    @FindBy(xpath = "//div[@class='tm-navigation-filters__options']/button[contains(@class,'filters__apply')]")
    private WebElement buttonApply;
    @FindBy(xpath = "//div[@class='tm-navigation-filters__options']//button[contains(text(),'Простой')]")
    private WebElement buttonEasy;
    @FindBy(xpath = "//div[contains(@class,'tm-navigation-filters-spoiler__content')]//ul[2]/li[3]")
    private WebElement buttonRating10;
    //filter Elements


    public Boolean displayedTitleDevelopmentPage(){
        LOG.info("проверка отображения заголовка на странице 'Разработка'");
        return titleDevelopmentPage.isDisplayed();
    }

    //articles methods
    public Boolean displayedarticleDevelopmentPage(){
        LOG.info("проверка отображения статьи на странице 'Разработка'");
        return articleDevelopmentPage.isDisplayed();
    }
    public Boolean displayedAuthorArticleDevelopmentPage(){
        LOG.info("проверка отображения автора у статьи на странице 'Разработка'");
        return authorArticleDevelopmentPage.isDisplayed();
    }
    public Boolean displayedTitleArticleDevelopmentPage(){
        LOG.info("проверка отображения заголовка у статьи на странице 'Разработка'");
        return titleArticleDevelopmentPage.isDisplayed();
    }
    public Boolean displayedLevelComplexityArticle(){
        LOG.info("проверка отображения уровня сложности статьи");
        return levelComplexityArticle.isDisplayed();
    }
    public Boolean displayedRatingArticle(){
        LOG.info("проверка отображения рейтинга статьи");
        return ratingArticle.isDisplayed();
    }
    //articles methods

    //filter methods
    public void clickButtonFiltersDevelopmentPage(){
        LOG.info("нажатие кнопки фильтра");
        buttonFiltersDevelopmentPage.click();
    }
    public Boolean displayedButtonApply(){
        LOG.info("проверка отображения кнопки 'Применить'");
        return buttonApply.isDisplayed();
    }
    public void clickButtonApply(){
        LOG.info("нажатие кнопки 'Применить'");
        buttonApply.click();
    }
    public void clickButtonEasy(){
        LOG.info("нажатие кнопки 'Простой'");
        buttonEasy.click();
    }
    public void clickButtonRating10(){
        LOG.info("нажатие кнопки рейтинга со значением 10");
        buttonRating10.click();
    }
    //filter methods


    public DevelopmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
