package domaci_26_05;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
/*Domaći: Otići na kupujemprodajem.com, u pretragu ukucati iphone 13, kliknuti na prvi rezultat.
Proveriti da je naslov oglasa onaj koji smo uočili i tokom manuelnog izvođenja kejsa.*/

    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\38161\\Documents\\STEFAN\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;

            driver.get("https://www.kupujemprodajem.com/");
            driver.findElement(By.xpath("//*[@id=\"bodyTag\"]/div[9]/div/div[2]")).click();
            WebElement el2 = driver.findElement(By.id("searchKeywordsInput"));
            el2.sendKeys("iphone 13");
            el2.sendKeys(Keys.ENTER);
//            Thread.sleep(7000);
            WebElement el3 = driver.findElement(By.className("adImgWrapper"));
            js.executeScript("arguments[0].scrollIntoView();", el3);
//            Thread.sleep(4000);
            el3.click();
            String automatedTestURL = driver.getCurrentUrl();
            Thread.sleep(3000);
            driver.close();

            String manualTestURL = "https://www.kupujemprodajem.com/mobilni-telefoni/apple-iphone/iphone-13-iphone-12-iphone-11-novo/oglas/7321776?kputm_campaign=top_search&filter_id=1490480232";

            if (automatedTestURL.equals(manualTestURL)){
                System.out.println("Test pass \n Isti je oglas kao kod manuelnog trazenja oglasa");
            }else {
                System.out.println("Test fail \n Nije isti oglas");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
