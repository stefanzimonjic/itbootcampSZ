package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By elementsSection = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div");
    private By formSection = By.xpath(("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div"));
    private By alertsFrameWindowsSection = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div");
    private By widgetSection = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[4]/div");
    private By interactionsSection = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[5]/div");
    private By bookStoreApplicationSection = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div");

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnElements() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(elementsSection));
        getDriver().findElement(elementsSection).click();
    }

    public void clickOnForms() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(formSection));
        getDriver().findElement(formSection).click();
    }

    public void clickOnAlertsFrameWindows() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(alertsFrameWindowsSection));
        getDriver().findElement(alertsFrameWindowsSection).click();
    }

    public void clickOnWidget() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(widgetSection));
        getDriver().findElement(widgetSection).click();
    }

    public void clickOnInteractions() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(interactionsSection));
        getDriver().findElement(interactionsSection);
    }

    public void clickOnBookStoreApplication() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(bookStoreApplicationSection));
        getDriver().findElement(bookStoreApplicationSection).click();
    }


}
