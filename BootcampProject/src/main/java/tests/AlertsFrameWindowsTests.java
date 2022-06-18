package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class AlertsFrameWindowsTests extends BaseTests {

    /**
     * Method verifies that header of page is as actual header, and that list of elements in menu is correct
     */
    @Test (priority = 1)
    public void verifyAlertsFrameWindowsPage(){
        getHomePage().clickOnAlertsFrameWindows();
        Assert.assertEquals(getAlertsFramWindowPage().elementsHeader(), "Alerts, Frame & Windows");
        ArrayList<String> actualContent = new ArrayList<>(Arrays.asList("Browser Windows", "Alerts", "Frames", "Nested Frames", "Modal Dialogs"));
        Assert.assertEquals(getAlertsFramWindowPage().menuContent(), actualContent);
    }

    /**
     * Method verifies when clickMe button is clicked confirm box is presented,
     * and when accepted, correct message is presented
     */
    @Test (priority = 2)
    public void verifyClickMeButtonWithConfirmBox(){
        getHomePage().clickOnAlertsFrameWindows();
        getAlerts().clickOnAlerts();
        getAlerts().clickOnClickMeConfirmBoxBtn();
        Assert.assertTrue(getAlerts().alertIsPresent());
        Assert.assertEquals(getAlerts().popupWindowGetText(), "Do you confirm action?");
        getAlerts().popupWindowAccept();
        Assert.assertEquals(getAlerts().clickMeConfirmBoxAcceptMsg(), "You selected Ok");
    }
    /**
     * Method verifies when clickMe button is clicked confirm box is presented,
     * and when dismissed, correct message is presented
     */
    @Test (priority = 3)
    public void verifyClickMeButtonWithConfirmBoxAndClickCancel(){
        getHomePage().clickOnAlertsFrameWindows();
        getAlerts().clickOnAlerts();
        getAlerts().clickOnClickMeConfirmBoxBtn();
        Assert.assertTrue(getAlerts().alertIsPresent());
        Assert.assertEquals(getAlerts().popupWindowGetText(), "Do you confirm action?");
        getAlerts().popupWindowDismiss();
        Assert.assertEquals(getAlerts().clickMeConfirmBoxAcceptMsg(), "You selected Cancel");
    }
    /**
     * Method verifies that when clicked on click me button (with alert appearing after 5 seconds),
     * alert message appears after 5 seconds
     */
    @Test (priority = 4)
    public void verifyClickMeButtonWithAlertAfter5Seconds(){
        getHomePage().clickOnAlertsFrameWindows();
        getAlerts().clickOnAlerts();
        getAlerts().clickOnClickBtnWithAlertAfter5s();
        Assert.assertTrue(getAlerts().alertIsPresent());
        Assert.assertEquals(getAlerts().popupWindowGetText(), "This alert appeared after 5 seconds");
        getAlerts().popupWindowAccept();
    }

    /**
     * Method asserts that when clicked on clik me button (with prompt message alert), prompt message is displayed,
     * and when name is entered, prompt box message confirms that that name is written.
     *
     */
    @Test (priority = 5)
    public void verifyTextWrittenInPromptMessage(){
        getHomePage().clickOnAlertsFrameWindows();
        getAlerts().clickOnAlerts();
        getAlerts().clickOnClickBtnWithPromptMsg();
        Assert.assertTrue(getAlerts().alertIsPresent());
        getAlerts().enterPromptMsg("Random text");
        Assert.assertTrue(getAlerts().promptMsgConfirmMsg().contains("Random text"));
    }

    /**
     * Verify that new window is opened by clicking on New Window button, by asserting the title of new window
     */
    @Test (priority = 6)
    public void verifyNewWindowButton() {
        getHomePage().clickOnAlertsFrameWindows();
        Assert.assertEquals(getBrowserWindows().getTitleOfNewWindow(), "This is a sample page");
    }

    /**
     * Method verifies that when Small Modal button is clicked, small modal with text pops out, and Assert it
     */
    @Test (priority = 7)
    public void verifySmallModalButton() {
        getHomePage().clickOnAlertsFrameWindows();
        getModalDialogs().clickOnModalDialogs();
        getModalDialogs().clickOnSmallModalBtn();
        Assert.assertEquals(getModalDialogs().smallModalText(), "Small Modal");
        getModalDialogs().smallModalClose();
    }

    /**
     * Method verifies that when Large Modal button is clicked, large modal with text pops out, and Assert it
     */
    @Test (priority = 8)
    public void verifyLargeModalButton(){
        getHomePage().clickOnAlertsFrameWindows();
        getModalDialogs().clickOnModalDialogs();
        getModalDialogs().clickOnLargeModalButton();
        Assert.assertEquals(getModalDialogs().largeModalText(), "Large Modal");
        getModalDialogs().largeModalClose();
    }
}
