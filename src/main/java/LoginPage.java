import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//*[@id=\"login_field\"]");
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By signInButton = By.xpath("/html/body/div[3]/main/div/form/div[3]/input[4]");
    private By heading = By.xpath("/html/body/div[3]/main/div/form/div[1]/h1");
    private By error = By.xpath("/html/body/div[3]/main/div/form/div[2]/div/div");
    private By createAccLink = By.xpath("/html/body/div[3]/main/div/p/a");

    public LoginPage typeUserName (String username) {
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithIncorrectCreds (String username, String password) {
        this.typeUserName(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getErrorString() {
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount() {
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }



}
