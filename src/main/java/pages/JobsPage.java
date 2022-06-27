package pages;

import constants.Constantss;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JobsPage extends BasePage {
    private static final String LOCATION_INPUT = "//input[@name = 'location']";
    private static final String Position_INPUT = "//input[@name = 'position']";
    private static final String COMPANY_INPUT = "//input[@name = 'company']";
    private static final String SEARCH_BUTTON = "//*[text()='search']";
    private static final String RESET_BUTTON = "//*[text()='reset']";
    private static final String TORONTO_JOBS = "//*[text()='Toronto, ON, Canada']";
    private static final String TEL_AVIV_JOBS = "//*[text()='Tel Aviv-Yafo, Israel']";
    private static final String CHICAGO_JOBS = "//*[text()='Chicago, IL, USA']";
    private static final String QA_POSITION = "//*[text()='Senior QA Automation Engineer']";
    private static final String DEVELOPER_POSITION = "//*[text()='Web Developer']";
    private static final String PROJECT_MANAGER_POSITION = "//*[text()='Project Manager']";
    private static final String APPLE_COMPANY = "//*[text()='Apple']";
    private static final String FACEBOOK_COMPANY = "//*[text()='Facebook App']";
    private static final String GOOGLE_COMPANY = "//*[text()='Google']";
  // private static final String JOBS_LIST = "//h2[@class='post-item clearfix']";
    private static final String JOBS_LIST = "//h2[@class='entry-content']";


    private static final String ERR_MESSAGE_EMPTY_JOB_RESULT = "//*[text() ='No results found!']";
    private static final String JUNIOR_CHECK_BOX = "//*[@class='PrivateSwitchBase-input css-1m9pwf3'][@id='junior']";
    private static final String CHECK_BOXES = "//*[@class='PrivateSwitchBase-input css-1m9pwf3']";
    private static final String MID_CHECK_BOX = "//*[@class='PrivateSwitchBase-input css-1m9pwf3'][@id='mid']";
    private static final String SENIOR_CHECK_BOX = "//*[@class='PrivateSwitchBase-input css-1m9pwf3'][@id='senior']";
    private static final String MANAGER_CHECK_BOX = "//*[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-9l3uo3']";

    public void navigateToJobsPage() {
        webDriver.get(Constantss.JOBS_PAGE_URL);
    }

    public void enterPosition(String position) {
        sendTextToElementByXpath(Position_INPUT, position);
    }

    public void enterCompanyName(String company) {
        sendTextToElementByXpath(COMPANY_INPUT, company);
    }

    public void pressSearchButton() {
        WebElement element = findElementByXpath(SEARCH_BUTTON);
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void pressResetButton() {
        WebElement element = findElementByXpath(RESET_BUTTON);
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", element);
    }

    public boolean isTorontoJobLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_LIST)));
        return elementExist(TORONTO_JOBS);
    }

    public void enterLocation(String city) {
        sendTextToElementByXpath(LOCATION_INPUT, city);
    }

    public boolean isTelAvivJobLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_LIST)));
        return elementExist(TEL_AVIV_JOBS);
    }

    public boolean isChicagoJobLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_LIST)));
        return elementExist(CHICAGO_JOBS);
    }

    public boolean isQAJobLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_LIST)));
        return elementExist(QA_POSITION);
    }

    public boolean isDeveloperJobLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_LIST)));
        return elementExist(DEVELOPER_POSITION);
    }

    public boolean isProjectManagerJobLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_LIST)));
        return elementExist(PROJECT_MANAGER_POSITION);
    }

//    public boolean isAppleCompanyJobLoaded() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_LIST)));
//        return elementExist(APPLE_COMPANY);
//    }
    public boolean isCompanyJobLoaded(String companyName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_LIST)));
        return elementExist(String.format("//*[text()='%s']",companyName));

    }

    public boolean isFacebookCompanyJobLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_LIST)));
        return elementExist(FACEBOOK_COMPANY);
    }

    public boolean isGoogleCompanyJobLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_LIST)));
        return elementExist(GOOGLE_COMPANY);
    }

    public boolean isManagerPositionInGoogleCompanyInUSALoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_LIST)));
        return elementExist(GOOGLE_COMPANY);
    }

    public boolean isErrNoResultMessageDisplayed() {
        return elementExist(ERR_MESSAGE_EMPTY_JOB_RESULT);
    }

    public void clickJuniorOption() {
        clickElementByXpath(JUNIOR_CHECK_BOX);
    }

    public boolean isJuniorOptionSelected() {
        return isChecked(JUNIOR_CHECK_BOX);
    }

    public void clickMidOption() {
        clickElementByXpath(MID_CHECK_BOX);
    }

    public boolean isMidOptionSelected() {
        return isChecked(MID_CHECK_BOX);
    }

    public void clickSeniorOption() {
        clickElementByXpath(SENIOR_CHECK_BOX);
    }

    public boolean isSeniorOptionSelected() {
        return isChecked(SENIOR_CHECK_BOX);
    }

    public void clickManagerOption() {
        clickElementByXpath(MANAGER_CHECK_BOX);
    }

    public boolean isManagerOptionSelected() {
        return isChecked(MANAGER_CHECK_BOX);
    }

    public boolean isPositionFieldEmpty() {
        return emptyField(PROJECT_MANAGER_POSITION);
    }

    public boolean isLocationFieldEmpty() {
        return emptyField(TORONTO_JOBS);
    }

    public boolean isCompanyFieldEmpty() {
        return emptyField(APPLE_COMPANY);
    }

    public boolean isJuniorUnchecked() {
        return isUnChecked(JUNIOR_CHECK_BOX);
    }

    public boolean isMidUnchecked() {
        return isUnChecked(MID_CHECK_BOX);
    }

    public boolean isSeniorUnchecked() {
        return isUnChecked(SENIOR_CHECK_BOX);
    }

    public boolean isManagerUnchecked() {
        return isUnChecked(MANAGER_CHECK_BOX);
    }

    public void checkAllSeniorityBoxes() {
        checkAllBoxes(CHECK_BOXES);

    }
}