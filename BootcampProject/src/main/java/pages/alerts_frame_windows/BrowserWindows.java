package pages.alerts_frame_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class BrowserWindows extends BasePage {

    private By browserWindows = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[1]");
    private By newWindowButton = By.id("windowButton");

    public BrowserWindows(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnBrowserWindows() {
        waitAndClick(browserWindows);
    }

    public void clickOnNewWindowButton() {
        waitAndClick(newWindowButton);
    }

    public String getTitleOfNewWindow() {
        clickOnBrowserWindows();
        clickOnNewWindowButton();
        switchToNewWindow();
        WebElement text = getDriver().findElement(By.id("sampleHeading"));
        String windowText = text.getText();
        getDriver().close();
        switchToOriginalWindow();
        return windowText;
    }
}
