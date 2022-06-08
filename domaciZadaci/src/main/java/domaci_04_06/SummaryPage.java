package domaci_04_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage{

    private By facilityConfText = By.id("facility");
    private By applyFHRText = By.id("hospital_readmission");
    private By healthCareProgramText = By.id("program");
    private By visitDateText = By.id("visit_date");
    private By commentText = By.id("comment");
    private By goToHomepageBtn = By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a");
    private By confirmationMessage = By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2");

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String getFacilityConfText() {
        return getDriver().findElement(facilityConfText).getText();
    }

    public String getApplyFHRText() {
        return getDriver().findElement(applyFHRText).getText();
    }

    public String  getHealthCareProgramText() {
        return getDriver().findElement(healthCareProgramText).getText();
    }

    public String getVisitDateText() {
        return getDriver().findElement(visitDateText).getText();
    }

    public String getCommentText() {
        return getDriver().findElement(commentText).getText();
    }
    public void clickGoToHomePage (){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(goToHomepageBtn));
        getDriver().findElement(goToHomepageBtn).click();
    }
    public String getConfirmationMessage (){
        return getDriver().findElement(confirmationMessage).getText();
    }
}
