package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class Buttons extends BasePage {

    private By buttons = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[5]");
    private By doubleClickBtn = By.id("doubleClickBtn");
    private By rightClickMe = By.id("rightClickBtn");
    private By clickMessage = By.xpath("//*[contains(@id, 'ClickMessage')]");
    private By clickMeBtn = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button");

    public Buttons(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnButtons() {
        scrollTo(getDriver().findElement(buttons));
        waitAndClick(buttons);
    }

    public void clickOnDoubleClick() {
        waitAndClick(doubleClickBtn);
    }

    public void doubleClickOnDoubleClick() {
        actionsDoubleClick(getDriver().findElement(doubleClickBtn));
    }

    public void rightClickOnRightClickBtn() {
        actionsRightClick(getDriver().findElement(rightClickMe));
    }

    public void clickOnClickMe() {
        waitAndClick(clickMeBtn);
    }

    public void doubleClickOnRightClick() {
        actionsDoubleClick(getDriver().findElement(rightClickMe));
    }

    public ArrayList<String> clickMsg() {
        List<WebElement> list = getDriver().findElements(clickMessage);
        ArrayList<String> listOfMessages = new ArrayList<>();
        for (WebElement element : list) {
            listOfMessages.add(element.getText());
        }
        if (!listOfMessages.isEmpty()) {
            return listOfMessages;
        }
        return null;
    }
}
