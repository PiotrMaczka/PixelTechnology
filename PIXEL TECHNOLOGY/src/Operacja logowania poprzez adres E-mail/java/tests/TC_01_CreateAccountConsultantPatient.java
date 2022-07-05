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

public class TC_01_CreateAccountConsultantPatient {
    private WebDriver wd;
    private Useful Useful;

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
    public void CreateAnAccount() throws InterruptedException {
        pages.CreateAccountPage.loginButton.click();
        pages.CreateAccountPage.loginEmailButton.click();

        pages.CreateAccountPage.usernameInput.clear();
        pages.CreateAccountPage.usernameInput.sendKeys("testypixeltechnology@gmail.com");

        pages.CreateAccountPage.sendCodeButton.click();
        Assertions.assertTrue(wd.getPageSource().contains("kod został wysłany na"));

        pages.CreateAccountPage.codeInput.clear();
        TimeUnit.SECONDS.sleep(30);

        //pages.CreateAccountPage.codeInput.sendKeys("76924");

        Useful.okButton.click();
        Assertions.assertTrue(wd.getPageSource().contains("Hasło powinno składać się przynajmniej z 6 znaków. Ustal nowe hasło dla:"));

        pages.CreateAccountPage.passInput.clear();
        pages.CreateAccountPage.passInput.sendKeys("123456789");
        pages.CreateAccountPage.pass2Input.clear();
        pages.CreateAccountPage.pass2Input.sendKeys("123456789");
        pages.CreateAccountPage.changePassButton.click();

        Assertions.assertTrue(pages.Useful.logoutButton.isDisplayed());
    }
}