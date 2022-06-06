package domaci_03_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccount extends LoginPage {

    private By customerSelect = By.id("userSelect");
    private By currency = By.id("currency");
    private By process = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    public OpenAccount(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void selectCustomer(String customer) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.customerSelect));
        Select selectCustomer = new Select(getDriver().findElement(customerSelect));
        selectCustomer.selectByVisibleText(customer);
    }

    public void selectCurrency(Currency currency) {
        Select selectCurrency = new Select(getDriver().findElement(this.currency));
        selectCurrency.selectByVisibleText(String.valueOf(currency));
    }

    public void clickOnProcess() {
        getDriver().findElement(this.process).submit();
    }

}
