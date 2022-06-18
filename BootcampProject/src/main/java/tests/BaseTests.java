package tests;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.alerts_frame_windows.Alerts;
import pages.alerts_frame_windows.AlertsFramWindowPage;
import pages.alerts_frame_windows.BrowserWindows;
import pages.alerts_frame_windows.ModalDialogs;
import pages.elements.Buttons;
import pages.elements.ElementsPage;
import pages.elements.RadioButton;
import pages.elements.TextBox;
import pages.forms.PracticeForm;
import pages.widgets.Slider;
import java.time.Duration;



@Getter
public class BaseTests {

    private WebDriverWait driverWait;
    private WebDriver driver;

    private static final String HOME_PAGE = "https://demoqa.com/";

    private HomePage homePage;
    private BrowserWindows browserWindows;
    private Alerts alerts;
    private ModalDialogs modalDialogs;
    private RadioButton radioButton;
    private Buttons buttons;
    private Slider slider;
    private ElementsPage elementsPage;
    private AlertsFramWindowPage alertsFramWindowPage;
    private PracticeForm practiceForm;
    private TextBox textBox;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\38161\\\\Documents\\\\STEFAN\\\\chromedriver.exe");
        driver = new ChromeDriver();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.navigate().to(HOME_PAGE);
        driver.manage().window().maximize();

//        WebElement html = driver.findElement(By.tagName("html"));
//        html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

        this.homePage = new HomePage(driver, driverWait);
        this.browserWindows = new BrowserWindows(driver, driverWait);
        this.alerts = new Alerts(driver,driverWait);
        this.modalDialogs = new ModalDialogs(driver,driverWait);
        this.radioButton = new RadioButton(driver,driverWait);
        this.buttons = new Buttons(driver,driverWait);
        this.slider = new Slider(driver,driverWait);
        this.elementsPage = new ElementsPage(driver,driverWait);
        this.alertsFramWindowPage = new AlertsFramWindowPage(driver,driverWait);
        this.practiceForm = new PracticeForm(driver,driverWait);
        this.textBox = new TextBox(driver,driverWait);

    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @AfterMethod
    public void navigateToHomePage (){
        driver.navigate().to(HOME_PAGE);
    }



}
