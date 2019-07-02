import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "e:\\JavaProjects\\Selenide\\onlySeleniumTest\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");

        mainPage = new MainPage(driver);
    }

    @Test
    public void signIn() {
        LoginPage loginPage = mainPage.clickSignInLink();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest() {
        SignUpPage signUpPage = mainPage.register("testuser", "testemail@yahoo.com", "testpass");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUsernameTest(){
        SignUpPage signUpPage = mainPage.register("", "mail", "pass");
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Login can't be blank", error);
    }

    @Test
    public void signUpInvalidEmailTest(){
        SignUpPage signUpPage = mainPage.register("qeqwe", "qweq", "pass");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
