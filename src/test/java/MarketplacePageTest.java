import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MarketplacePageTest {
    private WebDriver driver;
    private MarketplacePage marketplacePage;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kkovalov\\onlySeleniumTest\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");

        marketplacePage = new MarketplacePage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void marketplaceHeaderTest() {
        MarketplacePage marketplacePage = mainPage.clickMarketplaceLink();
        String heading = marketplacePage.getMarketplaceHeader();
        Assert.assertEquals("Extend GitHub", heading);
    }

    @Test
    public void marketplaceTextTest() {
        MarketplacePage MarketplacePage = mainPage.clickMarketplaceLink();
        String text = marketplacePage.getMarketplaceText();
        Assert.assertEquals("Find tools to improve your workflow", text);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
