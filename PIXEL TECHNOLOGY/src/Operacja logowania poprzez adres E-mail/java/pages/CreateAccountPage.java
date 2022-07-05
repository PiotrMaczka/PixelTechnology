package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends MainPage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.pointer")
    public static
    WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),'konsultant, pacjent')]")
    public static
    WebElement loginEmailButton;

    @FindBy(id = "username")
    public static
    WebElement usernameInput;

    @FindBy(xpath = "//button[contains(text(),'Wyślij kod')]")
    public static
    WebElement sendCodeButton;

    @FindBy(id = "code")
    public static
    WebElement codeInput;

    @FindBy(id = "password")
    public static
    WebElement passInput;

    @FindBy(id = "password2")
    public static
    WebElement pass2Input;

    @FindBy(xpath = "//button[text()='Zmień hasło']")
    public static
    WebElement changePassButton;

    @FindBy(xpath = "//button[text()='Zaloguj się']")
    public static
    WebElement LogInButton;

}