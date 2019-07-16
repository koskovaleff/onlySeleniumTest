import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInLink = By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]");
    private By signUpButton = By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[2]");
    private By userNameField = By.xpath("//*[@id=\"user[login]\"]");
    private By userEmailField = By.xpath("//*[@id=\"user[email]\"]");
    private By userPasswordField = By.xpath("//*[@id=\"user[password]\"]");
    private By signUpForGithubButton = By.xpath("/html/body/div[4]/main/div[1]/div/div/div[2]/div/form/button");
    private By incorrectUserEmail = By.xpath("/html/body/div[4]/main/div[1]/div/div/div[2]/div/form/dl[2]/dd[2]");
    private By enterpricePageLink = By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[2]/a");
    private By marketplacePageLink = By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[4]/a");

    public LoginPage clickSignInLink () {
        driver.findElement(signInLink).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton () {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpForGithubButton () {
        driver.findElement(signUpForGithubButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName (String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public MainPage typeEmail (String email) {
        driver.findElement(userEmailField).sendKeys(email);
        return this;
    }

    public MainPage typePassword (String password) {
        driver.findElement(userPasswordField).sendKeys(password);
        return this;
    }

    public SignUpPage register (String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        return new SignUpPage(driver);
    }

    public String getIncorrectEmailError () {
        return driver.findElement(incorrectUserEmail).getText();
    }

    public EnterpricePage clickEnterpriceLink () {
        driver.findElement(enterpricePageLink).click();
        return new EnterpricePage(driver);
    }

    public MarketplacePage clickMarketplaceLink () {
        driver.findElement(marketplacePageLink).click();
        return new MarketplacePage(driver);
    }

}
