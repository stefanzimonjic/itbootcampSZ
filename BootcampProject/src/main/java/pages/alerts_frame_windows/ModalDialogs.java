package pages.alerts_frame_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class ModalDialogs extends BasePage {

    private By modalDialogs = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[5]");
    private By smallModalBtn = By.id("showSmallModal");
    private By smallModalTitle = By.id("example-modal-sizes-title-sm");
    private By smallModalClose = By.id("closeSmallModal");
    private By largeModalHeading = By.id("example-modal-sizes-title-lg");
    private By largeModalButton = By.id("showLargeModal");
    private By largeModalClose = By.id("closeLargeModal");

    public ModalDialogs(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnModalDialogs() {
        scrollTo(getDriver().findElement(modalDialogs));
        waitAndClick(modalDialogs);
    }

    public void clickOnSmallModalBtn() {
        scrollTo(getDriver().findElement(smallModalBtn));
        waitAndClick(smallModalBtn);
    }

    public String smallModalText() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(smallModalTitle));
        return getDriver().findElement(smallModalTitle).getText();
    }

    public void smallModalClose() {
        getDriver().findElement(smallModalClose).click();
    }

    public void clickOnLargeModalButton() {
        scrollTo(getDriver().findElement(largeModalButton));
        waitAndClick(largeModalButton);
    }

    public String largeModalText() {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(largeModalHeading));
        return getDriver().findElement(largeModalHeading).getText();
    }

    public void largeModalClose() {
        getDriver().findElement(largeModalClose).click();
    }

}