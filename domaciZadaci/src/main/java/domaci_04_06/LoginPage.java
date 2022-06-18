package domaci_04_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public WebElement getUsername() {
        return getDriver().findElement(username);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public void clickOnMakeAppointment (){
        getDriver().findElement(makeAppointment).click();
    }

    public void enterUsername (String username){
        clearField(this.username);
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.username));
        getUsername().sendKeys(username);
    }

    public void enterPassword (String password){
        getPassword().sendKeys(password);
    }

    public boolean isLoginButtonEnabled (){
        return getLoginButton().isEnabled();
    }

    public void clickLoginButton (){
        getLoginButton().click();
    }

    public void login (String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }


}