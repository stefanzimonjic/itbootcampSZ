package domaci_03_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerLoginPage extends LoginPage{

    private By nameSelect = By.id("userSelect");
    private By login = By.xpath("/html/body/div/div/div[2]/div/form/button");

    public CustomerLoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void selectCustomer (String customer){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(nameSelect));
        Select customerSelect = new Select(getDriver().findElement(nameSelect));
        customerSelect.selectByVisibleText(customer);
    }

    public void clickLogin (){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(login));
        getDriver().findElement(login).click();
    }
}
