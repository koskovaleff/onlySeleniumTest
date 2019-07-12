import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kkovalov\\onlySeleniumTest\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join");

        signUpPage = new SignUpPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void signUpWithShortPass(){
        SignUpPage sp = signUpPage.typeUserPassword("qwe");
        String error = sp.getPasswrodErrorText();
        Assert.assertEquals("Make sure it's at least 15 characters OR at least 8 characters including a number and a lowercase letter. Learn more.", error);
    }

    @Test
    public void signUpReservedUsernameTest(){
        driver.get("https://github.com");
        SignUpPage signUpPage = mainPage.register("username", "testemailcoder@yahoo.com", "testpasscodernew");
        mainPage.clickSignUpForGithubButton();
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Username 'username' is unavailable", error);
    }

    @Test
    public void signUpTakenUsername(){
        driver.get("https://github.com");
        SignUpPage signUpPage = mainPage.register("user", "testemailcoder@yahoo.com", "testpasscodernew");
        mainPage.clickSignUpForGithubButton();
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Username is already taken", error);
    }

    @Test
    public void getHeadingTest(){
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
