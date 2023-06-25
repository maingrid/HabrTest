package com.example.habrtest.tests;

import com.example.habrtest.pages.AuthorsPage;
import com.example.habrtest.pages.DevelopmentPage;
import com.example.habrtest.pages.MainPage;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorsPageTest extends BaseTest{

    private MainPage MP;
    private DevelopmentPage DP;
    private AuthorsPage AP;
    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.habr.com/");
        MP = new MainPage(getDriver());
        DP  = new DevelopmentPage(getDriver());
        AP = new AuthorsPage(getDriver());
    }

    @Test
    @DisplayName("проверка того, что в списке авторов есть элементы")
    public void TC10_displayedAuthorsInListCheck(){
        MP.goToDevelopmentPage();
        DP.clickLinkAuthors();
        assertTrue(AP.displayedAuthorsInList(), "в списке не отображаются авторы");
    }
    @Test
    @DisplayName("проверка того, что у автора отображается аватарка")
    public void TC11_displayedLogoAuthorCheck(){
        MP.goToDevelopmentPage();
        DP.clickLinkAuthors();
        assertTrue(AP.displayedLogoAuthor(), "аватарка у автора не отображается");
    }
    @Test
    @DisplayName("проверка того, что аватарка автора кликабельна")
    public void TC12_clickableLogoAuthorsCheck(){
        MP.goToDevelopmentPage();
        DP.clickLinkAuthors();
        assertTrue(AP.clickableLogoAuthors(),"аватарка не кликабельна");
    }
    @Test
    @DisplayName("проверка того, что у автора отображается активность в виде количества написанных им стаей")
    public void TC13_displayedActivityAuthorCheck(){
        MP.goToDevelopmentPage();
        DP.clickLinkAuthors();
        assertTrue(AP.displayedActivityAuthor(), "активность автора не отображается");
    }
    @Test
    @DisplayName("проверка того, что поле поиска кликабельно")
    public void TC14_clickableSearchFieldCheck(){
        MP.goToDevelopmentPage();
        DP.clickLinkAuthors();
        assertTrue(AP.clickableSearchField(), "поле не кликабельно");
    }
    @Test
    @DisplayName("проверка того, что поисковое поле работает")
    public void TC15_searchFieldCheck(){
        MP.goToDevelopmentPage();
        DP.clickLinkAuthors();
        AP.clickSearchField();
        AP.inputTextInTheSearchFiled("Лука Сафонов");
        assertTrue(AP.displayedAuthorsInList(),"поиск не нашел авторов по заданному параметру");
    }

}
