import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.JobsPage;
import pages.LoginPage;
import utils.UseCaseBase;

import static org.junit.jupiter.api.Assertions.*;

public class JobsPageTest extends UseCaseBase {

    private static final Logger logger = LogManager.getLogger(JobsPageTest.class);

    private static JobsPage jobsPage;
    private static LoginPage loginPage;


    @BeforeAll
    public static void classSetup() {
        jobsPage = new JobsPage();
        loginPage = new LoginPage();
    }

    @BeforeEach
    public void beforeTest() {
        jobsPage.navigateToJobsPage();
        loginPage.loginEmailInput("alina_taksa@gmail.com");
        loginPage.loginPassInput("Qwerty12345");
        loginPage.signInAccount();
    }

    @Test
    public void TorontoJobsTest() {
        logger.info("search jobs in Toronto test");
        jobsPage.enterLocation("Toronto");
        jobsPage.pressSearchButton();
        Boolean isTorontoJobLoaded = jobsPage.isTorontoJobLoaded();
        jobsPage.takeScreenshot("JobsInToronto");
        assertTrue(isTorontoJobLoaded);
    }

    @Test
    public void TelAvivJobsTest() {
        logger.info("search jobs in Tel-Aviv test");
        jobsPage.enterLocation("Tel Aviv");
        jobsPage.pressSearchButton();
        Boolean isTelAvivJobsLoaded = jobsPage.isTelAvivJobLoaded();
        jobsPage.takeScreenshot("JobsInTelAviv");
        assertTrue(isTelAvivJobsLoaded);
    }

    @Test
    public void ChicagoJobsTest() {
        logger.info("search jobs in Chicago test");
        jobsPage.enterLocation("Chicago");
        jobsPage.pressSearchButton();
        Boolean isChicagoJobLoaded = jobsPage.isChicagoJobLoaded();
        jobsPage.takeScreenshot("JobsInChicago");
        assertTrue(isChicagoJobLoaded);
    }

    @Test
    public void searchQAPosition() {
        logger.info("search for QA position test");
        jobsPage.enterPosition("QA");
        jobsPage.pressSearchButton();
        Boolean isQAPositionLoaded = jobsPage.isQAJobLoaded();
        jobsPage.takeScreenshot("QAPositions");
        assertTrue(isQAPositionLoaded);
    }

    @Test
    public void searchDeveloperPosition() {
        logger.info("search for developer position test");
        jobsPage.enterPosition("Developer");
        jobsPage.pressSearchButton();
        Boolean isDeveloperPositionLoaded = jobsPage.isDeveloperJobLoaded();
        jobsPage.takeScreenshot("DeveloperPositions");
        assertTrue(isDeveloperPositionLoaded);
    }

    @Test
    public void searchProjectManagerPosition() {
        logger.info("search for project manager position test");
        jobsPage.enterPosition("Project Manager");
        jobsPage.pressSearchButton();
        Boolean isProjectManagerPositionLoaded = jobsPage.isProjectManagerJobLoaded();
        jobsPage.takeScreenshot("ProjectManagerPositions");
        assertTrue(isProjectManagerPositionLoaded);
    }

    @Test
    public void searchJobsAppleCompany() {
        logger.info("search for Apple company test");
        jobsPage.enterCompanyName("Apple");
        jobsPage.pressSearchButton();
        Boolean isAppleCompanyPositionLoaded = jobsPage.isCompanyJobLoaded("Apple");
        jobsPage.takeScreenshot("AppleCompanyJobs");
        assertTrue(isAppleCompanyPositionLoaded);
    }

    @Test
    public void searchJobsFacebookCompany() {
        logger.info("search for Facebook company test");
        jobsPage.enterCompanyName("Facebook");
        jobsPage.pressSearchButton();
        Boolean isFacebookCompanyPositionLoaded = jobsPage.isCompanyJobLoaded("Facebook");
        jobsPage.takeScreenshot("FacebookCompanyJobs");
        assertTrue(isFacebookCompanyPositionLoaded);
    }

    @Test
    public void searchJobsGoogleCompany() {
        logger.info("search for Google company test");
        jobsPage.enterCompanyName("Google");
        jobsPage.pressSearchButton();
        Boolean isGoogleCompanyPositionLoaded = jobsPage.isGoogleCompanyJobLoaded();
        jobsPage.takeScreenshot("GoogleCompanyJobs");
        assertTrue(isGoogleCompanyPositionLoaded);
    }

    @Test
    public void searchManagerPositionInGoogleInUSA() {
        logger.info("search for manager position in Google company in USA");
        jobsPage.enterPosition("Manager");
        jobsPage.enterCompanyName("Google");
        jobsPage.enterLocation("USA");
        jobsPage.pressSearchButton();
        Boolean isManagerPositionInGoogleInUSALoaded = jobsPage.isManagerPositionInGoogleCompanyInUSALoaded();
        jobsPage.takeScreenshot("ManagerPositionInGoogleInUSA");
        assertTrue(isManagerPositionInGoogleInUSALoaded);
    }

    @Test
    public void errorMessageNoResults() {
        logger.info("Empty jobs result error message test");
        jobsPage.enterPosition("dgyuoih");
        jobsPage.pressSearchButton();
        Boolean isErrMessageDisplayed = jobsPage.isErrNoResultMessageDisplayed();
        jobsPage.takeScreenshot("NoResultsFoundErrMassage");
        assertTrue(isErrMessageDisplayed);
    }

    @Test
    public void resetButtonTest() {
        logger.info("Reset button test");
        jobsPage.enterPosition("Developer");
        jobsPage.enterLocation("Toronto");
        jobsPage.enterCompanyName("Telus");
        jobsPage.checkAllSeniorityBoxes();//  // For some reason the manager option is not selected even though the class is the same

        // I created other methods that work, but there is too much text:
        jobsPage.clickJuniorOption();
        Boolean isJuniorChecked = jobsPage.isJuniorOptionSelected();
        assertTrue(isJuniorChecked);
        jobsPage.clickMidOption();
        Boolean isMidChecked = jobsPage.isMidOptionSelected();
        assertTrue(isMidChecked);
        jobsPage.clickSeniorOption();
        Boolean isSeniorChecked = jobsPage.isSeniorOptionSelected();
        assertTrue(isSeniorChecked);
        jobsPage.clickManagerOption();
        Boolean isManagerChecked = jobsPage.isManagerOptionSelected();
        assertTrue(isManagerChecked);
        jobsPage.pressResetButton();
        Boolean isPositionFieldEmpty = jobsPage.isPositionFieldEmpty();
        assertTrue(isPositionFieldEmpty);
        Boolean isCompanyFieldEmpty = jobsPage.isCompanyFieldEmpty();
        assertTrue(isCompanyFieldEmpty);
        Boolean isLocationFieldEmpty = jobsPage.isLocationFieldEmpty();
        assertTrue(isLocationFieldEmpty);
        Boolean isJuniorUnChecked = jobsPage.isJuniorUnchecked();
        assertTrue(isJuniorUnChecked);
        Boolean isMidUnChecked = jobsPage.isMidUnchecked();
        assertTrue(isMidUnChecked);
        Boolean isSeniorUnChecked = jobsPage.isSeniorUnchecked();
        assertTrue(isSeniorUnChecked);
        Boolean isManagerUnChecked = jobsPage.isManagerUnchecked();
        assertTrue(isManagerUnChecked);
        jobsPage.takeScreenshot("PositionFieldIsEmpty");
    }

}
