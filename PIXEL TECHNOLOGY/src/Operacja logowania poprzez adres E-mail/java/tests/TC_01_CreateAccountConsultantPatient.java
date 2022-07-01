package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateAccountPage;

import java.util.concurrent.TimeUnit;

import static pages.CreateAccountPage.BASE_URL;


public class TC_01_CreateAccountConsultantPatient {
    private WebDriver wd;
    private CreateAccountPage CreateAccountPage;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        wd = new ChromeDriver();
        wd.get(BASE_URL);
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assertions.assertTrue(wd.getCurrentUrl().contains("https://radibox.szpital.gorlice.pl/#/login?returnTo=%2Flogin"));

        CreateAccountPage = new CreateAccountPage(wd);

    }

    @AfterEach
    public void driverQuit() {
        wd.close();
        wd.quit();
    }

    @Test
    public void CreateAnAccount() throws InterruptedException {
        pages.CreateAccountPage.LoginButton.click();

        wd.findElement(By.xpath("//div[contains(text(),'Zaloguj')]")).click();
        wd.findElement(By.xpath("//span[contains(text(),'konsultant, pacjent')]")).click();

        WebElement userName = wd.findElement(By.id("username"));
        userName.clear();
        userName.sendKeys("testypixeltechnology@gmail.com");

        wd.findElement(By.xpath("//button[contains(text(),'Wyślij kod')]")).click();
        Assertions.assertTrue(wd.getPageSource().contains("kod został wysłany na"));

        WebElement userCode = wd.findElement(By.id("code"));
        userCode.clear();
        TimeUnit.SECONDS.sleep(60);

        //userCode.sendKeys("76924");

        wd.findElement(By.xpath("//button[text()='Ok']")).click();
        Assertions.assertTrue(wd.getPageSource().contains("Hasło powinno składać się przynajmniej z 6 znaków. Ustal nowe hasło dla:"));

        wd.findElement(By.id("password")).sendKeys("5XdCaKMxcZ");
        wd.findElement(By.id("password2")).sendKeys("5XdCaKMxcZ");
        wd.findElement(By.xpath("//button[text()='Zmień hasło']")).click();
        WebElement logOutBtn = wd.findElement(By.xpath("//div[@data-ng-click='performLogout()']"));
        Assertions.assertTrue(logOutBtn.isDisplayed());
    }
}