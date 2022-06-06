package domaci_03_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerPage extends LoginPage {

    private By transactions = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]");
    private By deposit = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By withdrawal = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");

    private By amountToDeposit = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By depositButton = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");

    private By amountToWithdrawal = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By withdrawalButton = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");

    private By logout = By.xpath("/html/body/div/div/div[1]/button[2]");
    private By welcomeMessage = By.xpath("/html/body/div/div/div[2]/div/div[1]/strong");
    private By balance = By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]");


    public CustomerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnDeposit() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(deposit));
        getDriver().findElement(deposit).click();
    }

    public void enterAmountToDeposit(String amount) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(amountToDeposit));
        getDriver().findElement(amountToDeposit).sendKeys(amount);
    }

    public void clickOnWithdrawal() {
//        Samo kada stavim sleed povuce iznos sa racuna, bez toga, i sa implicitnim i sa eksplicitnim vejterom
//        umesto withdrawal on uradi deposit na racun, i stanje se podupla
        try {
            Thread.sleep(1000);
            getDriverWait().until(ExpectedConditions.elementToBeClickable(this.withdrawal));
            getDriver().findElement(this.withdrawal).click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterAmountToWithdrawal(String amount) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(amountToWithdrawal));
        getDriver().findElement(amountToWithdrawal).sendKeys(amount);
    }

    public void clickSubmitDeposit() {
        getDriver().findElement(depositButton).submit();
    }

    public String accountBalance() {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(balance));
        return getDriver().findElement(balance).getText();
    }

    public void clickSubmitWithdrawal() {
        getDriver().findElement(withdrawalButton).submit();
    }

    public void logoutCustomer() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(logout));
        getDriver().findElement(logout).click();
    }

    public boolean isLogoutButtonDisplayed() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return getDriver().findElement(logout).isDisplayed();
    }

    public String welcomeCustomerMessage() {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(this.welcomeMessage));
        return getDriver().findElement(this.welcomeMessage).getText();
    }

}