package domaci_04_06;

/*AppointmentPage
o   getter za facility select
o   getter za apply for hospital readmission
o   getter za radio dugme (trazeno po value atributu)
§ xpath-u - kao parametar se prima value za trazeno radio dugme
§ //*[@name='programs'][@value='"+ radioInputName +"']
o   getter za visit date input
o   getter za comment input
o   getter za book appointment button
o   metodu isFormPresented() koja vraca informaciju da li je ucitan element id="appointment", (iskoriste logiku preko liste, ako je lista prazna element nije na stanici)
Napomena: Datum se takodje postavlja preko metode sendKeys samo je potrebno datum uneti u formatu
 "dd/mm/yyyy" => npr: "21/09/2020"
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentPage extends BasePage {

    private By facilitySelect = By.id("combo_facility");
    private By checkBoxApplyFHR = By.id("chk_hospotal_readmission");
    private By radioBtnMedicare = By.id("radio_program_medicare");
    private By radioBtnMedicaid = By.id("radio_program_medicaid");
    private By radioBtnNone = By.id("radio_program_none");
    private By visitDateInput = By.id("txt_visit_date");
    private By commentInput = By.id("txt_comment");
    private By bookAppointment = By.id("btn-book-appointment");


    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public boolean isFormPresented() {
        return getDriver().findElement(By.id("appointment")).isDisplayed();
    }

    public void selectFacility(int index) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(facilitySelect));
        Select facilitySelect = new Select(getDriver().findElement(this.facilitySelect));
        facilitySelect.selectByIndex(index);
    }

    public void checkBoxApplyFHR() {
        boolean isBoxChecked = getDriver().findElement(this.checkBoxApplyFHR).isSelected();
        if (!isBoxChecked) {
            getDriver().findElement(checkBoxApplyFHR).click();
        }
    }

    public void clickRadioBtnMedicare() {
        boolean isBoxChecked = getDriver().findElement(this.radioBtnMedicare).isSelected();
        if (!isBoxChecked) {
            getDriver().findElement(radioBtnMedicare).click();
        }
    }
    public void clickRadioBtnMedicaid() {
        boolean isBoxChecked = getDriver().findElement(this.radioBtnMedicaid).isSelected();
        if (!isBoxChecked) {
            getDriver().findElement(radioBtnMedicaid).click();
        }
    }
    public void clickRadioBtnNone() {
        boolean isBoxChecked = getDriver().findElement(this.radioBtnNone).isSelected();
        if (!isBoxChecked) {
            getDriver().findElement(radioBtnNone).click();
        }
    }

    public void visitDateInputSet(String date){
        getDriver().findElement(this.visitDateInput).sendKeys(date);
    }

    public void commentInputSet (String comment){
        getDriver().findElement(commentInput).sendKeys(comment);
    }

    public void clickOnBookAppointment(){
        getDriver().findElement(bookAppointment).click();
    }

}