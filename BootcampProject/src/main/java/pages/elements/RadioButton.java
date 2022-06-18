package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class RadioButton extends BasePage {

    private By radioButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[3]");
    private By yesRadio = By.id("yesRadio");
    private By impressiveRadio = By.id("impressiveRadio");
    private By noRadio = By.id("noRadio");
    private By selectedResponse = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p");

    public RadioButton(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnRadioButton() {
        waitAndClick(radioButton);
    }

    public void clickOnYesRadio() {
        WebElement yesRadioBtn = getDriver().findElement(this.yesRadio);
        if (yesRadioBtn.isEnabled() && !yesRadioBtn.isSelected()) {
            jsExecutorClick(yesRadioBtn);
        }
    }

    public void clickOnImpressiveRadio() {
        WebElement impressiveRadio = getDriver().findElement(this.impressiveRadio);
        if (impressiveRadio.isEnabled() && !impressiveRadio.isSelected()) {
            jsExecutorClick(impressiveRadio);
        }
    }

    public String responseText() {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(selectedResponse));
        if (getDriver().findElement(selectedResponse).isDisplayed()) {
            return getDriver().findElement(selectedResponse).getText();
        }
        return null;
    }
    public boolean yesIsSelected (){
        return getDriver().findElement(yesRadio).isSelected();
    }
    public boolean noIsSelected (){
        return getDriver().findElement(noRadio).isSelected();
    }
    public boolean impressiveIsSelected (){
        return getDriver().findElement(impressiveRadio).isSelected();
    }

}
