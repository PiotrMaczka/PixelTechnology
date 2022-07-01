package tests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TC_03_CorrectlyLoggedInByEmailAsAConsultantOrPatient {
    private WebDriver wd;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @AfterEach
    public void driverQuit() {
        wd.close();
        wd.quit();
    }

    @Test
    public void CorrectlyLogIn(){

        String url = "https://radibox.szpital.gorlice.pl/";

        wd.get(url);
        wd.findElement(By.xpath("//div[contains(text(),'Zaloguj')]")).click();
        wd.findElement(By.xpath("//span[contains(text(),'konsultant, pacjent')]")).click();

        WebElement userName = wd.findElement(By.id("username"));
        userName.clear();
        userName.sendKeys("testypixeltechnology@gmail.com");

        WebElement userPass = wd.findElement(By.id("password"));
        userPass.clear();
        wd.findElement(By.id("password")).sendKeys("123456789");
        wd.findElement(By.xpath("//button[text()='Zaloguj się']")).click();

        WebElement logOutBtn = wd.findElement(By.xpath("//div[@data-ng-click='performLogout()']"));
        Assertions.assertTrue(logOutBtn.isDisplayed());
    }
}