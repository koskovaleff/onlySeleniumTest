import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("/html/body/div[4]/main/div/div/div[1]/h1");
    private By createAccountButton = By.xpath("//*[@id=\"signup_button\"]");
    private By userNameField = By.xpath("//*[@id=\"user_login\"]");
    private By userEmailField = By.xpath("//*[@id=\"user_email\"]");
    private By userPasswordField = By.xpath("//*[@id=\"user_password\"]");

    public SignUpPage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typeUserEmail(String email) {
        driver.findElement(userEmailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeUserPassword(String password) {
        driver.findElement(userPasswordField).sendKeys(password);
        return this;
    }
}
