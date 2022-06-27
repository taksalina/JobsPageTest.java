import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.UseCaseBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends UseCaseBase {

    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    private static HomePage homePage;
    private static LoginPage loginPage;


    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @BeforeEach
    public void beforeTest() {
        homePage.navigateToHomePage();
        homePage.openLogInPage();
    }

    @Test
    public void Sign_In_Account() {
        logger.info("login into account test");
        loginPage.loginEmailInput("alinataksa@gmail.com");
        loginPage.loginPassInput("Qwerty12345");
        loginPage.signInAccount();
        Boolean isFilterVisible = loginPage.isFilterVisible();
        loginPage.takeScreenshot("JobsSearch");
        assertTrue(isFilterVisible);
    }


}
