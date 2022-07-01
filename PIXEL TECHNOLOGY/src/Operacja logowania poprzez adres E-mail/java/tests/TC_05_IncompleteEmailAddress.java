package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC_05_IncompleteEmailAddress {
    private WebDriver wd;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    public void driverQuit() {
        wd.close();
        wd.quit();
    }

    @Test
    public void IncompleteEmail(){

        String url = "https://radibox.szpital.gorlice.pl/";

        wd.get(url);
        wd.findElement(By.xpath("//div[contains(text(),'Zaloguj')]")).click();
        wd.findElement(By.xpath("//span[contains(text(),'konsultant, pacjent')]")).click();

        WebElement userName = wd.findElement(By.id("username"));
        userName.clear();
        userName.sendKeys("testypixeltechnology");

        wd.findElement(By.xpath("//button[contains(text(),'Wyślij kod')]")).click();
        Assertions.assertTrue(wd.getPageSource().contains("Email lub numer telefonu komórkowego nie jest poprawny"));
    }
}