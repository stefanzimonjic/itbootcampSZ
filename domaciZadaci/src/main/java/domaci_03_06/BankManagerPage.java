package domaci_03_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankManagerPage extends BasePage {

    private By addCustomer = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By openAccount = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");

    public BankManagerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickAddCustomer() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.addCustomer));
        getDriver().findElement(this.addCustomer).click();
    }

    public void clickOpenAccount() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.openAccount));
        getDriver().findElement(this.openAccount).click();
    }
}
