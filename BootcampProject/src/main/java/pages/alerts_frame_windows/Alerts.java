package pages.alerts_frame_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class Alerts extends BasePage {

    private By alerts = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]");
    private By clickMeConfirmBoxBtn = By.id("confirmButton");
    private By confirmBoxResults = By.id("confirmResult");
    private By clickAlertBtnAfter5S = By.id("timerAlertButton");
    private By clickMeWithPromptBox = By.id("promtButton");
    private By promptMessage = By.id("promptResult");

    public Alerts(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnAlerts() {
        scrollTo(getDriver().findElement(alerts));
        waitAndClick(alerts);
    }

    public void clickOnClickMeConfirmBoxBtn() {
//        scrollTo(getDriver().findElement(clickMeConfirmBoxBtn));
        waitAndClick(clickMeConfirmBoxBtn);
    }

    public String clickMeConfirmBoxAcceptMsg() {
        return getDriver().findElement(confirmBoxResults).getText();
    }

    public void clickOnClickBtnWithAlertAfter5s() {
        waitAndClick(this.clickAlertBtnAfter5S);
    }

    public void clickOnClickBtnWithPromptMsg(){
        waitAndClick(clickMeWithPromptBox);
    }

    public void enterPromptMsg (String message) {
        Alert promptAlert = getDriver().switchTo().alert();
        promptAlert.sendKeys(message);
        promptAlert.accept();
    }

    public String promptMsgConfirmMsg (){
        return getDriver().findElement(promptMessage).getText();
    }


}

