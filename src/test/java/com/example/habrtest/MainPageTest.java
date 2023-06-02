package com.example.habrtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        driver.get("https://www.habr.com/");


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkFilterNewsPerDay() {
        WebElement news = driver.findElement(By.xpath("//a[@aria-current='page' and @data-test-id='tab-link-active']"));
        news.click();

        WebElement filter = driver.findElement(By.xpath("//button[@class]/parent::div[@class='tm-navigation-filters-spoiler__wrapper']"));
        filter.click();

        WebElement bestFilter = driver.findElement(By.xpath("//button[contains(text(), 'Лучшие')]"));
        bestFilter.click();

        WebElement ratingFilter = driver.findElement(By.xpath("//button[contains(text(),\"Сутки\")]"));
        ratingFilter.click();

    }


}
