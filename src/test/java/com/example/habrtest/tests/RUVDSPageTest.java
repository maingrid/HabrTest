package com.example.habrtest.tests;


import com.example.habrtest.pages.MainPage;
import com.example.habrtest.pages.RUVDSPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RUVDSPageTest extends BaseTest{

    private MainPage MP;
    private RUVDSPage RP;

    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.habr.com/");
        MP = new MainPage(getDriver());
        RP = new RUVDSPage(getDriver());
    }

    @Test
    @DisplayName("проверка того, что заголовок отображается на странице")
    public void TC17_displayedTitleCompanyCheck(){
        MP.goToRUVDSPage();
        assertTrue(RP.displayedTitleCompany(), "заголовок страницы не отображается");
    }
    @Test
    @DisplayName("проверка того, что статьи отображаются на странице ")
    public void TC18_displayedArticlesCompanyRUVDSCheck(){
        MP.goToRUVDSPage();
        assertTrue(RP.displayedArticlesCompanyRUVDS(),"статьи не отображаются");
    }
    @Test
    @DisplayName("проверка перехода на профиль с описанием компании")
    public void TC19_goToTheProfileCompanyRUVDSCheck(){
        MP.goToRUVDSPage();
        RP.goToTheProfileCompanyRUVDS();
        assertEquals("https://habr.com/ru/companies/ruvds/profile/", getDriver().getCurrentUrl(), "страница не открылась");
    }
    @Test
    @DisplayName("проверка перехода на страницу с сострудниками компании")
    public void TC20_goToTheStaffsCompanyRUVDS(){
        MP.goToRUVDSPage();
        RP.goToTheStaffsCompanyRUVDS();
        assertEquals("https://habr.com/ru/companies/ruvds/workers/all/rating/", getDriver().getCurrentUrl(),"страница не открылась");
    }
    @Test
    @DisplayName("проверка перехода на страницу с новостями компании")
    public void TC21_goToTheNewsCompanyRUVDSCheck(){
        MP.goToRUVDSPage();
        RP.goToTheNewsCompanyRUVDS();
        assertEquals("https://habr.com/ru/companies/ruvds/news/", getDriver().getCurrentUrl());
    }

}
