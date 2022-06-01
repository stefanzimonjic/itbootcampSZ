package domaci_30_05;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class StrelaTest {
    /*Domaći:
Otići na http://www.strela.co.rs/, kliknuti na dugme Prodavnica u headeru, izabrati opciju Lukovi - Bows iz leve navigacije,
potom kliknuti na luk koji se zove Samick Sage, i onda proveriti da ime tog luka na njegovoj stranici zaista sadrži reč Samick.*/

    /**
     * The method verifies that when the name of the add contains Samick.
     */
    @Test
    public void containSamick() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\38161\\Documents\\STEFAN\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.navigate().to("http://www.strela.co.rs/");

        WebElement prodavnica = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a"));
        prodavnica.click();
        WebElement lukovi = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
        driverWait.until(ExpectedConditions.elementToBeClickable(lukovi));
        lukovi.click();
//        try {
//            Thread.sleep(14000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img")));
        WebElement samickSage = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
        driverWait.until(ExpectedConditions.visibilityOf(samickSage));
        js.executeScript("arguments[0].scrollIntoView();", samickSage);
        driverWait.until(ExpectedConditions.elementToBeClickable(samickSage));
        samickSage.click();
        WebElement imeLuka = driver.findElement(By.xpath("//*[@id=\"page-sidebar\"]/article/div[1]/div[2]/h3"));
        String ime = imeLuka.getText();
        boolean actualResult = ime.contains("Samick");
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult);
        driver.close();
    }
}
