package domaci_03_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private final By customerLogin = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    private final By managerLogin = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");
    private final By homeBtn = By.xpath("/html/body/div/div/div[1]/button[1]");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public boolean isDisplayedAddCustomer() {
        return getDriver().findElement(customerLogin).isDisplayed();
    }

    public void clickCustomerLogin() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(customerLogin));
        getDriver().findElement(customerLogin).click();
    }

    public void clickManagerLogin() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(managerLogin));
        getDriver().findElement(managerLogin).click();
    }

    public void clickHomeBtn() {

        getDriver().findElement(homeBtn).click();
    }

    public void popUpWindowOk() {
        getDriver().switchTo().alert().accept();
    }

    public boolean popUpWindowContains(String text) {
        String message = getDriver().switchTo().alert().getText();
        return message.contains(text);
    }

}
