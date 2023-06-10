package tests;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

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
        MainPage mp = new MainPage(driver);
        driver.get("https://www.habr.com/");
        mp.clickButtonNews();
        mp.clickButtonFilter();
        mp.clickButtonBest();
        mp.clickButtonAccept();
        assertTrue(driver.findElement(By.xpath("//article[@class='tm-articles-list__item'][1]")).isDisplayed(), "нет заголовка");
    }
    @Test
    public void checkBlogRUVDS() {
        MainPage mp = new MainPage(driver);
        driver.get("https://www.habr.com/");
        mp.clickLinkCompanyRUVDS();
        assertTrue(driver.findElement(By.xpath("//a[@href='/ru/companies/ruvds/profile/']/parent::div[@class='tm-company-card__info']")).isDisplayed());
    }
}
