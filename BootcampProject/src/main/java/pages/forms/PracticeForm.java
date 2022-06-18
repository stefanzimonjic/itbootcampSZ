package pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class PracticeForm extends BasePage {

    private By practiceForm = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li[1]");

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By radioBtn = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div");


    public PracticeForm(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnPracticeForm (){
        waitAndClick(practiceForm);
    }
//    public void selectRadioBtnByValue(String value) {
//        WebElement selectByValue = getDriver().findElement(this.radioBtn).getAttribute(value);
//    }
}

