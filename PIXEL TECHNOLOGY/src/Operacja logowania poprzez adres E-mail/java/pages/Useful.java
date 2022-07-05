package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Useful extends MainPage {
    public Useful(WebDriver driver) {
        super(driver);
    }

    public static final String BASE_URL = "https://radibox.szpital.gorlice.pl/";

    @FindBy(xpath = "//button[text()='Ok']")
    public static
    WebElement okButton;

    @FindBy(xpath = "//div[@data-ng-click='performLogout()']")
    public static
    WebElement logoutButton;

}
