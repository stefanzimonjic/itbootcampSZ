package domaci_03_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomer extends LoginPage{

    private By customerFirstName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By customerLastName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By customerPostCode = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By customerAddBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");


    public AddCustomer(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void addCustomerFirstName (String firstName){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.customerFirstName));
        getDriver().findElement(this.customerFirstName).sendKeys(firstName);
    }

    public void addCustomerLastName (String lastName){
        getDriver().findElement(this.customerLastName).sendKeys(lastName);
    }

    public void addCustomerPostCode (String postCode){
        getDriver().findElement(this.customerPostCode).sendKeys(postCode);
    }
    public void clickOnAddCustomerBtn (){
        getDriver().findElement(this.customerAddBtn).submit();
    }

}
