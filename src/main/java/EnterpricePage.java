import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterpricePage {

    private WebDriver driver;

    public EnterpricePage(WebDriver driver) {
        this.driver=driver;

    }

    private By enterpriceHeader = By.xpath("/html/body/div[4]/main/div[1]/div/div/h1");
    private By enterpriceText = By.xpath("/html/body/div[4]/main/div[1]/div/div/p");

    public String getEnterpriceHeader() {
        return driver.findElement(enterpriceHeader).getText();
    }

    public String getEnterpriceText() {
        return driver.findElement(enterpriceText).getText();
    }

}
