import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketplacePage {

    private WebDriver driver;

    public MarketplacePage(WebDriver driver) {
        this.driver=driver;

    }

    private By marketplaceHeader = By.xpath("//*[@id=\"js-pjax-container\"]/div[1]/div[1]/div/h1");
    private By marketplaceText = By.xpath("//*[@id=\"js-pjax-container\"]/div[1]/div[1]/div/p");

    public String getMarketplaceHeader() {
        return driver.findElement(marketplaceHeader).getText();
    }

    public String getMarketplaceText() {
        return driver.findElement(marketplaceText).getText();
    }

}
