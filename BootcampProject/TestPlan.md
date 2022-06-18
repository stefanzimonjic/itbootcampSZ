# TEST PLAN FOR [DEMOQA.COM](https://demoqa.com)

## 1. Introduction

This project represents the final project that was assigned to me during IT Bootcamp course.
The test plan describes and explains the approach to testing the website [demoqa.com](https://demoqa.com).

## 2. Test object

[demoqa.com](https://demoqa.com) is a basic demo site provided by [toolsqa.com](https://www.toolsqa.com) to learn and practice Selenium. It contains training modules like contact forms, menus to select, buttons to click etc. Only chosen features are going to be tested.

## 3. Features to be tested

| Module | Description |
| ----- | --------- |
| `Elements section:` |
| Text Box | A Textbox fill form with text fields and submit button  |
| Radio Button | Three radio buttons with confirmation messages after selection |
| Buttons | Double click button, right click button, single click button |
| `Alerts, Frame and Windows section:` |
| Browser Windows | Three buttons that open a new tab, a new window, and a new window with a message |
| Alerts | Four buttons with a different types of alert messages |
| Modal Dialogs | A button that opens a small modal dialog, and a button that opens large modal dialog |


## 4. Test objective

The test objective is to test the functionalities and to learn an end-to-end testing process with Selenium Webdriver.

## 5. Testing criteria

### 5.1 Test entry criteria

The test plan and test cases are prepared and the environment is set up.

### 5.2 Test exit criteria

Run rate is mandatory to be 100%. Mandatory pass rate is not defined, because the test object is a basic demo website.

## 6. Test environment

The tests are going to be performed on the Google Chrome web browser, version 102.0.5005.61 (official version) (64-bit) - access on 18 Jun 2022,
with chromedriver that matches that Chrome version.

The tests are going to be run in IntelliJ IDEA 2021.3.3 (\Community Edition)\

Operation system is Edition	Windows 11 Pro
Version	21H2
OS build	22000.739
Experience	Windows Feature Experience Pack 1000.22000.739.0

## 7. Dependencies used

Selenium version 4.1.4
Testng version 7.5
Lombok 1.18.24
