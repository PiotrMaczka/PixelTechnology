package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateAccountPage extends MainPage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public static final String BASE_URL = "https://radibox.szpital.gorlice.pl/";

    @FindBy(xpath = "//div[contains(text(),'Zaloguj')]")
    public static
    WebElement LoginButton;

    @FindBy(css = "button.btn.btn-default.button-search")
    static
    WebElement searchButton;

    @FindBy(css = ".page-heading.product-listing .heading-counter")
    static
    List<WebElement> headingCounter;

    @FindBy(css = ".top-pagination-content.clearfix .product-count")
    static
    WebElement topPagination;

    @FindBy(css = ".right-block .product-name")
    static
    List<WebElement> resultOfSearching;

    @FindBy(css = ".right-block .price.product-price")
    static
    List<WebElement> somePrice;

    public static void clickOnLoginButton() {
        LoginButton.click();

    }
}
