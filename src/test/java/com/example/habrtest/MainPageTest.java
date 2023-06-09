package com.example.habrtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkFilterNewsPerDay() {
        driver.get("https://www.habr.com/");
        WebElement news = driver.findElement(By.xpath("//a[@href='/ru/news/']/ancestor::div[@class='tm-tabs__scroll-area']"));
        news.click();
        WebElement filter = driver.findElement(By.xpath("//button[@class]/parent::div[@class='tm-navigation-filters-spoiler__wrapper']"));
        filter.click();
        WebElement bestFilter = driver.findElement(By.xpath("//button[contains(text(), 'Лучшие')]"));
        bestFilter.click();
        WebElement ratingFilter = driver.findElement(By.xpath("//button[contains(text(),\"Сутки\")]"));
        ratingFilter.click();
        WebElement acceptButton = driver.findElement(By.xpath("//button[contains(@class,' btn_solid btn_small') and contains(text(),'Применить')]"));
        acceptButton.click();
        assertTrue(driver.findElement(By.xpath("//article[@class='tm-articles-list__item'][1]")).isDisplayed(), "нет такой даты");

    }

    @Test
    public void checkBlogRUVDS() {
        driver.get("https://www.habr.com/");
        WebElement companyRUVDS = driver.findElement(By.xpath("//a[@href='/ru/companies/ruvds/articles/']"));
        companyRUVDS.click();
        System.out.println();
        assertTrue(driver.findElement(By.xpath("//a[@href='/ru/companies/ruvds/profile/']/parent::div[@class='tm-company-card__info']")).isDisplayed());
    }
}
