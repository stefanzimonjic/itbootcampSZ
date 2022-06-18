package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class Slider extends BasePage {

    private By slider = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[4]");
    private By sliderDot = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/form/div/div[1]/span/div");
    private By sliderValue = By.id("sliderValue");


    public Slider(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnSlider (){
        scrollTo(getDriver().findElement(slider));
        waitAndClick(slider);
    }
//    public void moveSliderDot (){
//        Actions actions = new Actions(getDriver());
//        WebElement sliderDot = getDriver().findElement(this.sliderDot);
//        sliderDot.click();
//        actions.moveToElement(sliderDot).perform();
//        actions.sendKeys(Keys.ARROW_RIGHT);
//        actions.clickAndHold(sliderDot).perform();
//        actions.dragAndDropBy(sliderDot, xOffset, yOffset).perform();
//        actions.moveByOffset(xOffset,yOffset).perform();
//        actions.click().perform();
//    }

    public String sliderValue (){
       return getDriver().findElement(sliderValue).getAttribute("value");
    }

}
