package pages;

import constants.Constantss;

public class HomePage extends BasePage {

    public static final String COMING_SOON_IMG = "//img[@src='/img/JC_comingSoon.jpg']";
    private static final String HOME_IMG_OPTION = "//*[text() ='Home']";
    private static final String ABOUT_US_OPTION = "//a[@id='2']";
    private static final String ABOUT_US_LOGO = "//*[text() = 'About Us']";
    private static final String JOBS_OPTION = "//a[@id='3']";
    private static final String JOBS_LOGO = "//div[@class = 'd-flex justify-content-between align-items-center']";
    private static final String LOG_IN_OPTION = "//a[text() = 'Log In']";


    public void navigateToHomePage() {
        webDriver.get(Constantss.HOME_URL);
    }

    public boolean isLogoImgVisible() {
        return elementExist(HOME_IMG_OPTION);

    }

    public boolean isComingSoonImgVisible() {
        return elementExist(COMING_SOON_IMG);
    }

    public void openAboutUsPage() {
        clickElementByXpath(ABOUT_US_OPTION);
    }

    public boolean isAboutUsLogoVisible() {
        return elementExist(ABOUT_US_LOGO);
    }

    public void openJobsPage() {
        clickElementByXpath(JOBS_OPTION);
    }

    public boolean isJobsLogoVisible() {
        return elementExist(JOBS_LOGO);
    }

    public void openLogInPage() {
        clickElementByXpath(LOG_IN_OPTION);
    }
}


