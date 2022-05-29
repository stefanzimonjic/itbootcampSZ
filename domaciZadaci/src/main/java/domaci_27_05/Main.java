package domaci_27_05;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    /*Domaći:
Otići na https://www.stealmylogin.com/demo.html, uneti bilo koje kredencijale za login, prisisnuti dugme.
Izvršiti proveru da je, nakon logina, URL promenjen na https://example.com/ kroz grananje.
Ako jeste, štampati “Nice”. Ako nije, štampati “Not nice.”
Sve elemente koji se koriste smestiti u intuitivno imenovane promenljive.
Kod na git, screen recording puštanja i izvršavanja testa na Drive.*/

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\38161\\Documents\\STEFAN\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.stealmylogin.com/demo.html");
        WebElement el = driver.findElement(By.name("username"));
        el.sendKeys("random Text");
        el.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String urlAfterLogin = driver.getCurrentUrl();
        driver.close();

        String testUrl = "https://example.com/";

        if (urlAfterLogin.equals(testUrl)){
            System.out.println("Nice");
        }else {
            System.out.println("Not nice");
        }
    }
}
