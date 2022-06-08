package domaci_04_06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

/*AppointmentTest
        o   Ucitajte stranicu https://katalon-demo-cura.herokuapp.com/
        o   Ulogovate se na stranicu preko demo naloga
        John Doe/ThisIsNotAPassword
        o   Za proveru da li je korisnik ulogovan iskoristite metodu isFormPresented iz AppointmentPage klase.
        o   Popunite appointment formu
        o   I proverite da li se unosi sa appointment forme uklapaju sa podacima sa summary stranice
        katalon-demo-cura.herokuapp.com
        */
public class AppointmentTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private AppointmentPage appointmentPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private SummaryPage summaryPage;

    @BeforeClass
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\38161\\Documents\\STEFAN\\chromedriver.exe");
        driver = new ChromeDriver();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        appointmentPage = new AppointmentPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        summaryPage = new SummaryPage(driver, driverWait);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test(priority = 1)
    public void login() {
        homePage.clickOnMakeAppointmentBtn();
        loginPage.enterUsername("John Doe");
        loginPage.enterPassword("ThisIsNotAPassword");
        loginPage.clickLoginButton();
        Assert.assertTrue(appointmentPage.isFormPresented());
    }

    @Test(priority = 2)
    public void fillAppointmentForm() {
        appointmentPage.selectFacility(1);
        appointmentPage.checkBoxApplyFHR();
        appointmentPage.clickRadioBtnMedicaid();
        appointmentPage.visitDateInputSet("12/02/2023");
        appointmentPage.commentInputSet("Random comment");
        appointmentPage.clickOnBookAppointment();

        Assert.assertEquals(summaryPage.getFacilityConfText(), "Hongkong CURA Healthcare Center");
        Assert.assertEquals(summaryPage.getApplyFHRText(), "Yes");
        Assert.assertEquals(summaryPage.getHealthCareProgramText(), "Medicaid");
        Assert.assertEquals(summaryPage.getVisitDateText(), "12/02/2023");
        Assert.assertEquals(summaryPage.getCommentText(), "Random comment");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
