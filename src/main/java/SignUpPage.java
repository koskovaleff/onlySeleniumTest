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
    private By mainError = By.xpath("//*[@id=\"signup-form\"]/div[1]");
    private By userNameError = By.xpath("//input[@id='user_login']/ancestor::dd/following-sibling::dd");
    private By emailError = By.xpath(".//*[@id='user_email']/ancestor::dd/following-sibling::dd");
    private By userNameErrorTooltip = By.xpath("//*[@id=\"description_14ac72874f77\"]");
    private By passwordError = By.xpath("//*[@id=\"signup-form\"]/password-strength/p");

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

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password){
        this.typeUserName(username);
        this.typeUserEmail(email);
        this.typeUserPassword(password);
        driver.findElement(createAccountButton).click();
        return new SignUpPage(driver);
    }

    public String getMainErrorText(){

        return driver.findElement(mainError).getText();
    }

    public String getUsernameErrorText(){

        return driver.findElement(userNameError).getText();
    }

    public String getPasswrodErrorText(){

        return driver.findElement(passwordError).getText();
    }

    public String getEmailErrorText(){

        return driver.findElement(emailError).getText();
    }

}
