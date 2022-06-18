package pages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

@AllArgsConstructor
@Getter
public class BasePage {

    private WebDriver driver;
    private WebDriverWait driverWait;

    public void switchToNewWindow() {
        String mainWindow = getDriver().getWindowHandle();
        Set<String> allWindows = getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!mainWindow.equalsIgnoreCase(window)) {
                getDriver().switchTo().window(window);
                break;
            }
        }
    }

    public void switchToOriginalWindow() {
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next());
    }

    public boolean alertIsPresent() {
        return getDriverWait().until(ExpectedConditions.alertIsPresent()) != null;
    }

    public String popupWindowGetText() {
        return getDriver().switchTo().alert().getText();
    }

    public void popupWindowAccept() {
        getDriver().switchTo().alert().accept();
    }

    public void popupWindowDismiss() {
        getDriver().switchTo().alert().dismiss();
    }

    public void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitAndClick(By element) {
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public void jsExecutorClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void actionsDoubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void actionsRightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
    //*[@id="item-0"]
    //*[@id="app"]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]
}