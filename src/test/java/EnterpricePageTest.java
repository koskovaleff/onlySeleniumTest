import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EnterpricePageTest {
    private WebDriver driver;
    private EnterpricePage enterpricePage;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kkovalov\\onlySeleniumTest\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");

        enterpricePage = new EnterpricePage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void enterpriceHeaderTest() {
        EnterpricePage EnterpricePage = mainPage.clickEnterpriceLink();
        String heading = enterpricePage.getEnterpriceHeader();
        Assert.assertEquals("The future of enterprise innovation is open source", heading);
    }

    @Test
    public void enterpriceTextTest() {
        EnterpricePage EnterpricePage = mainPage.clickEnterpriceLink();
        String text = enterpricePage.getEnterpriceText();
        Assert.assertEquals("Transform your business into an open source enterprise. Make a smart and secure investment in open source with GitHub Enterprise.", text);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
