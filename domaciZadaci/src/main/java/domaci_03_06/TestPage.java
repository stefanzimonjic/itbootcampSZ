package domaci_03_06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPage {

    private WebDriver driver;
    private AddCustomer addCustomer;
    private BankManagerPage bankManagerPage;
    private CustomerLoginPage customerLoginPage;
    private CustomerPage customerPage;
    private LoginPage loginPage;
    private OpenAccount openAccount;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\38161\\Documents\\STEFAN\\chromedriver.exe");
        driver = new ChromeDriver();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        addCustomer = new AddCustomer(driver, webDriverWait);
        bankManagerPage = new BankManagerPage(driver, webDriverWait);
        customerLoginPage = new CustomerLoginPage(driver, webDriverWait);
        customerPage = new CustomerPage(driver, webDriverWait);
        loginPage = new LoginPage(driver, webDriverWait);
        openAccount = new OpenAccount(driver, webDriverWait);

        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    //    Test 1: Logovanje kao Bank Manager
    @Test(priority = 1)
    public void loginAsBankManager() {
        loginPage.clickManagerLogin();
        Assert.assertTrue(loginPage.isDisplayedAddCustomer());
    }

//    Test 2: Kreiranje Customera

    @Test(priority = 2)
    public void createCustomer() {
        bankManagerPage.clickAddCustomer();
        addCustomer.addCustomerFirstName("Stefan");
        addCustomer.addCustomerLastName("Zimonjic");
        addCustomer.addCustomerPostCode("21000");
        addCustomer.clickOnAddCustomerBtn();
        Assert.assertTrue(addCustomer.popUpWindowContains("Customer added successfully"));
        addCustomer.popUpWindowOk();
    }

    //    Test 3: Kreiranje Accounta za tog Customera
    @Test(priority = 3)
    public void createAccountForCustomer() {
        bankManagerPage.clickOpenAccount();
        openAccount.selectCustomer("Stefan Zimonjic");
        openAccount.selectCurrency(Currency.Dollar);
        openAccount.clickOnProcess();
        Assert.assertTrue(addCustomer.popUpWindowContains("Account created successfully"));
        openAccount.popUpWindowOk();
    }

    //    Test 4: Logovanje kao Customer
    @Test(priority = 4)
    public void loginAsCustomer() {
        loginPage.clickHomeBtn();
        loginPage.clickCustomerLogin();
        customerLoginPage.selectCustomer("Stefan Zimonjic");
        customerLoginPage.clickLogin();
//        System.out.println(customerPage.welcomeCustomerMessage());
        Assert.assertEquals(customerPage.welcomeCustomerMessage(), "Welcome Stefan Zimonjic !!");
    }

    //    Test 5: Uspešan Deposit za nekog Customera
    @Test(priority = 5)
    public void customerDeposit() {
        customerPage.clickOnDeposit();
        customerPage.enterAmountToDeposit("120000");
        customerPage.clickSubmitDeposit();
        Assert.assertEquals(customerPage.accountBalance(), "120000");
    }

    //    Test 6: Uspešan Withdrawal za nekog Customera
    @Test(priority = 6)
    public void customerWithdrawl() {
        customerPage.clickOnWithdrawal();
        customerPage.enterAmountToWithdrawal("120000");
        customerPage.clickSubmitWithdrawal();
        Assert.assertEquals(customerPage.accountBalance(), "0");
    }
//    Test 7: Logout za Bank Managera
//    Nema smisla logout za bank managera, jer i kada se omoguci dugme logout dok smo unutar segmenta bank manager login,
//    klikom na logout prelazi se na selektovanje customera, isti efekat kao i sa home button


    //    Test 8: Logout za Customera*/
    @Test(priority = 7)
    public void customerLogout() {
        customerPage.logoutCustomer();
        Assert.assertFalse(customerPage.isLogoutButtonDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
