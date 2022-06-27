package pages;

public class LoginPage extends BasePage {
    private static final String LOGIN_EMAIL_INPUT = "//input[@name = 'username']";
    private static final String LOGIN_PASS_INPUT = "//input[@name = 'password']";
    private static final String LOG_IN_BUTTON = "//button[@type = 'submit']";
    private static final String FILTER_ELEM = "//*[text () = 'Filters']";

    public void loginEmailInput(String email) {
        sendTextToElementByXpath(LOGIN_EMAIL_INPUT, email);
    }

    public void loginPassInput(String password) {
        sendTextToElementByXpath(LOGIN_PASS_INPUT, password);
    }

    public void signInAccount() {
        clickElementByXpath(LOG_IN_BUTTON);
    }

    public boolean isFilterVisible() {
        return elementExist(FILTER_ELEM);
    }
}
