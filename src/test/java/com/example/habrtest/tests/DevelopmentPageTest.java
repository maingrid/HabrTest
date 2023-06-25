package com.example.habrtest.tests;

import com.example.habrtest.AllureAttachmentsManager;
import com.example.habrtest.pages.DevelopmentPage;
import com.example.habrtest.pages.MainPage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DevelopmentPageTest extends BaseTest{
    private MainPage MP;
    private DevelopmentPage DP;
    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.habr.com/");
        MP = new MainPage(getDriver());
        DP  = new DevelopmentPage(getDriver());
    }

    @Test
    @DisplayName("проверка того, что заголовок 'Разработка' отображается на странице 'Разработка'")
    public void TC2_displayedTitleDevelopmentPageCheck(){
        MP.goToDevelopmentPage();
        AllureAttachmentsManager.screenshot();
        assertTrue(DP.displayedTitleDevelopmentPage(), "заголовок не отображается");
    }
    @Test
    @DisplayName("проверка того, что статья отображается  на странице 'Разработка'")
    public void TC3_displayedArticleDevelopmentPage(){
        MP.goToDevelopmentPage();
        AllureAttachmentsManager.screenshot();
        assertTrue(DP.displayedarticleDevelopmentPage(), "нет статьи на странице");
    }
    @Test
    @DisplayName("проверка отображения автора у статьи на странице 'Разарботка'")
    public void TC4_displayedAuthorArticleDevelopmentPageCheck(){
        MP.goToDevelopmentPage();
        ExplicitWaitUrlToBe(5, "https://habr.com/ru/flows/develop/");
        AllureAttachmentsManager.screenshot();
        assertTrue(DP.displayedAuthorArticleDevelopmentPage(), "у статьи нет автора");
    }
    @Test
    @DisplayName("проверка того, что отображается заголовок у статьи")
    public void TC5_displayedTitleArticleDevelopmentPageCheck(){
        MP.goToDevelopmentPage();
        ExplicitWaitUrlToBe(5, "https://habr.com/ru/flows/develop/");
        AllureAttachmentsManager.screenshot();
        assertTrue(DP.displayedTitleArticleDevelopmentPage(), "заголовок не отображается");
    }
    @Test
    @DisplayName("проверка того, что фильтр открылся и отображается кнопка 'Применить'")
    public void TC6_displayedButtonApplyCheck(){
        MP.goToDevelopmentPage();
        ExplicitWaitUrlToBe(3, "https://habr.com/ru/flows/develop/");
        DP.clickButtonFiltersDevelopmentPage();
        AllureAttachmentsManager.screenshot();
        assertTrue(DP.displayedButtonApply(), "кнопка не отображается");
    }
    @Test
    @DisplayName("проверка того, что отобразились статьи по заданному параметру 'Простой' на странице")
    public void TC7_displayedLevelComplexityArticle(){
        MP.goToDevelopmentPage();
        ExplicitWaitUrlToBe(3, "https://habr.com/ru/flows/develop/");
        DP.clickButtonFiltersDevelopmentPage();
        DP.clickButtonEasy();
        AllureAttachmentsManager.screenshot();
        DP.clickButtonApply();
        assertTrue(DP.displayedLevelComplexityArticle(), "уровень сложности статьи не отображается");
    }
    @Test
    @DisplayName("проверка того, что отобразились статьи по заданному параметру 'рейтинг равен 10 или более' на странице")
    public void TC8_displayedArticlesWithRating10Check(){
        MP.goToDevelopmentPage();
        ExplicitWaitUrlToBe(3, "https://habr.com/ru/flows/develop/");
        DP.clickButtonFiltersDevelopmentPage();
        DP.clickButtonRating10();
        DP.clickButtonApply();
        AllureAttachmentsManager.screenshot();
        assertTrue(DP.displayedRatingArticle(), "статьи не отобразились");
    }
    @Test
    @DisplayName("проверка того, что выполняется переход на страницу с авторами")
    public void TC9_GoToThePageAuthorsCheck(){
        MP.goToDevelopmentPage();
        ExplicitWaitUrlToBe(3, "https://habr.com/ru/flows/develop/");
        DP.clickLinkAuthors();
        assertEquals("https://habr.com/ru/flows/develop/authors/", getDriver().getCurrentUrl());
    }

}
