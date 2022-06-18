package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class ElementsTests extends BaseTests {

    /**
     * Method verifies that when Elements section is clicked, Elements window is opened.
     * Method asserts that expected list of menu bar items is identical as actual list of menu bar items,
     * and that header has a title Elements
     */
    @Test(priority = 1)
    public void verifyElementsPage() {
        getHomePage().clickOnElements();
        ArrayList<String> expectedListOfContent = new ArrayList<>(Arrays.asList("Text Box", "Check Box", "Radio Button",
                "Web Tables", "Buttons", "Links", "Broken Links - Images", "Upload and Download", "Dynamic Properties"));
        Assert.assertEquals(getElementsPage().menuContent(), expectedListOfContent);
        Assert.assertEquals(getElementsPage().elementsHeader(), "Elements");
    }

    /**
     *This method asserts that yes radio button is clicked,
     *and after it, when impressive radio button is clicked, that is the only button that is left selected
     */
    @Test (priority = 2)
    public void verifyRadioButtonsYesAndImpressive() {
        getHomePage().clickOnElements();
        getRadioButton().clickOnRadioButton();
        getRadioButton().clickOnYesRadio();
        Assert.assertEquals(getRadioButton().responseText(), "You have selected Yes");
        getRadioButton().clickOnImpressiveRadio();
        Assert.assertEquals(getRadioButton().responseText(), "You have selected Impressive");
        Assert.assertFalse(getRadioButton().yesIsSelected());
        Assert.assertFalse(getRadioButton().noIsSelected());
        Assert.assertTrue(getRadioButton().impressiveIsSelected());
    }

    /**
     * This method clicks on all buttons form section Buttons, and assert clicks
     */
    @Test (priority = 3)
    public void verifyAllButtons () {
        getHomePage().clickOnElements();
        getButtons().clickOnButtons();
        getButtons().doubleClickOnDoubleClick();
        getButtons().rightClickOnRightClickBtn();
        getButtons().clickOnClickMe();
        ArrayList<String> actualListOfActions = new ArrayList<>(Arrays.asList("You have done a double click",
                "You have done a right click", "You have done a dynamic click"));
        Assert.assertEquals(getButtons().clickMsg(), actualListOfActions);
    }

    /**
     * Method verifies that when double click button is clicked nothing happens, and when double-clicked
     * on double click correct message appears
     */
    @Test (priority = 4)
    public void verifyWhenCLickedOnDoubleClickNothingHappens (){
        getHomePage().clickOnElements();
        getButtons().clickOnButtons();
        getButtons().clickOnDoubleClick();
        Assert.assertNull(getButtons().clickMsg());
        getButtons().doubleClickOnDoubleClick();
        Assert.assertEquals(getButtons().clickMsg().toString(), "[You have done a double click]");
    }
    /**
     * Method verifies that when right click button is double-clicked nothing happens
     */
    @Test (priority = 5)
    public void verifyWhenDoubleCLickedOnRightClickNothingHappens (){
        getHomePage().clickOnElements();
        getButtons().clickOnButtons();
        getButtons().doubleClickOnRightClick();
        Assert.assertNull(getButtons().clickMsg());
    }
    /**
     * Method that verifies that data entered in text box is submitted
     */
    @Test (priority = 6)
    public void textBoxTest (){
        getHomePage().clickOnElements();
        getTextBox().clickOnTextBox();
        getTextBox().enterData();
        Assert.assertNotNull(getTextBox().confirmationText());
    }
}
