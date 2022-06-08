package domaci_04_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By makeAppointmentBtn = By.id("btn-make-appointment");

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnMakeAppointmentBtn (){
        getDriver().findElement(makeAppointmentBtn).click();
    }

}
