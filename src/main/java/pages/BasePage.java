package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class BasePage {
    private static final Logger logger = LogManager.getLogger(BasePage.class);


    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

    }

    protected void clickElementByXpath(String xpath) {
        logger.info("Clicking element with xpath" + xpath);
        findElementByXpath(xpath).click();
    }

    protected void sendTextToElementByXpath(String xpath, String text) {
        findElementByXpath(xpath).sendKeys(text);
    }

    protected boolean elementExist(String xpath) {
        try {
            logger.info("Check element with xpath exists:" + xpath);
            // findElementByXpath(xpath);
            webDriver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    protected WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    protected boolean isChecked(String xpath) {
        boolean isChecked = false;
        WebElement checkbox;
        checkbox = webDriver.findElement(By.xpath(xpath));
        if (!checkbox.isSelected()) ;
        return true;

    }

    protected boolean isUnChecked(String xpath) {
        boolean isChecked = false;
        WebElement checkbox;
        checkbox = webDriver.findElement(By.xpath(xpath));
        if (checkbox.getAttribute("checked") != null) ;
        return true;

    }

    protected String getCurrentPageURL() {
        return webDriver.getCurrentUrl();
    }

    public void takeScreenshot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshots/" + name + ".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected boolean emptyField(String xpath) {
        try {
            logger.info("The field is empty" + xpath);
            // findElementByXpath(xpath);
            webDriver.findElement(By.xpath(xpath));
            return false;
        } catch (Exception err) {
            return true;
        }
    }

    public void checkAllBoxes(String xpath) {
        List<WebElement> els = webDriver.findElements(By.xpath(xpath));
        for (WebElement el : els) {
            if (!el.isSelected()) {
                el.click();
            }
        }
    }

}