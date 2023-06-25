package com.example.habrtest.tests;

import com.example.habrtest.MyExtansion;
import com.example.habrtest.pages.DevelopmentPage;
import com.example.habrtest.pages.MainPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

@ExtendWith(MyExtansion.class)
public class MainPageTest extends BaseTest{
    private MainPage mainPage;
    private DevelopmentPage DP;

    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.habr.com/");
        mainPage = new MainPage(getDriver());
        DP  = new DevelopmentPage(getDriver());
    }

    @Test
    @DisplayName("проверка перехода на страницу 'разработка'")
    public void TC1_goToDevelopmentPageCheck() {
        mainPage.goToDevelopmentPage();
        ExplicitWaitUrlToBe(5, "https://habr.com/ru/flows/develop/");
        assertEquals("https://habr.com/ru/flows/develop/", getDriver().getCurrentUrl(), "страница не открылась");
    }
    @Test
    @DisplayName("проверка перехода на страницу компании RUVDS, через боковое правое меню")
    public void TC16_goToRUVDSPage(){
        mainPage.goToRUVDSPage();
        ExplicitWaitUrlToBe(5,"https://habr.com/ru/companies/ruvds/articles/");
        assertEquals("https://habr.com/ru/companies/ruvds/articles/", getDriver().getCurrentUrl(), "страница не открылась");
    }

}
