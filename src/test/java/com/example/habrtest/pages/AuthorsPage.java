package com.example.habrtest.pages;

import com.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class AuthorsPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));
    WebDriver driver;

    @FindBy(xpath = "//div[@class='tm-users-list']/div[1]")
    private WebElement displayedAuthors;
    @FindBy(xpath = "//input[contains(@class,'tm-input-text')]")
    private WebElement searchField;

    //Authors elements
    @FindBy(xpath = "//div[@class='tm-users-list']/div[1]//div[@class='tm-user-snippet']/a")
    private WebElement logoAuthor;
    @FindBy(xpath = "//div[@class='tm-users-list']/div[1]//span[contains(@class,'tm-users-list__score-counter')]")
    private WebElement activityAuthor;
    //Authors elements

    public Boolean displayedAuthorsInList(){
        LOG.info("проверка отображения первого автора в списке");
        return displayedAuthors.isDisplayed();
    }
    public Boolean clickableSearchField(){
        LOG.info("Проверка кликабельности поля поиска");
        return searchField.isEnabled();
    }
    public void clickSearchField(){
        LOG.info("нажатие на поисковое поле");
        searchField.click();
    }
    public void inputTextInTheSearchFiled(String text){
        LOG.info("ввод текста в поисковое поле");
        searchField.sendKeys(text);
    }

    //Authors methods
    public Boolean displayedLogoAuthor(){
        LOG.info("проверка отображения аватарки пользователя");
        return logoAuthor.isDisplayed();
    }
    public Boolean clickableLogoAuthors(){
        LOG.info("проверка кликабельности автарки автора");
        return logoAuthor.isEnabled();
    }
    public Boolean displayedActivityAuthor(){
        LOG.info("проверка отображения активности автора");
        return activityAuthor.isDisplayed();
    }
    //Authors methods

    public AuthorsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
