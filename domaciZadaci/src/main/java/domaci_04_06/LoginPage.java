package domaci_04_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By makeAppointment = By.id("btn-make-appointment");
    private By username = By.id("txt-username");
    private By password = By.id("txt-password");
    private By loginButton = By.id("btn-login");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnMakeAppointment (){
        getDriver().findElement(makeAppointment).click();
    }

    public void enterUsername (String username){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.username));
        getDriver().findElement(this.username).sendKeys(username);
    }

    public void clickPassword (){
        getDriver().findElement(this.password).click();
    }

    public void enterPassword (String password){
        getDriver().findElement(this.password).sendKeys(password);
    }

    public boolean isLoginButtonEnabled (){
        return getDriver().findElement(this.loginButton).isEnabled();
    }

    public void clickLoginButton (){
        getDriver().findElement(this.loginButton).click();
    }



}