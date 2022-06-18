package pages.alerts_frame_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class AlertsFramWindowPage extends BasePage {

    private By menuBar = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li");
    private By header = By.xpath("//*[@id=\"app\"]/div/div/div[1]/div");

    public AlertsFramWindowPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public ArrayList<String> menuContent() {
        List<WebElement> list = getDriver().findElements(this.menuBar);
        ArrayList<String> newList = new ArrayList<>();
        for (WebElement element : list) {
            newList.add(element.getText());
        }
        return newList;
    }

    public String elementsHeader() {
        return getDriver().findElement(this.header).getText();
    }

}
