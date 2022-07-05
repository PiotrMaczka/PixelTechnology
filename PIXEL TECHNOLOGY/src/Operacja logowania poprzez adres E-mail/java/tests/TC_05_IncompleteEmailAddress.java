package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateAccountPage;
import pages.Useful;

import java.util.concurrent.TimeUnit;

public class TC_05_IncompleteEmailAddress {
    private WebDriver wd;
    private pages.Useful Useful;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        wd = new ChromeDriver();
        wd.get(Useful.BASE_URL);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assertions.assertTrue(wd.getCurrentUrl().contains(Useful.BASE_URL));

        new CreateAccountPage(wd);
        Useful = new Useful(wd);
    }

    @AfterEach
    public void driverQuit() {
        wd.close();
        wd.quit();
    }

    @Test
    public void IncompleteEmail(){

        pages.CreateAccountPage.loginButton.click();
        pages.CreateAccountPage.loginEmailButton.click();

        pages.CreateAccountPage.usernameInput.clear();
        pages.CreateAccountPage.usernameInput.sendKeys("testypixeltechnology");

        pages.CreateAccountPage.sendCodeButton.click();

        Assertions.assertTrue(wd.getPageSource().contains("Email lub numer telefonu komórkowego nie jest poprawny"));
    }
}