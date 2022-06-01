package domaci_31_05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

/*Domaći:
    Napisati dva smoke testa za https://www.telerik.com/support/demos:
Proveriti da klikom na Desktop odlazimo na tu sekciju
Proveriti da klikom na Mobile odlazimo na tu sekciju
Koristiti TestNG, asserte.
Domaći na git.*/

public class SmokeTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\38161\\Documents\\STEFAN\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void openPage() {
        driver.navigate().to("https://www.telerik.com/support/demos");
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }
    /**
     * The method verifies that when the desktop header is clicked, the page is scrolled down to the Display section.
     */
    @Test
    public void desktopCheck() {
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]")).click();
        WebElement desktopSection = driver.findElement(By.id("desktop"));
        WebDriverWait waitTillPresent = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitTillPresent.until(ExpectedConditions.visibilityOf(desktopSection));
        String actualDisplay = desktopSection.getText();
        String expectedDisplay = "Desktop";
        Assert.assertEquals(actualDisplay, expectedDisplay);
    }

    /**
     * The method verifies that when the mobile header is clicked, the page is scrolled down to the Mobile section.
     */
    @Test
    public void mobileCheck (){
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]")).click();
        WebElement mobileSection = driver.findElement(By.id("mobile"));
        WebDriverWait waitTillPresent = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitTillPresent.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile")));
        String actualDisplay = mobileSection.getText();
        String expectedDisplay = "Mobile";
        Assert.assertEquals(actualDisplay, expectedDisplay);
    }

/*    Ucinilo mi se da moze i ovako, ali nisam uspeo da pronadjem funkciju koja potvrdjuje da je stranica zapravo skrolovana
    do trazene sekcije, ovaj metod samo potvrdjuje da je ta sekcija prisutna i vidljiva na stranici.
    (Podsetnik: Napraviti bolji metod na ovaj nacin kada naucimo vise)
    @Test
    public void mobileCheck (){
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]")).click();
        WebElement mobileSection = driver.findElement(By.id("mobile"));
        WebDriverWait waitTillPresent = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitTillPresent.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile")));
        boolean isDisplayed = mobileSection.isDisplayed();
        boolean expectedDisplay = true;
        Assert.assertEquals(isDisplayed, expectedDisplay);
    }
*/

}
