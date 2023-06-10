package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//a[@href='/ru/news/']/ancestor::div[@class='tm-tabs__scroll-area']")

    //веб элементы фильтра
    private WebElement buttonNews;
    @FindBy(xpath = "//button[@class]/parent::div[@class='tm-navigation-filters-spoiler__wrapper']")
    private WebElement buttonFilter;
    @FindBy(xpath = "//button[contains(text(), \'Лучшие\')]")
    private WebElement buttonBest;
    @FindBy(xpath = "//button[contains(text(),\"Сутки\")]")
    private WebElement buttonDay;
    @FindBy(xpath = "//button[contains(@class,' btn_solid btn_small') and contains(text(),'Применить')]")
    private WebElement buttonAccept ;
    //веб элементы фильтра

    // веб элементы списка компаний
    @FindBy(xpath = "//a[@href='/ru/companies/ruvds/articles/']")
    private WebElement companyRUVDS;
    //веб элементы списка компаний

    // методы элементов
    public void clickButtonNews(){
        buttonNews.click();
    }
    public void clickButtonFilter(){
        buttonFilter.click();
    }
    public void clickButtonBest(){
        buttonBest.click();
    }
    public void clickButtonDay(){
        buttonDay.click();
    }
    public void clickButtonAccept(){
        buttonAccept.click();
    }
    public void clickLinkCompanyRUVDS(){
        companyRUVDS.click();
    }
    // методы элементов


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
