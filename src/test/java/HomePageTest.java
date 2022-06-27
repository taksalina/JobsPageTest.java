import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import utils.UseCaseBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends UseCaseBase {

    private static HomePage homePage;
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);

    @BeforeAll
    public static void classSetUp() {
        homePage = new HomePage();
    }

    @BeforeEach
    public void testSetUp() {
        homePage.navigateToHomePage();
    }

    @Test
    public void mainPageLoadTest() {
        logger.info("'home' page load test");
        Boolean success = homePage.isLogoImgVisible();
        homePage.takeScreenshot("HomePageTest");
        assertTrue(success);
    }

    @Test
    public void mainPageImgLoadTest() {
        logger.info("'Coming soon' image load test");
        Boolean isLoaded = homePage.isComingSoonImgVisible();
        homePage.takeScreenshot("ComingSoonImg");
        assertTrue(isLoaded);
    }

    @Test
    public void openAboutUsPageTest() {
        logger.info("'about us' page load test");
        homePage.openAboutUsPage();
        Boolean isAboutUsPageLoaded = homePage.isAboutUsLogoVisible();
        homePage.takeScreenshot("AboutUsLogo");
        assertTrue(isAboutUsPageLoaded);

    }

    @Test
    public void openJobsPageTest() {
        logger.info("'jobs' page load test");
        homePage.openJobsPage();
        Boolean isJobsLogoVisible = homePage.isJobsLogoVisible();
        homePage.takeScreenshot("LoginLogo");
        assertTrue(isJobsLogoVisible);

    }

}
