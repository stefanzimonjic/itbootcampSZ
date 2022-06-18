package pages.elements;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TextBox extends BasePage {

    private By textBox = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]");
    private By fullName = By.id("userName");
    private By email = By.id("userEmail");
    private By currentAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By confirmationText = By.xpath("//*[@id=\"output\"]/div/p");

    RandomString randomString = new RandomString(6, ThreadLocalRandom.current());

    public TextBox(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnTextBox() {
        waitAndClick(textBox);
    }

    public void enterFullName() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(fullName));
        getDriver().findElement(fullName).sendKeys(randomString.nextString());
    }

    public void enterEmail() {
        String emailText = randomString.nextString() + "@" + "mail" + ".com";
        getDriver().findElement(this.email).sendKeys(emailText);
    }

    public void enterCurrentAddress() {
        getDriver().findElement(currentAddress).sendKeys(randomString.nextString());
    }

    public void enterPermanentAddress() {
        getDriver().findElement(permanentAddress).sendKeys(randomString.nextString());
    }

    public void clickSubmit() {
        scrollTo(getDriver().findElement(submitButton));
        getDriver().findElement(submitButton).click();
    }

    public void enterData() {
        enterFullName();
        enterEmail();
        enterCurrentAddress();
        enterPermanentAddress();
        clickSubmit();
    }

    public ArrayList<String> confirmationText() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(confirmationText));
        ArrayList<String> confText = new ArrayList<>();
        List<WebElement> confirmationList = getDriver().findElements(confirmationText);
        for (WebElement element : confirmationList) {
            confText.add(element.getText());
        }
        if (!confText.isEmpty()) {
            return confText;
        }
        return null;
    }
}
